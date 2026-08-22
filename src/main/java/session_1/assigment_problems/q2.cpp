#include <iostream>
#include <iomanip>
#include <string>
using namespace std;

int main() {
    string original, typed;

    getline(cin, original);
    getline(cin, typed);

    int matched = 0;
    int firstMismatch = -1;

    for (int i = 0; i < original.length(); i++) {
        if (original[i] == typed[i]) {
            matched++;
        } else if (firstMismatch == -1) {
            firstMismatch = i;
        }
    }

    double accuracy = (double)matched / original.length() * 100;

    cout << "Matched: " << matched << "/" << original.length();
    cout << " | Accuracy: " << fixed << setprecision(2) << accuracy << "%";

    if (firstMismatch == -1) {
        cout << " | No Mismatches" << endl;
    } else {
        cout << " | First Mismatch at position " << firstMismatch + 1;
        cout << " ('" << original[firstMismatch] << "' vs '"
             << typed[firstMismatch] << "')" << endl;
    }

    return 0;
}