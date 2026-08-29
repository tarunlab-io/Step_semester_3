#include <iostream>
#include <string>
#include <cctype>
using namespace std;

string maskPhoneNumber(string phone) {
    if (phone.length() != 10)
        return "Invalid phone number";

    for (char ch : phone) {
        if (!isdigit(ch))
            return "Invalid phone number";
    }

    string masked = "XXXXXX-";
    masked += phone.substr(6, 4);

    return masked;
}

int main() {
    string phone;
    getline(cin, phone);

    cout << maskPhoneNumber(phone) << endl;

    return 0;
}