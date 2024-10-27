#include <iostream>
#include "Room.h"

Room::Room() { // default constructor
	height = 0;
	width = 0;
	length = 0;
	coats = 0;
}

Room::Room(float h, float w, float l, int c) {
	// Initialize the private member variables
	height = h;
	width = w;
	length = l;
	coats = c;
}


// set and get functions
void Room::setHeight(float h) {
	height = h;
}
float Room::getHeight() const {
	return height;
}

void Room::setWidth(float w) {
	width = w;
}
float Room::getWidth() const {
	return width;
}

void Room::setLength(float l) {
	length = l;
}
float Room::getLength() const {
	return length;
}

void Room::setCoats(int c) {
	coats = c;
}
int Room::getCoats() const {
	return coats;
}

// Other functions
// calcVolume - calculates the volume of the room
float Room::calcVolume() const {
	return getHeight() * getWidth() * getLength();
}

// calcPaintedArea - calculates the surface area of the walls of the room
float Room::calcPaintedArea() const {
	return 2 * getHeight() * getWidth() * getCoats()  + 2 * getHeight() * getLength() * getCoats();
}

// calcGallons - calculates the gallons of paint needed to paint the room
float Room::calcGallons() const {
	// Calculate gallons needed
	float gallons = calcPaintedArea() / SQFTPERGALLON;
	// Return calculated value
	return gallons;
}

// numCans - returns the number of cans needed to paint the room
int Room::numCans() const {
	return ceil(calcGallons());
}

