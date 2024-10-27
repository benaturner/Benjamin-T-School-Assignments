#pragma once
class Employee
{
public:
	// Constructors
	Employee(); // default constructor
	Employee(std::string n, std::string c, std::string id);
	
	// Get and Set functions
	void setName(std::string n);
	std::string getName() const;

	void setCity(std::string c);
	std::string getCity() const;

	void setID(std::string id);
	std::string getID() const;

	// Class Functions
	// addScore - adds a score to the vector
	void addScore(float s);
	// sortScores - sorts the vector
	void sortScores();
	// clearScores - clears the vector
	void clearScores();
	// averageScores - calculates the average score
	float averageScores() const;
	// lowestScore - returns the lowest score
	float lowestScore() const;
	// highestScore - returns the highest score
	float highestScore() const;
	// numScores - returns the number of scores in the vector
	int numScores() const;
	// getVector - returns a copy of the scores vector
	std::vector<float> getVector() const;
	// printEmployeeInfo - prints the employee info
	void printEmployeeInfo() const;

private:
	std::string name;
	std::string city;
	std::string employeeID;
	std::vector<float> scores;
};

