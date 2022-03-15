package Question2;

public class InsufficientFundsException extends Exception{
    
    private double amount = 0;

    public InsufficientFundsException(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }
}
