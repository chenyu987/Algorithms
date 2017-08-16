
/*
There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

有两个有序数组nums1和nums2，他们的大小各是m和n，请找出这两个数组所有数的中位数，总得时间复杂度不超过O(log(m+n))
*/

A
[ 1, 2, 3, 4, 5]

3


B
[4, 6, 7, 8 ]

6.5

//Wrote from Jiuzhang 

public class Solution {
    public double findMedianSortedArray(int A[], int B[]) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0 , B, 0, len / 2 + 1)) / 2;
    }
    
    public int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        if (A_start >= A.length) {
            return B[B_start + k -1];
        }
        if (B_start >= B.length) {
            return A[A_start + k -1];
        }
        int A_key = A_start + k/2 - 1 <A.length? A[A_start + k/2 - 1]: Integer.MAX_VALUE;
        int B_key = B_start + k/2 - 1 <B.length? B[B_start + k/2 - 1]: Integer.MAX_VALUE;

        if (A_key < B_key) {
            return findKth(A, A_start + k / 2, B, B_start, k - k/2);
        } else {
            return findKth(A, A_start, B, B_start + k / 2, k - k/2);
        }
     }
}

// From Liu Zhe, not completed yet
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length == 0 && nums2.length == 0) return 0;
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            //System.out.println("inside if claud");
            return findMedian(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len/2 + 1); 
        } else {
          double sum = findMedian(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len/2) + findMedian(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, len/2 + 1);
            //System.out.println("in side else claud")
            return sum / 2;
        }
    }
    private double findMedian(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
      //System.out.println("find k = " + k);
      if (start1 > end1) return nums2[k-1];
        if (start2 > end2)  return nums1[k-1];
        System.out.println("k = " + k + "    start1 = " + start1 + "    start2 = " + start2);
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        // always assume nums1 has less length
        if (end1-start1+1 > end2-start2+1) {
          return findMedian(nums2, start2, end2, nums1, start1, end1, k);
        }
        int len1 = Math.min(end1-start1+1, k/2);
        int len2 = k - len1;
        if (nums1[len1-1] < nums2[len2-1]) {
          System.out.println("nums1 < nums2");
          return findMedian(nums1, len1, end1, nums2, start2, end2, k - len1);
        } else if (nums1[len1-1] > nums2[len2-1]) {
            System.out.println("nums2 > nums1");
            return findMedian(nums1, start1, end1, nums2, len2, end2, k - len2);
        } else {
          return nums1[len1-1];
        }
    }
