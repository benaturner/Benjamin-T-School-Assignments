#pragma once
#include <vector>
class House
{
public:
	// Constructors
	House();
	House(std::string c, float d, int m);
	~House();

	// Get and Set functions
	void setClient(std::string c);
	std::string getClient() const;

	void setDistance(float d);
	float getDistance() const;

	void setMaxRooms(int m);
	int getMaxRooms() const;

	// Class Functions
	// addRoom - adds a room to the vector
	void addRoom(Room r);
	// numRooms - returns the number of rooms in the vector
	int numRooms() const;
	// printRooms - prints the data of each room in the vector
	void printRooms() const;

private:
	std::string client;
	float distance;
	int maxRooms;
	std::vector<Room> rooms;
};

