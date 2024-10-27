// turner

#include <iostream>
#include "Flame.h"
using namespace std;



void studentType::displayFirstName()
{
    cout << firstName;
}

int main()
{
    studentType libertyStudent;
    libertyStudent.setFirstName("Ben");
    libertyStudent.lastName = "Turner";
    libertyStudent.displayFirstName();
    cout << libertyStudent.lastName;
}