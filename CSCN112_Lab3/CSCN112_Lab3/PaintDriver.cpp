// CSCN 112 Lab #3
// Generating an invoice for the cost of painting a house

/*
Algorithm:
 - I am creating a program that can generate an invoice for the cost of painting a house based on the size of the rooms in the house
 - I need to store information about the room
	+ height
	+ length
	+ width
	+ # of coats
 - I need to store information about the house
	+ client name
	+ distance
	+ vector of rooms
	+ max # of rooms
 - I need to limit the number of rooms that can be added to the vector
	+ prompt the user to input a max number of rooms
 - I need to let the user add a room to the house
	+ check if the max number of rooms has been reached
	+ prompt the user for the room's data
	+ add the room to the vector of rooms
 - I need to let the user view the rooms that have been added to the house
	+ iterate through the room vector and print the data for each room in the vector
	+ for auto loop
 - I need to calculate the values for the invoice
	+ prompt the user to print the invoice
	+ iterate through the rooms in the vector and call calc functions
	+ store calculated results to be printed
 - I need to let the user print the invoice to the console and a txt file
	+ prompt user for print location
	+ dynamic printing by passing cout or outfile into the print function

1. Add # of coats private member variable and set/get functions to Room class and constructor
2. Create House header and cpp files
3. Create constructors and destructor
4. Create House private member variables
5. Prompt user for House information
6. Create primary user menu
	a. Add a room
	b. View current rooms
	c. generate invoice
7. Bring in user input for menu
8. Implement House class functions:
	a. Set/get functions
	b. addRoom()
	c. printRooms()
	d. numRooms()
	e. printInvoice()
	f. Constructors
	g. Destructors
9. Implement main functions
	a. printMenu()
	b. newRoom()
10. Error checking
11. Output formatting
*/

// Libraries
#include <iostream>
#include <string>
#include <fstream>
#include "House.h"
#include "Room.h"

using namespace std;



// Function Prototypes

// Function 1: This function will prompt the user for the height
float promptHeight();

// Function 2: this function will prompt the user for the width
float promptWidth();

// Function 3: This function will prompt the user for the length
float promptLength();

// Function 4: This function will print a line
void printLine();

// Function 5: This function will print the main menu
void printMenu();

// Function 6: This function will create a room
Room createRoom();

// Function 7: This function will prompt the user for the # of coats
int promptCoats();

int main() {
	// Local variables
	string userInput = "";
	string yn = "";
	string client = "";
	float dist = 0.0;
	int max = 0;

	// Prompt user for client name
	cout << "Please enter the name of the client you wish to generate the invoice for: ";
	getline(cin, client);

	// Prompt user for distance
	cout << "Please enter how far (in miles) the client is from the store: ";
	cin >> dist;
	while (!cin || dist < 0) {
		cin.clear();
		cin.ignore(200, '\n');
		cout << "Invalid input. Try again." << endl;
		cout << "Please enter how far (in miles) the client is form the store: ";
		cin >> dist;
	}

	// Prompt user for max rooms
	cout << "Please enter the maximum number of rooms in the house that can be painted: ";
	cin >> max;
	while (!cin || max <= 0) {
		cin.clear();
		cin.ignore(200, '\n');
		cout << "Invalid input. Try again." << endl;
		cout << "Please enter the maximum number of rooms in the house that can be painted: ";
		cin >> max;
	}

	// Construct house object using input data
	House house(client, dist, max);


	while (userInput != "Q" &&  userInput != "q") {

		// General user prompt
		printMenu();
		userInput = "";
		// Check input
		while (userInput != "A" && userInput != "a" && userInput != "L" && userInput != "l" && userInput != "Q" && userInput != "q") {
			cin.clear();
			cin.ignore(200, '\n');
			cin >> userInput;
			if (userInput == "A" || userInput == "a") {
				system("cls");
				if (house.numRooms() >= house.getMaxRooms()) {
					cout << "Maximum number of rooms has already been reached. No further rooms available." << endl;
				}
				else {
					house.addRoom(createRoom());
				}
			}
			else if (userInput == "L" || userInput == "l") {
				printLine();
				house.printHouse();
				house.printRooms();
			}
			else if (userInput == "Q" || userInput == "q") {
				system("cls");
				house.printInvoice(cout);
				cout << endl << "Would you like to print the invoice? Y = Yes N = No" << endl;
				
				while (yn != "Y" && yn != "y" && yn != "N" && yn != "n") {
					cin >> yn;
					if (yn == "Y" || yn == "y") {
						ofstream outfile(house.getClient().append(".txt"));
						house.printInvoice(outfile);
						cout << "Invoice saved to file successfully." << endl;
						cout << "Exiting program...." << endl;
					}
					else if (yn == "N" || yn == "n") {
						cout << "Exiting program...." << endl;
					}
					else {
						cout << "Invalid input. Try again." << endl;
					}
				}
			}
			else {
				cout << "Invalid input. Try again." << endl;
			}
		}


		// Wait for user input
		system("pause");
	}

	return 0;
}

