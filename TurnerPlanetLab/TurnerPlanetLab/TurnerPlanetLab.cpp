// Turner
#include <iostream>
#include <string>
using namespace std;

enum planet_number { Mercury, Venus, Earth, Moon, Mars, Jupiter, Saturn, Uranus, Neptune, Pluto };

bool valid_planet(string, planet_number&);
float calculate_weight(float, int planetNumber);

int main()
{
	cout << "Weight Calculator\n\n";
	string planetNameEntered = "";
	planet_number planetNumber;
	int weightOnEarth = 0;
	float weightOnAnotherPlanet = 0;
	do
	{
		cout << "Enter a planet (Mercury, Venus, Earth, Moon, Mars, Jupiter, Saturn, Uranus, Neptune, or Pluto): ";
		cin >> planetNameEntered;
	} while (!valid_planet(planetNameEntered, planetNumber));
	cout << "Enter weight on Earth (lbs): ";
	cin >> weightOnEarth;
	weightOnAnotherPlanet = calculate_weight(weightOnEarth, planetNumber);
	cout << "\nWeight on " << planetNameEntered <<  ": " << weightOnAnotherPlanet << " lbs\n\n";
}

bool valid_planet(string planetNameEntered, planet_number& planetNumber)
{
	if (planetNameEntered == "Mercury")
	{
		planetNumber = Mercury;
		return true;
	}
	if (planetNameEntered == "Venus")
	{
		planetNumber = Venus;
		return true;
	}
	if (planetNameEntered == "Earth")
	{
		planetNumber = Earth;
		return true;
	}
	if (planetNameEntered == "Moon")
	{
		planetNumber = Moon;
		return true;
	}
	if (planetNameEntered == "Mars")
	{
		planetNumber = Mars;
		return true;
	}
	if (planetNameEntered == "Jupiter")
	{
		planetNumber = Jupiter;
		return true;
	}
	if (planetNameEntered == "Saturn")
	{
		planetNumber = Saturn;
		return true;
	}
	if (planetNameEntered == "Uranus")
	{
		planetNumber = Uranus;
		return true;
	}
	if (planetNameEntered == "Neptune")
	{
		planetNumber = Neptune;
		return true;
	}
	if (planetNameEntered == "Pluto")
	{
		planetNumber = Pluto;
		return true;
	}
	system("CLS");
	cout << "Weight Calculator\n\n";
	cout << "Your entry was not a valid planet.\n";
	return false;
}

float calculate_weight(float weightOnEarth, int planetNumber)
{
	switch (planetNumber)
	{
	case 0:
		return weightOnEarth * .4155;
		break;
	case 1:
		return weightOnEarth * .8975;
		break;
	case 2:
		return weightOnEarth * 1.0;
		break;
	case 3:
		return weightOnEarth * .1666;
		break;
	case 4:
		return weightOnEarth * 2.5374;
		break;
	case 5:
		return weightOnEarth * 1.0677;
		break;
	case 6:
		return weightOnEarth * .8947;
		break;
	case 7:
		return weightOnEarth * 1.1794;
		break;
	case 8:
		return weightOnEarth * .0899;
		break;
	}
	return 0.0;
}
