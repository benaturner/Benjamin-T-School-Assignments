#pragma once
#include <iostream>
using namespace std;

class studentType
{
private:
    string firstName = " ";
public:
    string lastName = " ";
    void displayFirstName();
    string getFirstName()
    {
        return firstName;
    }
    void setFirstName(string spaghetti)
    {
        firstName = spaghetti;
    }
};