//Turner
//Loops.cpp : This file contains the 'main' function.
#include <iostream>
#include <thread>
#include <chrono>
#include <conio.h>
#include <windows.h>
#include <ctime>
using namespace std;
int main()
{
    cout << "1. Counting from 1 to 10\n\n";
    for (int i = 1; i <= 10; i++)
        cout << i << endl;
    system("pause");
    system("CLS");
    cout << "2. Counting down from 10 to 1\n\n";
    for (int i = 10; i >= 1; i--)
        cout << i << endl;
    system("pause");
    system("CLS");
    cout << " 3. Counting from 1 to 31 by 5\n\n";
    for (int i = 10; i <= 31; i = i + 5)
        cout << i << " ";
    system("pause");
    system("CLS");
    cout << "4. Counting from 1 to 10, \"break\" at 5\n\n";
    for (int i = 1; i <= 10; i++)
    {
        if (i == 5)
            break;
        cout << i << endl;
    }
    system("CLS");
    cout << "5. Counting from 1 to 10, 'continue' at 5\n\n";
    for (int i = 1; i <= 10; i = i + 1)
    {
        if (i == 5)
            continue;
        cout << i << "\t";
    }
    system("pause");
    system("CLS");

    cout << "6. Move character across the screen!\n\n";
    std::chrono::milliseconds timespan(100);
    char ch = 1;
    for (int i = 1; i <= 40; i++)
    {
        cout << "" << ch ;
        std::this_thread::sleep_for(timespan);
        cout << "\b";
    }
    system("pause");
    system("CLS");
    cout << "7. Count between user-defined number\n\n";
    int startnumber;
    cout << "Enter starting number: ";
    cin >> startnumber;
    cout << "Enter ending number: ";
    int endNumber;
    cin >> endNumber;
    for (int i = startnumber; i <= endNumber; i++)
    {
        cout << i << endl;
    }
    system("pause");
    system("CLS");
    cout << "8. Nested Loops\n\n";
    int k = 0;
    int j = 0;
    for (int i = 1; i <= 2; i++)
    {
        for (int j = 1; j <= 3; j++)
        {
            k = k + 1;
            cout << "i=" << i << "\tj=" << j << "\tk=" << k << endl;
        }
    }
    system("pause");
    system("CLS");
    cout << "9. Counting from 1 to infinity...and beyond!\n\n";
    {
        cout << j << endl;
    }
    system("pause");
    system("CLS");       
}
