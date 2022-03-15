package Question2;

public class CheckingAccount {

    private double balance;
    private double number;

    public CheckingAccount(double balance, double number){
        this.balance = balance;
        this.number = number;
    }

    public double deposit(double amount) throws Exception{
        if (amount <= 0){
            throw new Exception("| ERROR | Value must be more than 0!");
        }
        this.balance += amount;
        return balance;
    }   
    
    public double withdraw(double amount) throws InsufficientFundsException{
        if (balance < amount){
            throw new InsufficientFundsException(amount);
        }
        else{   
            balance -= amount;
            return balance;
        }
    }    

    public double getBalance(){
        return balance;
    }    
    
    public double getNumber(){
        return number;
    }     
}
