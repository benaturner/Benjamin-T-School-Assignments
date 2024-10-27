#pragma once
class Room
{
	public:
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
		// showData - displays the room's dimensions, volume, and paintable area
		void showData(float v, float sa) const;

	private:
		float height;
		float width;
		float length;
		int coats;
};