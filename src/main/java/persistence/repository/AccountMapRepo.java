package persistence.repository;


import persistence.domain.Account;
import util.AccountToJSON;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.HashMap;

@Alternative
public class AccountMapRepo implements IAccountDB{

    HashMap<String, Account> accountMap;

    @Inject
    AccountToJSON jUtil;

    public String getAccountById(String accNum){
        return jUtil.objToJson(accountMap.get(accNum));
    }

    @Override
    public String getAllAccounts(){
        return jUtil.objToJson(accountMap);
    }

    @Override
    public String createAccount(String account) {
        Account newAcc = jUtil.jsonToObj(account, Account.class);
        accountMap.put(newAcc.getAccountNumber(), newAcc);
        return "{\"message\": \"account has been successfully added\"}";
    }

    @Override
    public String deleteAccount(String accNum) {
        accountMap.remove(accNum);
        return "{\"message\": \"account has been successfully deleted\"}";
    }

    @Override
    public String updateAccount(String account) {
//        Account updatingAcc = accountMap.get(accNum);
//        String newFName = (first!=null)? first :updatingAcc.getFirstName();
//        String newLName = (last!=null)? last :updatingAcc.getLastName();
//        String newAccNum = updatingAcc.getAccountNumber();
//        updatingAcc = new Account(newAccNum, newFName, newLName);
//        accountMap.put(newAccNum, updatingAcc);
        return "{\"message\": \"account has been successfully updated\"}";
    }

}
