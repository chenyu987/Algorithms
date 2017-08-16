
Verify Preorder Sequence in Binary Search Tree

// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

// You may assume each number in the sequence is unique.

// Follow up: Could you do it using only constant space complexity?


    10
   /  \
  5    12
 / \
2   6
     \
      13

    10
   /   \
  5     13
 / \    /
2   6  12

 
  
10 - 5 -2 -6- 12
 
[10 , 5 , 2]  MIN = 2;如果后面出现一个比2大的，那么就不对

[10,6]  

min = 5;

min = 6;
min = 10;

[13] 
min = 10;


[10, 5, 2, 6, 13, 12]



2
5
10

min = 2
5
10

min = 5
6
10

min = 6;
10
  
min = 10;
13

min = 10;
12
13



  
public boolean verifyPreorder(int[] preorder) {
  Stack<Integer> stk = new Stack<Integer>();
  int min = Integer.MIN_VALUE;
  for (int num: preorder) {
    if (num < min) return false;
    while (!stk.isEmpty() && num > stack.peek()) {
      min = stk.pop();
    }
    stk.push(num);
  }
  return true;
}

