package persistence.repository;

public interface IAccountDB {

    String getAllAccounts();
    String createAccount(String account);
    String deleteAccount(String accNum);
    String updateAccount(String account);
    String getAccountById(String accNum);

}
