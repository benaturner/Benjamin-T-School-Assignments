// CSCN 112 Lab #2
// Displaying satisfaction scores for employees

/*
Algorithm:
 - I am creating a menu that can receive, store, and display satisfaction scores of employees
 - I need to store information about each employee:
	+ Name (string)
	+ City (string)
	+ Employee ID (string)
	+ Sorted scores (vector of floats)
 - I need to bring in the employee information from a file
	+ Prompt the user for the txt file
	+ Use file manipulation to detect the end of the file and to implement error checking
 - I need to bring in the employee information from the user's input
	+ Prompt the user for the employee's information
	+ Error checking
 - I need to let the user add scores to the current employee
	+ Prompt the user for the new score
	+ Error checking
	+ Add score and resort vector
 - I need to let the user save an employee to a txt file
	+ File manipulation
	+ Error checking
 - What does the program do with the employee?
	+ Calculate average score
	+ Sort scores
	+ Print scores

1. Create variables for an employee in Employee class
2. Bring in scores for the employee from a file
3. Bring in employee info from user input
4. Bring in values for new scores
5. Create default constructor
6. Implement class functions:
	a. Set function
	b. Get function
	c. addScore()
	d. sortScores()
	e. averageScore()
	f. lowestScore()
	g. highestScore()
	h. numScores()
	i. getVector()
	j. printEmployeeInfo()
7. Implement main functions:
	a. openFile()
	b. createEmployee()
	c. newScore()
	d. saveEmployee()
	e. printMenu()
8. Error checking
9. Output Formatting
*/

// Libraries
#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <iomanip>
#include "Employee.h"

using namespace std;

//Global Constants

// Function Prototypes
// Function 1: Open an employee file
int openFile(Employee& employee);

// Function 2: Create an employee from user input
void createEmployee(Employee& employee);

// Function 3: Add a score to the current employee
void newScore(Employee& employee);

// Function 4: Save current employee to a file
void saveEmployee(Employee& employee);

// Function 5: Print menu
void printMenu(Employee& employee);

int main() {
	int userInput = 0;
	Employee e;
	while (userInput != 6) {
		printMenu(e);
		cin >> userInput;
		if (!cin) {
			cout << "Invalid input. Try again." << endl;
			cin.clear();
			cin.ignore(200, '\n');
		}
		else {
			switch (userInput) {
			case 1:
				userInput = openFile(e);
				break;
			case 2:
				createEmployee(e);
				break;
			case 3:
				newScore(e);
				break;
			case 4:
				saveEmployee(e);
				break;
			case 5:
				e.printEmployeeInfo();
				break;
			case 6:
				break;
			default:
				cout << endl << "Invalid input. Please try again." << endl;
				system("pause");
				break;
			}
		}
	}
}

// Function Definitions
// Function 1: Open an employee file
int openFile(Employee& employee) {
	system("cls");
	// clear old employee
	employee.clearScores();
	// open file object
	ifstream infile;
	string userInput = "";
	cout << "Please enter the name of the employee file (including extension): ";
	cin.ignore(200, '\n');
	getline(cin, userInput);
	infile.open(userInput);
	// error check opening file
	if (!infile) {
		cout << "File cannot be opened. Program will terminate, please try again" << endl;
		system("pause");
		return 6;  // CHECK FOR OTHER WAYS TO EXIT PROGRAM
	}
	else {
		int counter = 0;
		string tempName = "";
		string tempCity = "";
		string tempID = "";
		float tempScore = 0;

		// load data from file into employee object
		while (!infile.fail() && !infile.eof()) {
			counter++;
			switch (counter) {
			case 1:
				getline(infile, tempName);
				employee.setName(tempName);
				break;
			case 2:
				getline(infile, tempCity);
				employee.setCity(tempCity);
				break;
			case 3:
				getline(infile, tempID);
				employee.setID(tempID);
				break;
			default:
				infile >> tempScore;
				if (infile.fail()) {
					cout << "Invalid score was encountered: non-numeric value found. File corrupted, exiting program." << endl;
					system("pause");
					return 6;
				}
				else if (tempScore < 1 || tempScore > 5) {
					cout << "Invalid score was encountered: out of range. File corrupted, exiting program." << endl;
					system("pause");
					return 6;
				}
				else {
					employee.addScore(tempScore);
					infile.ignore(1);
				}
			}
		}
		cout << "End of file reached successfully.";
		employee.sortScores();
		return 0;
	}
}

// Function 2: Create an employee from user input
void createEmployee(Employee& employee) { 
	system("cls");
	employee.clearScores();
	string n = "";
	string c = "";
	string id = "";
	cin.ignore(200, '\n');
	cout << "Please enter the employee's name: ";
	getline(cin, n); 
	cout << endl << endl << "Please enter the city that the employee will be working: ";
	getline(cin, c);
	cout << endl << endl << "Please enter the employee's ID: ";
	getline(cin, id); 
	employee.setName(n);
	employee.setCity(c);
	employee.setID(id);
}

// Function 3: Add a score to the current employee
void newScore(Employee& employee) {
	system("cls");
	float s = 0;
	float userInput = 0;
	if (employee.getID() != "DEFAULT") { 
		while (s==0) {
			cout << "Please enter the customer satisfaction score for this employee (1-5): ";
			cin >> userInput;
			// error checking
			if (!cin) {
				cout << "Invalid Score. ";
				cin.clear();
				cin.ignore(200, '\n');
			}
			else if (userInput >= 1 && userInput <= 5) {
				s = userInput;
			}
			else {
				cout << "Invalid Score. ";
			}
		}
	employee.addScore(s);
	employee.sortScores();
	}
	else {
		cout << "There is no current employee. Please create a new employee or open an employee file." << endl;
	}
}

// Function 4: Save current employee to a file
void saveEmployee(Employee& employee) {
	system("cls");
	if (employee.getID() == "DEFAULT") {
		cout << "There is not current employee. Please create a new employee or open an employee file." << endl;
		system("pause");
	}
	else {
		system("cls");
		// create employee file
		string tempName = employee.getName();
		string extension = ".txt";
		ofstream outfile (tempName.append(extension));
		// write employee data
		outfile << employee.getName() << endl << employee.getCity() << endl << employee.getID();
		for (const auto& i : employee.getVector()) {
			outfile << endl << i;
		}
		cout << "Employee saved as " << tempName << endl;
		system("pause");
	}
}

// Function 6: Print menu
void printMenu(Employee& employee) {
	system("cls");
	cout << "************************************************" << endl;
	cout << "                      MENU" << endl;
	cout << "   Current Employee: " << employee.getName() << endl << endl;
	cout << "   1 -  Switch/Open Employee file" << endl;
	cout << "   2 -  Create New Employee" << endl;
	cout << "   3 -  Add Score to Current Employee" << endl;
	cout << "   4 -  Save Current Employee Info to File" << endl;
	cout << "   5 -  Print Employee Info" << endl;
	cout << "   6 -  Quit" << endl;
	cout << "************************************************" << endl << endl;
	cout << "Please select your menu choice: ";
}