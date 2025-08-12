package Service.Impl;

import Model.Account;
import Model.EWalletSystem;
import Service.AccountService;

public class AccountServiceImpl implements AccountService {


    private EWalletSystem eWalletSystem;
    public AccountServiceImpl(EWalletSystem eWalletSystem) {
        this.eWalletSystem = eWalletSystem;
    }
    @Override
    public Boolean createAccount(Account account){
        for(Account a:eWalletSystem.getAccounts()){
            if(a.getUsername().equals(account.getUsername()) || a.getPassword().equals(account.getPassword())){
                return false;
            }
        }
        eWalletSystem.getAccounts().add(account);
        return true;
    };
    @Override
    public Account getAccount(Account account){
        for(Account acc : eWalletSystem.getAccounts()){
            if(acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword())){
                return acc;
            }
        }
        return null;
    }
    public boolean checkLoggedIn(Account account){
        boolean exists = false;
        for(Account acc : eWalletSystem.getAccounts()){
            if(acc.getUsername().equals(account.getUsername()) && acc.getPassword().equals(account.getPassword())){
                exists = true;

            }
        }
        return exists;
    }
    @Override
    public Boolean deposit(Account account, double amount){

        if(!checkLoggedIn(account)){
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        if(amount>0){
            account.setBalance(account.getBalance()+amount);
            System.out.println("Your deposit done✅");
            System.out.println("Your account balance is "+account.getBalance() +" EGP");

            return true;
        }
        return false;
    }
    @Override
    public Boolean withdraw(Account account, double amount){

        if (!checkLoggedIn(account)) {
            System.out.println("You must be logged in to perform this operation");
            return false;
        }
        if(amount>0){
            account.setBalance(account.getBalance()-amount);
            System.out.println("Your Withdraw done✅");
            System.out.println("Your account balance is "+account.getBalance()+" EGP");
            return  true;
        }
        return false;
    }
    @Override
    public Boolean Transfer(Account sender,String usernameAcceptor, double amount){
        if(!checkLoggedIn(sender)){
            System.out.println("😇You must be logged in to perform this operation");
            return false;
        }
        Account acceptor = null;
        for(Account acc : eWalletSystem.getAccounts()){
            if(acc.getUsername().equals(usernameAcceptor)){
                acceptor = acc;

            }

        }
        if(acceptor ==null){
            System.out.println(usernameAcceptor+" does not exist😟");
            return false;
        }
        else {
            if(sender.getBalance()>=amount){
                acceptor.setBalance(acceptor.getBalance()+amount);
                sender.setBalance(sender.getBalance()-amount);
                System.out.println("Transfer done✅");
                System.out.println("💷Your account balance now is "+sender.getBalance()+" EGP");
                return true;
            }
            else {
                System.out.println("😟insufficient balance");
                return false;
            }
        }


    }
}
