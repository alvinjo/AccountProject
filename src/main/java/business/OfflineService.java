/*
package business;

import persistence.domain.Account;
import persistence.repository.AccountMapRepo;
import util.AccountToJSON;

import java.util.HashMap;
import java.util.Map;

public class OfflineService {

    HashMap<String, Account> accountMap;
    AccountMapRepo repo;

    public OfflineService(){
        accountMap = new HashMap<>();
        repo = new AccountMapRepo();
    }


    public Account getAccount(int accNum){
        return accountMap.get(accNum);
    }

    //delete
    public String getAllAccounts(){
        return repo.getAllAccounts();
    }

    public void putAccount(Account account){
        accountMap.put(account.getAccountNumber(), account);
    }

    public void addAndPutAccount(String first, String last, String acc){
        accountMap.put(acc, new Account(first, last, acc));
    }

    public void removeAccount(int accNum){
        accountMap.remove(accNum);
    }

    public Map<String, Account> getMap(){
        return accountMap;
    }

    public String getJsonFromMap(){
        AccountToJSON converter = new AccountToJSON(accountMap);
        return converter.toJSON();
    }

    public int numOfAccountsWithName(String name){
        return (int)accountMap.entrySet().stream().filter(a -> a.getValue().getFirstName().equals(name)).count();
    }


}
*/
