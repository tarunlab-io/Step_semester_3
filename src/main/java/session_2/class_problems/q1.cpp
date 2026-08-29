#include <iostream>
#include <string>
#include <cctype>
using namespace std;

void countVowelsAndConsonants(string text) {
    int vowels = 0;
    int consonants = 0;

    for (char ch : text) {
        ch = tolower(ch);

        if (ch == ' ')
            continue;

        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            vowels++;
        else
            consonants++;
    }

    cout << "Vowels: " << vowels
         << " | Consonants: " << consonants << endl;
}

int main() {
    string text;
    getline(cin, text);

    countVowelsAndConsonants(text);

    return 0;
}