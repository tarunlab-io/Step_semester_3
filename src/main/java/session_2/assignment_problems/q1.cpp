#include <iostream>
#include <string>
using namespace std;

int main() {
    string pin;
    cin >> pin;

    if (pin.length() != 4) {
        cout << "Invalid PIN — must be exactly 4 digits." << endl;
    } else {
        cout << "PIN length OK." << endl;
    }

    return 0;
}