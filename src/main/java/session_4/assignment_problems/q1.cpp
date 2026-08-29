#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int nums[n];
    int answer[n];

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    int leftProduct = 1;

    for (int i = 0; i < n; i++) {
        answer[i] = leftProduct;
        leftProduct *= nums[i];
    }

    int rightProduct = 1;

    for (int i = n - 1; i >= 0; i--) {
        answer[i] *= rightProduct;
        rightProduct *= nums[i];
    }

    for (int i = 0; i < n; i++) {
        cout << answer[i] << " ";
    }

    return 0;
}