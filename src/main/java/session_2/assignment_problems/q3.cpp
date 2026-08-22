#include <iostream>
#include <string>
using namespace std;

int main() {
    string csvLine;
    getline(cin, csvLine);

    string fields[3];
    int fieldCount = 0;
    string current;

    for (char ch : csvLine) {
        if (ch == ',') {
            if (fieldCount < 3) {
                fields[fieldCount++] = current;
                current = "";
            } else {
                fieldCount++;
            }
        } else {
            current += ch;
        }
    }

    if (fieldCount < 3) {
        fields[fieldCount++] = current;
    }

    if (fieldCount != 3) {
        cout << "Invalid Record" << endl;
    } else {
        cout << "Product: " << fields[0]
             << " | SKU: " << fields[1]
             << " | Qty: " << fields[2] << endl;
    }

    return 0;
}