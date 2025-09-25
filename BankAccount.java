import java.util.Scanner;
import java.util.Random;

public class BankAccount { 
   private double balance;

   public BankAccount() {
       balance = 0;
   }

   public double deposit(int amt) {
      if ((balance + amt) > 100000) {
         System.out.println("Your balance cannot exceed 100,000 euros.");
         return balance;
      } else {
         balance = balance + amt;
         return balance;
      }
   }

   public double withdraw(int amt) {
      if (amt > balance) {
         System.out.println("Insufficient funds.");
         return -101;
      } else if (amt > 400) {
         System.out.println("Maximum single withdrawal is 400 euro.");
         return balance;
      } else {
         balance = balance - amt;
         return balance;
      }
   }

   public double checkBalance() {
      return balance;s
   }
}

class Main {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      BankAccount account = new BankAccount();

      while (true) {
         System.out.println("\nEnter Choice :");
         System.out.println("1. Deposit | 2. Withdraw | 3. Check Balance | 4. Exit");
         int choice = scanner.nextInt();

         if (choice == 1) {
            System.out.print("Enter amount to be deposited: ");
            int amt = scanner.nextInt();
            double newBalance = account.deposit(amt);
            System.out.println("New balance: " + newBalance);
         } else if (choice == 2) {
            System.out.print("Enter amount to be withdrawn: ");
            int amt = scanner.nextInt();
            double newBalance = account.withdraw(amt);
            if (newBalance != -101) {
               System.out.println("New balance: " + newBalance);
            }
         } else if (choice == 3) {
            System.out.println("Current balance: " + account.checkBalance());
         } else if (choice == 4) {
            System.out.println("Exiting...");
            break;
         } else {
            System.out.println("Invalid choice");
         }
      }
      scanner.close();
   }
}

