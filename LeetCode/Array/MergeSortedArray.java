
// Given two sorted integer arrays A and B, merge B into A as one sorted array. Note: You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    int i = m-1, j = n-1, index = m + n - 1;
    while (i >= 0 && j >= 0) {
        if (A[i] > B[j]) {
            A[index--] = A[i--];
        } else {
            A[index--] = B[j--];
        }
    }
    //actually this is not necessary because A's element is already there
    while (i >= 0) {
        A[index--] = A[i--];
    }
    while (j >= 0) {
        A[index--] = B[j--];
    }
}