#include "House.h"



// Constructors
House::House() {
	client = "";
	distance = 0;
	maxRooms = 0;
}
House::House(std::string c, int d, int m) {
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

void House::setDistance(int d) {
	distance = d;
}
int House::getDistance() const {
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
	for (const auto& i : rooms) {
		std::cout << std::endl << "--------------------- Room Details ---------------------" << std::endl;
		std::cout << "Length: " << i.getLength() << std::endl;
		std::cout << "Width: " << i.getWidth() << std::endl;
		std::cout << "Height: " << i.getHeight() << std::endl;
		std::cout << "Coats: " << i.getCoats() << std::endl;
		std::cout << "Volume: " << std::fixed << std::setprecision(0) << i.calcVolume() << std::endl;
		std::cout << "Area: " << std::fixed << std::setprecision(0) << i.calcPaintedArea() << " sq feet" << std::endl;
		std::cout << "--- Paint Required --- " << std::setprecision(2) << i.calcGallons() << " gallons" << std::endl;
	}
	std::cout << std::endl << "End house details...." << std::endl;
}
// printHouse - prints the data of the house
void House::printHouse() const {
	std::cout << "Client Name: " << getClient() << std::endl;
	std::cout << "Max Rooms: " << getMaxRooms() << std::endl;
	std::cout << "Distance: " << std::setprecision(2) << getDistance() << std::endl;
	std::cout << "Current Rooms: " << numRooms() << std::endl;
}

// totalCoats - returns the total number of coats in the house
int House::totalCoats() const {
	int coats = 0;
	for (const auto& i : rooms) {
		coats += i.getCoats();
	}
	return coats;
}

// laborCost - returns the cost of labor
float House::laborCost() const {
	return totalCoats() * HOURLYRATE;
}

// productCost - returns the cost of products used
float House::productCost() const {
	float total = 0.00;
	for (const auto& i : rooms) {
		total += i.numCans()* PAINTCOST;
	}
	return total;
}

// formatAmount - formats dollar amounts as string to be printed to the invoice
std::string House::formatAmount(float amount) const{
	std::ostringstream s;
	s << std::fixed << std::setprecision(2) << amount;
	return "$" + s.str();
}

// printInvoice - prints the final invoice
void House::printInvoice(std::ostream& out) const {
	int count = 0;
	out << std::fixed << std::setprecision(2);
	out << "***********************************************************************************" << std::endl;
	out << getClient() << std::endl;
	out << "Final Invoice" << std::endl;
	out << "***********************************************************************************" << std::endl << std::endl;
	out << "WePaintHouses LLC" << std::endl;
	out << "1971 University Blvd" << std::endl;
	out << "Lynchburg, VA 24502" << std::endl;
	out << "4344554545" << std::endl;
	out << "wepainthousesllc.com" << std::endl << std::endl;
	out << "Billed to: " << getClient() << std::endl << std::endl;
	out << "-----------------------------------------------------------------------------------" << std::endl;
	out << "                                   Labor Charges                                   " << std::endl;
	out << "                                   -------------                                   " << std::endl;
	out << std::setw(5) << "Rooms" << std::setw(29) << "Number of coats" << std::setw(24) << "Hourly Rate" << std::setw(24) << "Total" << std::endl;
	out << std::setw(5) << std::left << numRooms() << std::setw(29) << std::right << totalCoats() << std::setw(24) << HOURLYRATE << std::setw(24) << formatAmount(laborCost()) << std::endl << std::endl;
	out << "                                  Product Charges                                  " << std::endl;
	out << "                                  ---------------                                  " << std::endl;
	out << "Room #" << std::setw(28) << "Paint Cans" << std::setw(24) << "Unit Cost" << std::setw(24) << "Amount" << std::endl;
	for (const auto& i : rooms) {
		count++;
		out << std::setw(6) << std::left << count << std::setw(28) << std::right << i.numCans() << std::setw(24) << PAINTCOST << std::setw(24) << i.numCans() * PAINTCOST << std::endl;
	}
	out << "Total Product Charges:" << std::setw(60) << formatAmount(productCost()) << std::endl << std::endl;
	out << "                                  Commute Charges                                  " << std::endl;
	out << "                                  ---------------                                  " << std::endl;
	out << "Mileage" << std::setw(51) << "Rate Per Mile" << std::setw(24) << "Total" << std::endl;
	out << std::setw(7) << std::left << getDistance() << std::setw(51) << std::right << MILEAGECOST << std::setw(24) << formatAmount(getDistance() * MILEAGECOST) << std::endl << std::endl;
	out << "Final Total:" << std::setw(70) << formatAmount(laborCost() + productCost() + getDistance() * MILEAGECOST) << std::endl << std::endl;
	out << "-----------------------------------------------------------------------------------" << std::endl;
}