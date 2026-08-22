#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int sectionA[n];
    int sectionB[n];

    for (int i = 0; i < n; i++) {
        cin >> sectionA[i];
    }

    for (int i = 0; i < n; i++) {
        cin >> sectionB[i];
    }

    int totalA = 0;
    int totalB = 0;

    for (int i = 0; i < n; i++) {
        totalA += sectionA[i];
        totalB += sectionB[i];
    }

    int highest = sectionA[0];
    char section = 'A';
    int index = 0;

    for (int i = 0; i < n; i++) {
        if (sectionA[i] > highest) {
            highest = sectionA[i];
            section = 'A';
            index = i;
        }

        if (sectionB[i] > highest) {
            highest = sectionB[i];
            section = 'B';
            index = i;
        }
    }

    cout << "Section A Total: " << totalA;
    cout << " | Section B Total: " << totalB;

    if (totalA == totalB) {
        cout << " | Status: Balanced";
    } else {
        cout << " | Status: Not Balanced";
    }

    cout << " | Highest Quantity: " << highest;
    cout << " (Section " << section << ", Item " << index + 1 << ")" << endl;

    return 0;
}