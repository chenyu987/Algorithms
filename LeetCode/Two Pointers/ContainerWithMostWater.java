// Container With Most Water
// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the containercontains the most water.

// Note: You may not slant the container.
// 栈法
// 复杂度
// 时间 O(N) 空间 O(N)

// 思路
// 最大盛水量取决于两边中较短的那条边，而且如果将较短的边换为更短边的话，盛水量只会变少。所以我们可以用两个头尾指针，计算出当前最大的盛水量后，将较短的边向中间移，因为我们想看看能不能把较短的边换长一点。这样一直计算到左边大于右边为止就行了。

// 注意
// 如果将较短的边向中间移后，新的边还更短一些，其实可以跳过，减少一些计算量

// 代码
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while(left < right){
            // 每次更新最大面积（盛水量）
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            // 如果左边较低，则将左边向中间移一点
            if(height[left] < height[right]){
                left++;
            // 如果右边较低，则将右边向中间移一点
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

// 后续 Follow Up
// Q：在答题之前我需要知道些什么？ A：因为回文的定义原本只适用于字符串，所以我们要先问清楚数字回文是如何定义的。首先，负数是否算回文。其次，在计算回文时，我们应该按十进制算还是其他进制，如二进制。