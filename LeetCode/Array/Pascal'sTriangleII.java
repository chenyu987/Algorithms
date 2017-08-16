Pascal's Triangle II
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3, Return [1,3,3,1].

Note: Could you optimize your algorithm to use only O(k) extra space?
逆序相加法
复杂度
时间 O(N) 空间 O(k)

思路
同样用迭代的方法，根据上一层的值算下一层，不过这里每一层都在同一个List上操作。如果我们从后向前计算，而且每次计算都用到上一个位置的数的话，我们会重复计算好几次，导致结果错误。这里的技巧在于从后向前计算，并且每次计算用当前位置的值和上一位置的值，来更新当前位置的值。最后再在后面加个1，就是这一层的结果了。

代码
public class Solution {
    public List<Integer> getRow(int k) {
        List<Integer> line = new ArrayList<Integer>();
        // 加入第一个1
        line.add(1);
        if(k <= 0) return line;
        for(int i = 1; i <= k; i++){
            // 计算j+1位置的值，是根据j位置的值和j+1位置的值得到的，相当于往后位移一位
            // 这样不怕被overwrite
            for(int j = line.size() - 2; j >= 0; j--){
                line.set(j + 1, line.get(j) + line.get(j + 1));
            }
            // 加上最后一个1
            line.add(1);
        }
        return line;
    }
}
公式法
复杂度
时间 O(K) 空间 O(1)

思路
更“暴力”的方法，是直接使用公式，对于第k(k>=1)层下标为i(i>=0)的位置，数字应该为num[i-1] * (k - i) / i，由于这个乘法可能溢出，我们用一个long型临时变量将其存起来。

注意
rowIndex是0开始的，公式中k是1开始的

代码
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        // rowIndex是0开始的，我们将它加1，得到k
        int k = rowIndex + 1;
        ArrayList<Integer> line = new ArrayList<Integer>();
        line.add(1);
        long tmp = 1;
        for(int i = 1; i < k; i++){
            // 使用公式 上一个数乘以(k-i)再除以i
            tmp = tmp * (k - i) / i;
            line.add((int)tmp);
        }
        return line;
    }
}