#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string validateFileExtension(string filename) {
    int dotPosition = filename.find_last_of('.');

    if (dotPosition == string::npos)
        return "Rejected — invalid file type";

    string extension = filename.substr(dotPosition + 1);

    transform(extension.begin(), extension.end(), extension.begin(), ::tolower);

    if (extension == "pdf" ||
        extension == "docx" ||
        extension == "zip") {
        return "Accepted";
    }

    return "Rejected — invalid file type";
}

int main() {
    string filename;
    getline(cin, filename);

    cout << validateFileExtension(filename) << endl;

    return 0;
}