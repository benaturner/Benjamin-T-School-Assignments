// Turner

#include <iostream>
#include <fstream>
#include <string>
#include <cmath>
#include <iomanip>

using namespace std;

int numberofrooms = 0;
int daystostay = 0;
float roomrate = 0.0;
float salestaxrate = 0.0;
float discount = 0.0;
const float discount10_19 = .10;
const float discount20_29 = .20;
const float discount30_up = .30;

void getkeyboardinputs()
{
    system("cls");
    cout << "Enter the number of rooms: ";
    cin >> numberofrooms;
    cout << "Enter the number of days to stay: ";
    cin >> daystostay;
}

void getfileinputs()
{
    ifstream marriot("input.txt");
    string line;
    getline(marriot, line);
    roomrate = stof(line);
    getline(marriot, line);
    salestaxrate = stof(line);
}

void generatinginvoice()
{
    ofstream MyFile("output.txt");
    MyFile << right << setw(50) << "Cost of renting one room:" << right << setw(10) << roomrate << endl;
    MyFile << right << setw(50) << "Discount rate per room (%):" << right << setw(10) << discount << endl;
    MyFile << "Number of rooms booked:" << numberofrooms << endl;
    MyFile << "number of days booked:" << daystostay << endl;
    MyFile << "Total cost of the rooms:" << fixed << setprecision(2) << (roomrate * numberofrooms * daystostay) * (1 - discount) << endl;
    MyFile << "Sales Tax: " << fixed << setprecision(2) << (roomrate * numberofrooms * daystostay) * (1 - discount) * salestaxrate << endl;
    MyFile << "Total Billing Amount: " << fixed << setprecision(2) << (roomrate * numberofrooms * daystostay) * (1 - discount) * (1 + salestaxrate) << endl;
    MyFile.close();
}

void calculatingdiscount()
{
    if (numberofrooms >= 10 && numberofrooms <= 19) discount = discount10_19;
    else
        if (numberofrooms >= 20 && numberofrooms <= 29) discount = discount20_29;
        else
            if (numberofrooms >= 30) discount = discount30_up;
}

int main()
{
    getkeyboardinputs();
    getfileinputs();
    calculatingdiscount();
    generatinginvoice();
    system("pause");
}


