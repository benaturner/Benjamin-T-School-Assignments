#include <string>
#include <iostream>
#include <iomanip>
#include <fstream>
#include <vector>
#include <algorithm>
#include "Employee.h"

Employee::Employee() { // default constructor
	name = "";
	city = "";
	employeeID = "DEFAULT";
}

Employee::Employee(std::string n, std::string c, std::string id) {
	// Initialize the private member variables
	name = n;
	city = c;
	employeeID = id;
}

// set and get functions
void Employee::setName(std::string n) {
	name = n;
}
std::string Employee::getName() const {
	return name;
}

void Employee::setCity(std::string c) {
	city = c;
}
std::string Employee::getCity() const {
	return city;
}

void Employee::setID(std::string id) {
	employeeID = id;
}
std::string Employee::getID() const {
	return employeeID;
}

// Class Functions
// addScore - adds a score to the vector
void Employee::addScore(float s) {
	scores.push_back(s);
}

// sortScores - sorts the vector
void Employee::sortScores() {
	sort(scores.begin(), scores.end());
}

//clearScores - clears the vector
void Employee::clearScores() {
	scores.clear();
}

// averageScores - calculates the average score
float Employee::averageScores() const{
	float total = 0;
	int counter = 0;
	for (const auto& i : scores) {
		total += i;
		counter++;
	}
	if (counter == 0) {
		return 0;
	}
	else {
		return total / counter;
	}
}

// lowestScore - returns the lowest score
float Employee::lowestScore() const{ 
	if (scores.empty()) {
		return 0;
	}
	else {
		return scores.front();
	}
}

// highestScore - returns the highest score
float Employee::highestScore() const{ 
	if (scores.empty()) {
		return 0;
	}
	else {
		return scores.back();
	}
}

// numScores - returns the number of scores in the vector
int Employee::numScores() const{
	return scores.size();
}

// getVector - returns a copy of the scores vector
std::vector<float> Employee::getVector() const {
	return scores;
}

// printEmployeeInfo - prints the employee info
void Employee::printEmployeeInfo() const{
	system("cls");
	std::cout << "*************************************************" << std::endl;
	std::cout << "                  Employee Info" << std::endl;
	std::cout << "Employee Name: " << Employee::getName() << std::endl;
	std::cout << "City:          " << Employee::getCity() << std::endl;
	std::cout << "ID:            " << Employee::getID() << std::endl << std::endl;
	std::cout << "*************************************************" << std::endl;
	std::cout << "           Customer Satisfaction Info" << std::endl;
	std::cout << "Average Score: ";
	if (Employee::averageScores() == 0) {
		std::cout << std::endl;
	}
	else {
		std::cout << std::setprecision(6) << Employee::averageScores() << std::endl;
	}
	std::cout << "Lowest Score:  ";
	if (Employee::lowestScore() == 0) {
		std::cout << std::endl;
	}
	else {
		std::cout << Employee::lowestScore() << std::endl;
	}
	std::cout << "Highest Score: ";
	if (Employee::highestScore() == 0) {
		std::cout << std::endl;
	}
	else {
		std::cout << Employee::highestScore() << std::endl;
	}
	std::cout << "List of all recorded scores:" << std::endl;
	for (const auto& i : scores) {
		std::cout << i << std::endl;
	}
	std::cout << "        End of information for " << Employee::getName() << std::endl << std::endl;
	std::cout << "*************************************************" << std::endl;
	system("pause");
}

