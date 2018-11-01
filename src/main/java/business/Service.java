package business;

import persistence.repository.AccountDBRepo;
import persistence.repository.IAccountDB;

import javax.inject.Inject;


public class Service {

    @Inject
    private IAccountDB repo;

    public Service(){

    }

    public String getAllAccounts(){
        return repo.getAllAccounts();
    }

    public String createAccount(String account) {
        return repo.createAccount(account);
    }

    public String deleteAccount(String accNum){
        return repo.deleteAccount(accNum);
    }

    public String updateAccount(String account){
        return repo.updateAccount(account);
    }

    public String getAccountById(String accNum){
        return repo.getAccountById(accNum);
    }

}
