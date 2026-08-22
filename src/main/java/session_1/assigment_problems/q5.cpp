#include <iostream>
#include <sstream>
#include <string>
using namespace std;

int main() {
    string review;
    getline(cin, review);

    stringstream ss(review);
    string word;

    int shortWords = 0;
    int mediumWords = 0;
    int longWords = 0;

    while (ss >> word) {
        int length = word.length();

        if (length >= 1 && length <= 4) {
            shortWords++;
        } else if (length <= 8) {
            mediumWords++;
        } else {
            longWords++;
        }
    }

    cout << "Short: " << shortWords;
    cout << " | Medium: " << mediumWords;
    cout << " | Long: " << longWords << endl;

    return 0;
}