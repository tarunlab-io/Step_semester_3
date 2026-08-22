#include <iostream>
#include <sstream>
#include <string>
using namespace std;

int main() {
    string sentence;
    getline(cin, sentence);

    stringstream ss(sentence);
    string word;
    string result;

    while (ss >> word) {
        string reversed;

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word[i];
        }

        if (!result.empty()) {
            result += " ";
        }

        result += reversed;
    }

    cout << result << endl;

    return 0;
}