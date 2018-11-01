package business;

import persistence.repository.AccountDBRepo;
import util.AccountToJSON;
import persistence.domain.Account;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class Service {


    HashMap<String, Account> accountMap;

    @Inject
    private AccountDBRepo repo;

    public Service(){
        accountMap = new HashMap<>();
    }

    public Account getAccount(int accNum){
        return accountMap.get(accNum);
    }

    public void putAccount(Account account){
        accountMap.put(account.getAccountNumber(), account);
    }

    public String createAccount(String account){
        return repo.createAccount(account);
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

    public String getAllAccounts(){
        return repo.getAllAccounts();
    }

}
