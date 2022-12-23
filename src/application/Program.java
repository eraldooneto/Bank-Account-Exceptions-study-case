package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		
		Account account = new Account();
		
		
		System.out.println("Enter account data ");
		

		System.out.print("Number: ");
		int number = scan.nextInt();
		scan.nextLine();
		
		System.out.print("Holder: ");
		String name = scan.nextLine();
		
		System.out.print("Initial Balance: ");
		double balance = scan.nextDouble();
		scan.nextLine();
		
		System.out.print("Withdraw limit: ");
		double withdrawLimit = scan.nextDouble();
		scan.nextLine();
		
		account = new Account(number, name, balance, withdrawLimit);
		
		System.out.println();
		
		try {
			System.out.print("Enter the amount to withdraw: ");
			double amount = scan.nextDouble();
			account.withdraw(amount);
			System.out.println("New balance: " + account.getBalance());
			
			
		} catch (DomainException e) {
			System.out.println("Error! " + e.getMessage());
		}
		
		scan.close();

	}

}
