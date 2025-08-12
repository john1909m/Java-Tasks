package Service;

import Model.Account;

public interface AccountService {
    Boolean createAccount(Account account);
    Account getAccount(Account account);
    Boolean deposit(Account account, double amount);
    Boolean withdraw(Account account, double amount);
    Boolean Transfer(Account sender,String usernameAcceptor, double amount);
}
