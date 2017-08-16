/**
* Given a list of non negative integers, arrange them such that they form the largest number.
* 
* For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
* 
* Note: The result may be very large, so you need to return a string instead of an integer.
*/

/*
复杂度
时间O(n) 空间O(n)
思路： 
先把输入数组排序 自定义Comparator：按照最高位的大小进行排序 
*/


public class LargestNumber {
  public String largestNumber(int[] nums) {
    if (nums == null || nums.length == 0) return "";
		Integer[] copy = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++) {
			copy[i] = nums[i];
		}
		//自定义Comparator 按照拼接后的字符串大小比较
		Arrays.sort(copy, new Comparator<Integer>() {
			public int compare(Integer item1, Integer item2) {
				String str1 = String.valueOf(item1);
				String str2 = String.valueOf(item2);
				String combo1 = str1 + str2;
				String combo2 = str2 + str1;
				return combo2.compareTo(combo1);
			}	
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 && copy[i] == 0) {
				return "0";
			}
			sb.append(copy[i]);
		}
		return sb.toString();
  }
} 


// version from small to large, I wrote in coding meeting
public class Solution {
    public string largest(int[] nums) {
        Integer[] ints = new Integer[nums.length];
        for (int i = 0; i<nums.length; i++) {
            ints[i] = nums[i];
        }
        Arrays.sort(ints, new Comparator<Integer>() {
            public int compare(Integer n1, Integer n2) {
                String string1 = String.valueOf(n1);
                String string2 = String.valueOf(n2);
                return (string1 + string2).compareTo(string2 + string1);
            }
        });
        StringBuilder sb = new StringBuilder();
        if (ints[nums.length - 1] == 0) return "0";
        for (int i = nums.length - 1, i >=0; i--) {
            sb.append(ints[i]);
        }
        return sb.toString();
   }
}
        
        


