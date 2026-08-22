#include <iostream>
#include <string>
#include <sstream>
#include <unordered_map>
#include <vector>
#include <algorithm>
#include <cctype>
using namespace std;

int main() {
    string feedback;
    getline(cin, feedback);

    for (char &ch : feedback) {
        ch = tolower(ch);

        if (ch == '.' || ch == ',' || ch == '!' || ch == '?') {
            ch = ' ';
        }
    }

    stringstream ss(feedback);
    string word;

    string stopWords[] = {"the", "was", "and", "a", "is", "of", "in"};

    unordered_map<string, int> frequency;

    while (ss >> word) {
        bool isStopWord = false;

        for (string stop : stopWords) {
            if (word == stop) {
                isStopWord = true;
                break;
            }
        }

        if (!isStopWord) {
            frequency[word]++;
        }
    }

    vector<pair<string, int>> words;

    for (auto item : frequency) {
        words.push_back(item);
    }

    sort(words.begin(), words.end(), [](const pair<string, int>& a,
                                        const pair<string, int>& b) {
        return a.second > b.second;
    });

    for (auto item : words) {
        cout << item.first << ": " << item.second << endl;
    }

    return 0;
}