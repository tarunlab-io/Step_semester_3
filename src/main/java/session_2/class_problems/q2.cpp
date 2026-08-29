#include <iostream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

void parseStudentRecord(string csvLine) {
    vector<string> fields;
    string field;
    stringstream ss(csvLine);

    while (getline(ss, field, ',')) {
        fields.push_back(field);
    }

    if (fields.size() != 3) {
        cout << "Invalid Record" << endl;
        return;
    }

    cout << "Name: " << fields[0]
         << " | Roll No: " << fields[1]
         << " | Dept: " << fields[2] << endl;
}

int main() {
    string csvLine;
    getline(cin, csvLine);

    parseStudentRecord(csvLine);

    return 0;
}