//Function Definitions

// Function 1: This function will prompt the user for data
float promptHeight() {
	// Local variables
	float h = 0;
	float userInput = 0;

	while (h == 0) {
		cout << "Input height (ft): ";
		cin >> userInput;
		// error checking
		if (!cin) {
			cout << "Invalid input. Try again." << endl << endl;
			cin.clear();
			cin.ignore(200, '\n');
		}
		else if (userInput > 0 || userInput == -1) {
			h = userInput;
		}
		else {
			cout << "Invalid input. Try again." << endl << endl;
			userInput = 0;
		}
	}
	return h;
}

// Function 2: this function will prompt the user for the width
float promptWidth() {
	// Local variables
	float w = 0;
	float userInput = 0;

	while (w == 0) {
		cout << "Input width (ft): ";
		cin >> userInput;
		// error checking
		if (!cin) {
			cout << "Invalid input. Try again." << endl << endl;
			cin.clear();
			cin.ignore(200, '\n');
		}
		else if (userInput > 0 || userInput == -1) {
			w = userInput;
		}
		else {
			cout << "Invalid input. Try again." << endl << endl;
		}
	}
	return w;
}

// Function 3: This function will prompt the user for the length
float promptLength() {
	// Local variables
	float l = 0;
	float userInput = 0;

	while (l == 0) {
		cout << "Input length (ft): ";
		cin >> userInput;
		// error checking
		if (!cin) {
			cout << "Invalid input. Try again." << endl << endl;
			cin.clear();
			cin.ignore(200, '\n');
		}
		else if (userInput > 0 || userInput == -1) {
			l = userInput;
		}
		else {
			cout << "Invalid input. Try again." << endl << endl;
		}
	}
	return l;
}

// Function 4: This function will print a line
void printLine() {
	cout << "*********************************************************" << endl;
}

// Function 5: This function will print the main menu
void printMenu() {
	system("cls");
	cout << "Please select from the following options:" << endl;
	cout << "A - Add a room to the house" << endl;
	cout << "L - List all rooms currently in the house" << endl;
	cout << "Q - Quit and prepare invoice" << endl;
}

// Function 6: This function will create a room
Room createRoom() {
	return Room(promptHeight(), promptWidth(), promptLength(), promptCoats());
}

// Function 7: This function will prompt the user for the # of coats
int promptCoats() {
	// Local variables
	int c = 0;
	int userInput = 0;

	while (c == 0) {
		cout << "Input # of coats: ";
		cin >> userInput;
		// error checking
		if (!cin) {
			cout << "Invalid input. Try again." << endl << endl;
			cin.clear();
			cin.ignore(200, '\n');
		}
		else if (userInput > 0 || userInput == -1) {
			c = userInput;
		}
		else {
			cout << "Invalid input. Try again." << endl << endl;
		}
	}
	return c;
}
