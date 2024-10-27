// Turner
//

#include <iostream>
using namespace std;

void displayHardCodedArray()
{
    cout << "\n\nExhibit 1 - Hard-Coded Array\n\n";
    int numbers[5] = { 7, 5, 6, 12, 35 };

    cout << "The numbers are: ";
    for (int i = 0; i < 5; ++i) {
        cout << numbers[i] << "  ";
    }
    getchar();
    system("CLS");
}

void userCreatedArray()
{
    int numbers[5];
    cout << "\n\nExhibit 2 - User-defined Array contents \n\n";
    cout << "Enter 5 numbers: " << endl;
    
    // store input from user to array
    for (int i = 0; i < 5; ++i) {
        cin >> numbers[i];
    }

    cout << "The numbers are: ";

    // print array elements
    for (int n = 0; n < 5; ++n) {
        cout << numbers[n] << "  ";
    }
    getchar();
    getchar();
    system("CLS");
}

void averageSumArray()
{
    cout << "\n\nExhibit 3 - Calculating sum and average of array elements\n\n";
    double numbers[] = { 7, 5, 6, 12, 35, 27 };

    double sum = 0;
    double count = 0;
    double average;

    cout << "The numbers are: ";

    for (int i = 0; i <= 5; i++) {
        cout << numbers[i] << "  ";

        //calculate the sum
        sum += numbers[i];

        // count the no. of array elements
        ++count;
    }

    // print the sum
    cout << "\nTheir Sum = " << sum << endl;

    //find the average
    average = sum / count;
    cout << "Their Average = " << average << endl;
    getchar();
    system("CLS");
}

void twoDArray()
{
    cout << "\n\nExhibit 4 - 2D Array example\n\n";
    int test[3][2] = { {2, -5},
                    {4, 0},
                    {9,1} };

    for (int i = 0; i < 3; ++i) {

        //access columns of the array
        for (int j = 0; j < 2; ++j) {
            cout << "test[" << i << "][" << j << "] = " << test[i][j] << endl;
        }
    }
    getchar();
    system("CLS");
}

int main()
{
    displayHardCodedArray();
    userCreatedArray();
    averageSumArray();
    twoDArray();
}

