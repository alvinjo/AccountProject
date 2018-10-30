package accounts;

import java.util.HashMap;
import java.util.Map;

public class Service {


    HashMap<String, Account> accountMap;

    public Service(){
        accountMap = new HashMap<>();
    }

    public Account getAccount(int accNum){
        return accountMap.get(accNum);
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

}
