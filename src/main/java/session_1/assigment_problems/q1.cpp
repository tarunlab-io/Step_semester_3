#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int seats[n];

    for (int i = 0; i < n; i++) {
        cin >> seats[i];
    }

    bool found = false;

    for (int i = 0; i < n; i++) {
        bool alreadyPrinted = false;

        for (int k = 0; k < i; k++) {
            if (seats[k] == seats[i]) {
                alreadyPrinted = true;
                break;
            }
        }

        if (alreadyPrinted)
            continue;

        for (int j = i + 1; j < n; j++) {
            if (seats[i] == seats[j]) {
                cout << "Duplicate Seat Number Found: " << seats[i] << endl;
                found = true;
                break;
            }
        }
    }

    if (!found) {
        cout << "No Duplicate Seats Found" << endl;
    }

    return 0;
}