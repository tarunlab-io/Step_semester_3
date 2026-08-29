#include <iostream>
using namespace std;

int main() {
    int n;
    cin >> n;

    int nums[n];

    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    int left = 0;
    int right = n - 1;

    while (left < right) {
        if (nums[left] < nums[right]) {
            break;
        }

        int mid = left + (right - left) / 2;

        if (nums[mid] > nums[right]) {
            left = mid + 1;
        }
        else {
            right = mid;
        }
    }

    cout << nums[left] << endl;

    return 0;
}