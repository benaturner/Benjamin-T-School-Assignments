#pragma once
class Room
{
public:
	// Global Constants
	float const SQFTPERGALLON = 400;

	// Constructors
	Room(); // default constructor
	Room(float h, float w, float l, int c);

	// Get and Set functions
	void setHeight(float h);
	float getHeight() const;

	void setWidth(float w);
	float getWidth() const;

	void setLength(float l);
	float getLength() const;

	void setCoats(int c);
	int getCoats() const;

	// Class functions
	// calcVolume - calculates the volume of the room
	float calcVolume() const;
	// calcPaintedArea - calculates the surface area of the walls of the room
	float calcPaintedArea() const;
	// calcGallons - calculates the gallons of paint needed to paint the room
	float calcGallons() const;
	// numCans - returns the number of cans needed to paint the room
	int numCans() const;

private:
	float height;
	float width;
	float length;
	int coats;
};