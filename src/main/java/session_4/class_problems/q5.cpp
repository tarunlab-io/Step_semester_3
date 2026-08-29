#include <iostream>
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

    k = k % n;

    int result[n];

    for (int i = 0; i < n; i++) {
        result[(i + k) % n] = nums[i];
    }

    for (int i = 0; i < n; i++) {
        cout << result[i] << " ";
    }

    return 0;
}