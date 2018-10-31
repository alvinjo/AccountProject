package persistence.repository;

import persistence.domain.Account;
import util.AccountToJSON;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Collection;

import static javax.transaction.Transactional.TxType.SUPPORTS;


@Transactional(SUPPORTS)
@Default
public class AccountDBRepo {


    @PersistenceContext(unitName = "primary")
    private EntityManager manager;

    @Inject
    private AccountToJSON util;

    public String getAllAccounts() {
        Query query = manager.createQuery("select a from Account a");
        Collection<Account> accounts = (Collection<Account>) query.getResultList();

        return util.objToJson(accounts);
    }


    private Account findAccount(Long id) {
        return manager.find(Account.class, id);
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void setUtil(AccountToJSON util) {
        this.util = util;
    }


}
