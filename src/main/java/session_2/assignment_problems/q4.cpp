#include <iostream>
#include <string>
#include <cctype>
using namespace std;

string trim(string str) {
    int start = 0;
    int end = str.length() - 1;

    while (start <= end && isspace(str[start])) {
        start++;
    }

    while (end >= start && isspace(str[end])) {
        end--;
    }

    return str.substr(start, end - start + 1);
}

int main() {
    string raw;
    getline(cin, raw);

    string code = trim(raw);

    if (code.length() != 13) {
        cout << "Invalid: wrong length" << endl;
        return 0;
    }

    string publisher = code.substr(0, 3);

    for (int i = 0; i < 3; i++) {
        publisher[i] = toupper(publisher[i]);
    }

    code = publisher + code.substr(3);

    for (int i = 0; i < 3; i++) {
        if (!isalpha(code[i])) {
            cout << "Invalid: publisher code must be 3 letters" << endl;
            return 0;
        }
    }

    for (int i = 3; i < 13; i++) {
        if (!isdigit(code[i])) {
            cout << "Invalid: body must contain only digits" << endl;
            return 0;
        }
    }

    string year = code.substr(3, 4);
    string catalog = code.substr(7, 6);

    cout << "[" << publisher << "] YEAR: "
         << year << " | CATALOG: "
         << catalog << endl;

    return 0;
}