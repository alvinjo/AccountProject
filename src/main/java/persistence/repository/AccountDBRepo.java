package persistence.repository;

import persistence.domain.Account;
import util.AccountToJSON;

import javax.inject.Inject;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;


@Transactional(SUPPORTS)
@Default
public class AccountDBRepo {


    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private AccountToJSON jUtil;


    public String getAllAccounts() {
        Query query = manager.createQuery("select a from Account a");
        Collection<Account> accounts = (Collection<Account>) query.getResultList();

        return jUtil.objToJson(accounts);
    }

    @Transactional(REQUIRED)
    public String createAccount(String account){
        Account anAccount = jUtil.jsonToObj(account, Account.class);
        manager.persist(anAccount);
        return "{\"message\": \"account has been successfully added\"}";
    }

/*    @Transactional(REQUIRED)
    public String deleteAccount(String accNum){
        Account searchAccount = findAccount(accNum);
        if(searchAccount != null){
            manager.remove(searchAccount);
        }else{
            return "{\"message\": \"account not found\"}";
        }
        return "{\"message\": \"account has been successfully deleted\"}";
    }*/

/*    //not scalable
    @Transactional(REQUIRED)
    public String updateAccount(String accNum, String first, String last){
        Account updatingAccount = findAccount(accNum);
        if(first != null){
            updatingAccount.setFirstName(first);
        }
        if(last != null){
            updatingAccount.setLastName(last);
        }
//        manager.persist(updatingAccount);
        return "account updated";
    }*/

/*    @Transactional(REQUIRED)
    public String update(String accNum, String first, String last){
        Account updatingAcc = findAccount(accNum);
        String newFName = updatingAcc.getFirstName();
        String newLName = updatingAcc.getLastName();
        String newAccNum = updatingAcc.getAccountNumber();
        manager.remove(updatingAcc);
        manager.persist(new Account(newFName,newLName, newAccNum));
        return "account updated";
    }*/

    private Account findAccount(String accNum) {
        return manager.find(Account.class, accNum);
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

/*    public void setJUtil(AccountToJSON jUtil) {
        this.jUtil = jUtil;
    }*/


}
