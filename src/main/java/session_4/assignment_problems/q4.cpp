#include <iostream>
#include <unordered_map>
using namespace std;

int main() {
    int n;
    cin >> n;

    int nums[n];

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    int k;
    cin >> k;

    unordered_map<int, int> frequency;

    frequency[0] = 1;

    int currentSum = 0;
    int count = 0;

    for (int i = 0; i < n; i++) {
        currentSum += nums[i];

        if (frequency.find(currentSum - k) != frequency.end()) {
            count += frequency[currentSum - k];
        }

        frequency[currentSum]++;
    }

    cout << count << endl;

    return 0;
}