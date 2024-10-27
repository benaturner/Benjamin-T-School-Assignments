// CSCN 112 Lab #4
// Amortizing a loan and printing the results

/*
Algorithm:
 - I am creating a program that can amortize a loan and print out the payments that must be made each month to pay it off
 - I will need to store information about the loan
	+ principal amount
	+ interest rate
	+ term (5, 10, or 15 years)
 - I need to utilize a tail recursive function in main
 - I need to print the results within the recursive function

 1. Create local variables
 2. Prompt user for principal
 3. Prompt user for interest rate
 4. Prompt user for term
 5. Create recursive function, amortize()
	a. curPeriod
	b. totPeriods
	c. payAmount
	d. monthIntRate
	e. curBalance
 6. Create other main functions
	a. promptPrincipal
	b. promptInterest
	c. promptTerm
	d. printLoan
 7. Error checking
 8. Output formatting
*/

//Libraries
#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

// Global Constants

//Function Prototypes
// Function 1: prompt the user for the principal
double promptPrincipal();

// Function 2: prompt the user for the interest rate
double promptInterest();

// Function 3: prompt the user for the term
int promptTerm();

// Function 4: print the loan information
void printLoan(double, double, int, double);

// Function 5: amortize and print the loan
void amortize(int, int, double, double, double);

// Function 6: calculate monthly interest rate
double calcInterest(double);

// Function 7: calculate monthly payment
double calcMonthlyPay(double, double, int);

int main() {
	// Local variables
	double principal = 0.0;
	double interest = 0.0;
	int term = 0;
	double interestPerPeriod = 0.0;
	double monthlyPayment = 0.0;

	// Prompt the user
	principal = promptPrincipal();
	interest = promptInterest();
	term = promptTerm();
	interestPerPeriod = calcInterest(interest);
	monthlyPayment = calcMonthlyPay(principal, interestPerPeriod, term * 12);

	// Print the loan information
	printLoan(principal, interest, term, monthlyPayment);

	// amortize the loan
	amortize(1, term * 12, monthlyPayment, interestPerPeriod, principal);

	// Pause the program
	system("pause");

	// End the program
	return 0;
}

// Function Definitions
// Function 1: prompt the user for the principal
double promptPrincipal() {
	double userInput = 0.0;
	cout << "Please enter the appropriate value for the principal of the loan: ";
	cin >> userInput;
	// Error Checking: Reprompt the user
	while (!cin || userInput < 0) {
		cout << "Invalid input. Try again." << endl;
		cout << "Please enter the appropriate value for the principal of the loan: ";
		cin.clear();
		cin.ignore(200, '\n');
		cin >> userInput;
	}
	return userInput;
}

// Function 2: prompt the user for the interest rate
double promptInterest() {
	double userInput = 0.0;
	cout << "Please enter the appropriate value for the interest rate of the loan: ";
	cin >> userInput;
	// Error Checking: Reprompt the user
	while (!cin || userInput < 0) {
		cout << "Invalid input. Try again." << endl;
		cout << "Please enter the appropriate value for the interest rate of the loan: ";
		cin.clear();
		cin.ignore(200, '\n');
		cin >> userInput;
	}
	return userInput;
}

// Function 3: prompt the user for the term
int promptTerm() {
	int userInput = 0;
	cout << "Please enter the appropriate value for the term of the loan (5, 10, or 15 years): ";
	cin >> userInput;
	// Error Checking: Reprompt the user
	while (!cin || (userInput != 5 && userInput != 10 && userInput != 15)) {
		cout << "Invalid input. Try again." << endl;
		cout << "Please enter the appropriate value for the term of the loan (5, 10, or 15 years): ";
		cin.clear();
		cin.ignore(200, '\n');
		cin >> userInput;
	}
	return userInput;
}

// Function 4: print the loan information
void printLoan(double p, double i, int t, double m) {
	system("cls");
	cout << "Loan Application - Amortization Schedule" << endl << endl;
	cout << setw(43) << left << "Principal:" << fixed << setprecision(0) << p << endl;
	cout << setw(43) << "Life of Loan (5, 10, or 15 years):" << t << endl;
	cout << setw(43) << "Annual interest rate:" << setprecision(2) << i << "%" << endl;
	cout << setw(43) << "Monthly Payment:" << setprecision(2) << m << endl << endl;
	cout << right << setw(10) << "Payment" << setw(10) << "Amount" << setw(10) << "Interest" << setw(10) << "Principal" << setw(12) << "Balance" << endl;
	cout << setw(52) << p << endl;
}

// Function 5: amortize and print the loan
void amortize(int curPeriods, int totPeriods, double payAmount, double monthIntRate, double curBalance) {
	// Local Variables
	double interest = 0.0;
	double principal = 0.0;
	double balance = 0.0;

	// Base case
	if (curPeriods <= totPeriods) {
		// Calculations
		interest = monthIntRate * curBalance;
		principal = payAmount - interest;
		balance = curBalance - principal;
		if (balance < 0.01) {
			balance = 0.00;
		}
		
		// Print current payment period #
		cout << fixed << setprecision(2) << right << setw(10) << curPeriods;
		// Print monthly payment amount
		cout << setw(10) << payAmount;
		// Print amount payed for interest
		cout << setw(10) << interest;
		// Print amount payed for principal
		cout << setw(10) << principal;
		// Print new current balance
		cout << setw(12) << balance << endl;
		// Call amortize again with new values
		amortize(curPeriods + 1, totPeriods, payAmount, monthIntRate, balance);
	}
	else {
		// Do nothing, base case reached
	}

}

// Function 6: calculate interest rate per period
double calcInterest(double i) {
	if (i == 0) {
		return 0;
	}
	else {
		return i / 100 / 12;
	}
	
}

// Function 7: calculate monthly payment
double calcMonthlyPay(double p, double i, int t) {
	if (i == 0) {
		return p / t;
	}
	else {
		return p * ((i * pow((1.0 + i), t)) / (pow((1.0 + i), t) - 1));
	}
	
}
