// Turner

#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <cmath>
using namespace std;


void getData();
void showMenu();
void printCheck();
bool keepGoing = true;
double runningTotal = 0.0;

struct MenuItemType {
    double menuPrice = 0.0;
    string menuItemDescription = "";
    bool isOrdered = false;
} ;

MenuItemType menuList[8];

int main()
{


    getData();
    while (keepGoing)
    {
        showMenu();
        
    }
    printCheck();
}

void getData()
{
    ifstream waffle("menu.txt");
    string holdit;
    for (int itemNo = 0; itemNo <= 7; itemNo++)
    {
        getline(waffle, holdit);
        menuList[itemNo].menuItemDescription = holdit;
        getline(waffle, holdit);
        menuList[itemNo].menuPrice = stof(holdit);
        menuList[itemNo].isOrdered = false;
    }
}

void showMenu()
{
    int choice = 0;
    system("cls");
    cout << "--------------------------------------------\n";
    cout << "--------------- Waffle House ---------------\n\n\n";
    for (int itemNo = 0; itemNo <= 7; itemNo++)
    {
        if (menuList[itemNo].isOrdered)
            cout << left << setw(5) << itemNo + 1 << setw(30) << left << menuList[itemNo].menuItemDescription << setw(9) << right << menuList[itemNo].menuPrice << "  *" << endl;
        else
            cout << left << setw(5) << itemNo + 1 << setw(30) << left << menuList[itemNo].menuItemDescription << setw(9) << right << menuList[itemNo].menuPrice << endl;
    }
    cout << "Enter Item Number (1-8) \n";
    cout << "Enter any other number to quit ";
    cin >> choice;
    if (choice > 8 || choice < 1)
        keepGoing = false;
    else
        menuList[choice-1].isOrdered = true;
}

void printCheck()
{
    system("cls");
    cout << "--------------------------------------------\n";
    cout << "--------------- Waffle House ---------------\n";
    cout << "-------------- Customer Check  -------------\n";
    for (int itemNo = 0; itemNo <= 7; itemNo++)
    {
        if(menuList[itemNo].isOrdered)
        {
            cout << left << setw(5) << itemNo + 1 << left << setw(30) << menuList[itemNo].menuItemDescription << right << setw(9) << menuList[itemNo].menuPrice << endl;
            runningTotal = runningTotal + menuList[itemNo].menuPrice; 
        }
    }
    float tax = runningTotal * .05;
    cout << left << setw(5) << "" << left << setw(25) << "Tax" << right << setw(14) << setprecision(2) << fixed << tax << endl;
    cout << "--------------------------------------------\n";
    cout << left << setw(5) << "" << left << setw(25) << "Grand Total" << right << setw(14) << setprecision(2) << fixed << runningTotal + tax << endl;
    cout << "--------------------------------------------\n\n\n";
    cout << "Thank you -- please come again soon!\n\n\n";
            
}




