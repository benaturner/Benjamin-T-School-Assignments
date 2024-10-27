#include <string>
#include <iostream>
#include "Room.h"
#include "House.h"


// Constructors
House::House() {
	client = "";
	distance = 0.0;
	maxRooms = 0;
}
House::House(std::string c, float d, int m) {
	client = c;
	distance = d;
	maxRooms = m;
}
House::~House() {
	// nothing goes here for now
}

// Get and Set functions
void House::setClient(std::string c) {
	client = c;
}
std::string House::getClient() const {
	return client;
}

void House::setDistance(float d) {
	distance = d;
}
float House::getDistance() const {
	return distance;
}

void House::setMaxRooms(int m) {
	maxRooms = m;
}
int House::getMaxRooms() const {
	return maxRooms;
}

// Class Functions
// addRoom - adds a room to the vector
void House::addRoom(Room r) {
	rooms.push_back(r);
}
// numRooms - returns the number of rooms in the vector
int House::numRooms() const {
	return rooms.size();
}
// printRooms - prints the data of each room in the vector
void House::printRooms() const {

}