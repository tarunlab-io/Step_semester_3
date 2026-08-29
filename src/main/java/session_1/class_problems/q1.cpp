#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
#include <iomanip>
using namespace std;

string playRound(string playerMove, string computerMove) {
    if (playerMove == computerMove)
        return "Draw";

    if ((playerMove == "Rock" && computerMove == "Scissors") ||
        (playerMove == "Paper" && computerMove == "Rock") ||
        (playerMove == "Scissors" && computerMove == "Paper"))
        return "Player Wins";

    return "Computer Wins";
}

int main() {
    srand(time(0));

    string moves[] = {"Rock", "Paper", "Scissors"};
    int n = 5;

    string playerMoves[5];
    string computerMoves[5];
    string results[5];

    int wins = 0, losses = 0, draws = 0;

    for (int i = 0; i < n; i++) {
        cout << "Enter your move (Rock/Paper/Scissors): ";
        cin >> playerMoves[i];

        int randomIndex = rand() % 3;
        computerMoves[i] = moves[randomIndex];

        results[i] = playRound(playerMoves[i], computerMoves[i]);

        if (results[i] == "Player Wins")
            wins++;
        else if (results[i] == "Computer Wins")
            losses++;
        else
            draws++;
    }

    cout << "\nRound\tPlayer\t\tComputer\tResult\n";

    for (int i = 0; i < n; i++) {
        cout << i + 1 << "\t"
             << playerMoves[i] << "\t\t"
             << computerMoves[i] << "\t\t"
             << results[i] << endl;
    }

    double winPercentage = (double)wins / n * 100;

    cout << "\nWins: " << wins
         << " | Losses: " << losses
         << " | Draws: " << draws
         << " | Win % = " << fixed << setprecision(1)
         << winPercentage << "%" << endl;

    return 0;
}