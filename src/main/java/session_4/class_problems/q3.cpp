#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int nums[n];

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (nums[i] == nums[j]) {
                cout << "true" << endl;
                return 0;
            }
        }
    }

    cout << "false" << endl;

    return 0;
}