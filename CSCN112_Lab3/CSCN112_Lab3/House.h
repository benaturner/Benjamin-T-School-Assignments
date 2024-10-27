#pragma once
#include <vector>
#include <string>
#include <iostream>
#include <iomanip>
#include <sstream>
#include "Room.h"

class House
{
public:
	// Global Variables
	float const HOURLYRATE = 18.50;
	float const MILEAGECOST = 0.67;
	float const PAINTCOST = 70.35;

	// Constructors
	House();
	House(std::string c, int d, int m);
	~House();

	// Get and Set functions
	void setClient(std::string c);
	std::string getClient() const;

	void setDistance(int d);
	int getDistance() const;

	void setMaxRooms(int m);
	int getMaxRooms() const;

	// Class Functions
	// addRoom - adds a room to the vector
	void addRoom(Room r);
	// numRooms - returns the number of rooms in the vector
	int numRooms() const;
	// printRooms - prints the data of each room in the vector
	void printRooms() const;
	// printHouse - prints the data of the house
	void printHouse() const;
	// printInvoice - prints the final invoice
	void printInvoice(std::ostream& out) const;
	// totalCoats - returns the total number of coats in the house
	int totalCoats() const;
	// laborCost - returns the cost of labor as a string to be printed
	float laborCost() const;
	// formatAmount - formats dollar amounts as string to be printed to the invoice
	std::string formatAmount(float amount) const;
	// productCost - returns the cost of products used
	float productCost() const;

private:
	std::string client;
	int distance;
	int maxRooms;
	std::vector<Room> rooms;
};

