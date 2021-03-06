package bankApplication;

import java.util.LinkedList;
import java.util.List;

/* For this application I will be taking the role of a back-end Dev who has been
 * tasked with creating an application to handle new customer bank account requests
 * The application should: 
 * 		* Read a .csv file if names, social-security numbers, account type and initial deposits
 * 		* Use a proper data structure to hold all these accounts
 * 		* Both savings and current accounts should have these functions:
 * 				* deposit()
 * 				* withdraw()
 * 				* transfer()
 * 				* showInfo()
 * 				* an 11 digit account number (generated from: 1/2 depending on account type, last 2 digits of SSN, a unique 5 digit number, & a random 3 digit number)
 * 		* Savings accounts should have a safety deposit box, with a 3 digit identifier and accessed with a 4 digit pin.
 * 		* Current accoutns should be assigned a Debit card with 12 digits and 4-digit PIN
 * 		* Both accounts will use an interface that detemines the base interest rate
 * 		* Savings accounts will use .25 points less than the base rate
 * 		* Current accounts will use 15% of the base rate
 * 		* ShowInfo method should show the relevant info to the type of account
 */
public class BankApplication {

	public static void main(String[] args) {
		List<Account> accounts =new LinkedList<Account>();
		
		//Read CSV file and create new accounts
		String file = "D:\\Dev Workspaces\\Personal-Projects-Java\\Bank Account Application\\NewBankAccounts.csv";
		List<String[]> newCustomers = Utilities.CSV.read(file);
		for (String[] customer : newCustomers) {
			String name = customer[0];
			String socialSecurityNumber = customer[1];
			String accountType= customer[2];
			double initDeposit = Double.parseDouble(customer[3]);
			if (accountType.equals("Savings")){
				accounts.add(new SavingsAccount(name, initDeposit, socialSecurityNumber));
			}
			else if (accountType.equals("Checking")) {
				accounts.add(new CurrentAccount(name, initDeposit, socialSecurityNumber));
			}
			else {
				System.out.println("Error Reading Account type");
			}
		}
		
	//	accounts.get(5).showInfo();
		
		for (Account acc:accounts) {
			acc.showInfo();
			System.out.println("********************");
		}
	}

}
