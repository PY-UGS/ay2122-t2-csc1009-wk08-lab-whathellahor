package Question2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BankDemoTest {
    public static void main(String[]args){

        DecimalFormat df = new DecimalFormat("0.00");

        CheckingAccount checkingAccount = new CheckingAccount(0, 462628265);
        Scanner userInput = new Scanner(System.in);

        while(true){
            try{
                System.out.print("\nEnter an amount to deposit: ");
                double depositAmount = userInput.nextDouble();
                checkingAccount.deposit(depositAmount);
                System.out.println("\n>>>>> Deposit successful <<<<<\nYour balance after deposit is: $" + df.format(checkingAccount.getBalance()));
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }            
        }

        while(true){
            try{
                System.out.print("\nEnter an amount to withdraw: ");
                double withdrawAmount = userInput.nextDouble();
                checkingAccount.withdraw(withdrawAmount);
                System.out.println("\n>>>>> Withdraw successful <<<<<\nThe balance after withdraw is: $" + df.format(checkingAccount.getBalance()) + "\n");
                break;
            }catch(InsufficientFundsException e){
                double difference = (e.getAmount()-checkingAccount.getBalance());
                System.out.println("Sorry, but your account is short by: $" + df.format(difference));
            }
        }
        
        userInput.close();
    }
}