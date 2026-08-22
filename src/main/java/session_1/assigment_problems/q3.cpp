#include <iostream>
#include <string>
using namespace std;

int main() {
    string signalLog;
    cin >> signalLog;

    int currentStreak = 1;
    int longestStreak = 1;
    char longestColor = signalLog[0];

    for (int i = 1; i < signalLog.length(); i++) {
        if (signalLog[i] == signalLog[i - 1]) {
            currentStreak++;
        } else {
            currentStreak = 1;
        }

        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestColor = signalLog[i];
        }
    }

    cout << "Longest Streak: '" << longestColor
         << "' repeated " << longestStreak << " times" << endl;

    return 0;
}