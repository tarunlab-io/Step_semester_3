#include <iostream>
#include <string>
#include <cctype>
using namespace std;

string normalizeReference(string raw) {
    int start = 0;
    int end = raw.length() - 1;

    while (start <= end && isspace(raw[start]))
        start++;

    while (end >= start && isspace(raw[end]))
        end--;

    string reference = raw.substr(start, end - start + 1);

    if (reference.length() >= 3) {
        for (int i = 0; i < 3; i++) {
            reference[i] = toupper(reference[i]);
        }
    }

    return reference;
}

string validateAndFormat(string reference) {
    if (reference.length() != 14)
        return "Invalid: wrong length";

    for (int i = 0; i < 3; i++) {
        if (!isalpha(reference[i]))
            return "Invalid: bank code must be 3 letters";
    }

    for (int i = 3; i < 14; i++) {
        if (!isdigit(reference[i]))
            return "Invalid: body must contain only digits";
    }

    string bankCode = reference.substr(0, 3);
    string date = reference.substr(3, 6);
    string sequence = reference.substr(9, 5);

    string formattedDate = date.substr(0, 2) + "/" +
                           date.substr(2, 2) + "/" +
                           date.substr(4, 2);

    return "[" + bankCode + "] DATE: " +
           formattedDate + " | SEQ: " + sequence;
}

int main() {
    string raw;
    getline(cin, raw);

    string reference = normalizeReference(raw);

    cout << validateAndFormat(reference) << endl;

    return 0;
}