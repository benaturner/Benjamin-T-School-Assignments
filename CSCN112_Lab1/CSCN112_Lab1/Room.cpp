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
	return 2 * getHeight() * getWidth() + 2 * getHeight() * getLength();
}

// showData - displays the room's dimensions, volume, and paintable area
void Room::showData(float v, float sa) const {
	std::cout << "Results" << std::endl;
	std::cout << "Height: " << getHeight() << std::endl;
	std::cout << "Width: " << getWidth() << std::endl;
	std::cout << "Length: " << getLength() << std::endl;
	std::cout << "Volume: " << v << std::endl;
	std::cout << "Paintable Area: " << sa << std::endl;
}