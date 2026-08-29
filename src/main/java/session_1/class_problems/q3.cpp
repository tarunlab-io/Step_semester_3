#include <iostream>
#include <iomanip>
using namespace std;

string getBmiStatus(double bmi) {
    if (bmi < 18.5)
        return "Underweight";
    else if (bmi < 25)
        return "Normal";
    else if (bmi < 30)
        return "Overweight";
    else
        return "Obese";
}

void printWellnessReport(double heights[], double weights[], int n) {
    cout << left
         << setw(10) << "Person"
         << setw(15) << "Height(m)"
         << setw(15) << "Weight(kg)"
         << setw(10) << "BMI"
         << "Status" << endl;

    for (int i = 0; i < n; i++) {
        double bmi = weights[i] / (heights[i] * heights[i]);

        cout << left
             << setw(10) << i + 1
             << setw(15) << fixed << setprecision(2) << heights[i]
             << setw(15) << weights[i]
             << setw(10) << bmi
             << getBmiStatus(bmi) << endl;
    }
}

int main() {
    int n;

    cout << "Enter number of people: ";
    cin >> n;

    double heights[n];
    double weights[n];

    for (int i = 0; i < n; i++) {
        cout << "Enter height and weight for person "
             << i + 1 << ": ";
        cin >> heights[i] >> weights[i];
    }

    cout << endl;

    printWellnessReport(heights, weights, n);

    return 0;
}