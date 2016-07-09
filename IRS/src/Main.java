import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner kboard = new Scanner(System.in);
		System.out.println("Are you single or married? (Enter 1 for single or 2 for married)");
		int maritalStatus = kboard.nextInt();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter your taxable income:");
		double taxableIncome = keyboard.nextDouble();
		TaxApplicant tax = new TaxApplicant(taxableIncome, maritalStatus);
		double fedTax = tax.calculateTaxesOwed();
		System.out.println("Your federal tax is: $" + fedTax);
	}
}
