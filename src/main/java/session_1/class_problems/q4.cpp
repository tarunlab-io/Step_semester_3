#include <iostream>
#include <string>
using namespace std;

char findFirstNonRepeatingChar(string text) {
    int frequency[256] = {0};

    for (char ch : text) {
        frequency[(unsigned char)ch]++;
    }

    for (char ch : text) {
        if (frequency[(unsigned char)ch] == 1)
            return ch;
    }

    return '\0';
}

int main() {
    string text;
    getline(cin, text);

    char result = findFirstNonRepeatingChar(text);

    if (result == '\0') {
        cout << "No Non-Repeating Character Found" << endl;
    } else {
        cout << "First Non-Repeating Character: '"
             << result << "'" << endl;
    }

    return 0;
}