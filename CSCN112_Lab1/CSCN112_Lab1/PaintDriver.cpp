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
	e. Constructors
	f. Destructors
9. Implement main functions
	a. printMenu()
	b. newRoom()
	c. printInvoice()
10. Error checking
11. Output formatting
*/

// Libraries
#include <iostream>
#include <string>
#include "House.h"
#include "Room.h"

using namespace std;

// Global Constants
float const SQFTPERGALLON = 400;

// Function Prototypes
// Function 1: This function will calculate the gallons needed to paint the room
int calcGallons(float sa);

// Function 2: This function will prompt the user for the height
float promptHeight();

// Function 3: this function will prompt the user for the width
float promptWidth();

// Function 4: This function will prompt the user for the length
float promptLength();

// Function 5: This function will print the result of the gallon calculation
void printGallons(int g);

// Function 6: This function will print a line
void printLine();

// Function 7: This function will load the room data to the room object
void loadData(Room& room, float h, float w, float l);

// Function 8: This function will print the main menu
void printMenu();

// Function 9: This function will create a room
Room createRoom();

// Function 10: This function will prompt the user for the # of coats
int promptCoats();

int main() {
	// Local variables
	string userInput = "";
	float height = 0;
	float width = 0;
	float length = 0;
	float volume = 0;
	float surfaceArea = 0;
	int gallons = 0;

	string client = "";
	float dist = 0.0;
	int max = 0;

	// Prompt user for client name
	cout << "Please enter the name of the client you wish to generate the invoice for: ";
	getline(cin, client);

	// Prompt user for distance
	cout << "Please enter how far (in miles) the client is form the store: ";
	cin >> dist;
	while (!cin || dist > 0) {
		cin.clear();
		cin.ignore(200, '\n');
		cout << "Invalid input. Try again." << endl;
		cout << "Please enter how far (in miles) the client is form the store: ";
		cin >> dist;
	}

	// Prompt user for max rooms
	cout << "Please enter the maximum number of rooms in the house that can be painted: ";
	cin >> max;
	while (!cin || max > 0) {
		cin.clear();
		cin.ignore(200, '\n');
		cout << "Invalid input. Try again." << endl;
		cout << "Please enter the maximum number of rooms in the house that can be painted: ";
		cin >> max;
	}

	// Construct house object using input data
	House house(client, dist, max);


	while (userInput != "Q" || "q") {

		// General user prompt
		printMenu();

		// Check input
		while (userInput != "A" || "a" || "L" || "l" || "Q" || "q") {
			cin >> userInput;
			if (userInput == "A" || "a") {
				system("cls");
				if (house.numRooms() >= house.getMaxRooms()) {
					cout << "Maximum number of rooms has already been reached. No further rooms available." << endl;
					system("pause");
				}
				else {
					house.addRoom(createRoom());
				}
			}
			else if (userInput == "L" || "l") {

			}
			else if (userInput == "Q" || "q") {
				
			}
			else {
				cout << "Invalid Input. Try again." << endl;
			}
		}
		

		// Wait for user input
		system("pause");
		
		// Clear screen before prompting again
		system("cls");
	}
	
	return 0;
}

//Function Definitions
// Function 1: This function will calculate the gallons needed to paint the room
int calcGallons(float sa) {
	// Calculate gallons needed
	int gallons = ceil(sa / SQFTPERGALLON);
	// Return calculated value
	return gallons;
}

// Function 2: This function will prompt the user for data
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

// Function 3: this function will prompt the user for the width
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

// Function 4: This function will prompt the user for the length
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

// Function 5: This function will print the reslut of the gallon calculation
void printGallons(int g) {
	cout << "Gallons of paint: " << g << endl;
	printLine();
}

// Function 6: This function will print a line
void printLine() {
	cout << "*********************************************************" << endl;
}

// Function 7: This function will load the room data to the room object
void loadData(Room& room, float h, float w, float l) {
	// Set the height of the room
	room.setHeight(h);

	// Set the width of the room
	room.setWidth(w);

	// Set the length of the room
	room.setLength(l);
}

// Function 8: This function will print the main menu
void printMenu() {
	system("cls");
	cout << "Please select from the following options:" << endl;
	cout << "A - Add a room to the house" << endl;
	cout << "L - List all rooms currently in the house" << endl;
	cout << "Q - Quit and prepare invoice" << endl;
}

// Function 9: This function will create a room
Room createRoom() {
	/*float height = 0;
	float width = 0;
	float length = 0;
	int coats = 0;
	height = promptHeight();
	width = promptWidth();
	length = promptLength();
	coats = promptCoats();
	*/
	Room(promptHeight(), promptWidth(), promptLength(), promptCoats());
}

// Function 10: This function will prompt the user for the # of coats
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