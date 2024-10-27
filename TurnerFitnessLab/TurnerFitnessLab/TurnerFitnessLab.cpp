// Turner

#include <iostream>
#include <iomanip>
#include <cmath>
#include <sstream>
using namespace std;
stringstream sstm;


void printMenu(bool& option1, bool& option2, bool& option3, bool& option4)
{
    system("CLS");
   

    cout << "********************* Planet Fitness  *********************\n";
    cout << "********************* Membership Menu *********************\n";
    cout << "Please consider these options\n"; 
    if (option1)
        cout << "1. Senior Discount*\n";
    else
        cout << "1. Senior Discount\n";
    if (option2)
        cout << "2. Prepay*\n";
    else
        cout << "2. Prepay\n";
    if (option3)
        cout << "3. Personal Training*\n";
    else
        cout << "3. Personal Training\n";
    cout << "4. Next\n\n";
    cout << "Option: 1-4: ";
}

void getOption(bool& option1, bool& option2, bool& option3, bool& option4)
{
    int option;
    cin >> option;
    if (option == 1) option1 = true;
    if (option == 2) option2 = true;
    if (option == 3) option3 = true;
    if (option == 4) option4 = true;
}

bool determineToContinue(bool& option1, bool& option2, bool& option3, bool& option4)
{
    if (option4) return false;
    if (option1 && option2 && option3) return false;
    return true;
}

void printInvoice(bool& option1, bool& option2, bool& option3, bool& option4)
{
    int numMonths = 0;
    int sessions = 0;
    int costBeforeDiscounts = 0;
    int personalTrainingCost = 0;
    int totalFees = 0;
    int seniorDiscount = 0;
    int prepayDiscount = 0;
    int trainingDiscount = 0;
    int totalDiscounts = 0;
    int grandTotal = 0;
    string moneySign = "$";
    string result = "";
    if (!option2)
    {
        cout << "How many months is your membership? ";
        cin >> numMonths;
        costBeforeDiscounts = numMonths * 50;
        system("CLS");
    }
    else
    {
        prepayDiscount = 90;
        costBeforeDiscounts = 600;
    }
       
    if (option3)
    {
        cout << "How many sessions of personal training? ";
        cin >> sessions;
        system("CLS");
    }
    sstm << moneySign << costBeforeDiscounts;
    result = sstm.str();
    sstm.str("");
    cout << "**************** Extra Options ****************\n";
    cout << "Desired personal training sessions $50/each: ";
    cout << sessions;
    cout << "\n\n\n\n*************** Invoice ***************\n\n";
    cout << setw(28) << "Membership Before Discounts:" << setw(8) << result << ".00" << endl;
    personalTrainingCost = sessions * 50;
    sstm << moneySign << personalTrainingCost;
    result = sstm.str();
    sstm.str("");
    cout << setw(28) << "Personal Training:" << setw(8) << result << ".00" << endl;
    totalFees = personalTrainingCost + costBeforeDiscounts;
    sstm << moneySign << totalFees;
    result = sstm.str();
    sstm.str("");
    cout << setw(28) << "Total Fees:" << setw(8) << result << ".00" << endl << endl;
    if (option1)
        seniorDiscount = costBeforeDiscounts * .30;
    sstm << moneySign << seniorDiscount;
    result = sstm.str();
    sstm.str("");
    cout << setw(28) << "Senior Discount (30%):" << setw(8) << result << ".00" << endl;
    sstm << moneySign << prepayDiscount;
    result = sstm.str();
    sstm.str("");
    cout << setw(28) << "Prepay Discount (15%):" << setw(8) << result << ".00" << endl;
    if (sessions >= 6)
        trainingDiscount = personalTrainingCost * .2;
    sstm << moneySign << trainingDiscount;
    result = sstm.str();
    sstm.str("");
    cout << setw(28) << "Training Discount (20%):" << setw(8) << result << ".00" << endl;
    totalDiscounts = seniorDiscount + prepayDiscount + trainingDiscount;
    sstm << moneySign << totalDiscounts;
    result = sstm.str();
    sstm.str("");
    cout << setw(28) << "Total Discounts:" << setw(8) << result << ".00" << endl << endl;
    grandTotal = totalFees - totalDiscounts;
    sstm << moneySign << grandTotal;
    result = sstm.str();
    sstm.str("");
    cout << setw(28) << "Grand Total:" << setw(8) << result << ".00" << endl << endl;
    cout << "***************************************";
}

int main()
{
    bool shouldwecontinue = true;
    bool option1 = false, option2 = false, option3 = false, option4 = false;
    while (shouldwecontinue)
    {
        printMenu(option1, option2, option3, option4);
        getOption(option1, option2, option3, option4);
        shouldwecontinue = (determineToContinue(option1, option2, option3, option4));
    }
    printInvoice(option1, option2, option3, option4);
}



