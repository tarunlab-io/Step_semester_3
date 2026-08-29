#include <iostream>
using namespace std;

int main() {
    int n, m;

    cin >> n;

    int arr1[n];

    for (int i = 0; i < n; i++) {
        cin >> arr1[i];
    }

    cin >> m;

    int arr2[m];

    for (int i = 0; i < m; i++) {
        cin >> arr2[i];
    }

    int result[n + m];

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < n && j < m) {
        if (arr1[i] <= arr2[j]) {
            result[k++] = arr1[i++];
        } else {
            result[k++] = arr2[j++];
        }
    }

    while (i < n) {
        result[k++] = arr1[i++];
    }

    while (j < m) {
        result[k++] = arr2[j++];
    }

    for (int x = 0; x < n + m; x++) {
        cout << result[x] << " ";
    }

    return 0;
}