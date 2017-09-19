
/**
* You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
* 
* Example:
* 
* Given nums = [5, 2, 6, 1]
*                     i
* To the right of 5 there are 2 smaller elements (2 and 1).
* To the right of 2 there is only 1 smaller element (1).
* To the right of 6 there is 1 smaller element (1).
* To the right of 1 there is 0 smaller element.
* Return the array [2, 1, 1, 0].
*/

/*
复杂度：
time： O(n^2) space:O(n)

从右向左遍历数组并且构建BST.当前节点node左子树全部是值小于或者等于当前节点val的节点. 
当前结点node.count就是左子树节点个数之和
每次addNode时假如发现逆序,则可以取当前节点的count值返回
time complexicy at worse case is O(n^2) since it may not be a balanced BST.

优化：
把结果全部加入到List<Integer>里，最后再reverse这个list，要比每次list.add(0, count)速度要快很多
*/

class CountOfSmallerNumbersAfterSelf {
  private class TreeNode {
    int val = 0;
    int cnt = 1;
    TreeNode left; 
    TreeNode right;
    public TreeNode(int val) {
      this.val = val;
    }
  }
  public List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<Integer>();
    if (nums == null || nums.length == 0) return res;
    TreeNode root = new TreeNode(nums[nums.length-1]);
    res.add(0);
    
    for (int i = nums.length - 2; i >= 0; i--) {
      int cnt = addNode(root, nums[i]);
      res.add(cnt);
    }
    Collections.reverse(res);
    return res;
  }
  
  private int addNode(TreeNode root, int val) {
    int curCnt = 0;
    while (true) {
      if (val <= root.val) {
        root.cnt++;
        if (root.left == null) {
          root.left = new TreeNode(val);
          break;
        } else {
          root = root.left;
        }
      } else {
        curCnt += root.cnt;
        if (root.right == null) {
          root.right = new TreeNode(val);
          break;
        } else {
          root = root.right;
        }
      }
    }
    return curCnt;
  }
}

res = [0, 1, 2, 2]

nums = [5, 2, 6, 1]
        i  
   
   
   curCnt = 1;
          
                     root = 1  <- 
                           *1
                             \ 
                              6  <- 
                              *1
                              
=》

                     root = 1  <- 
                           *1
                             \ 
                              6  <- 
                              *2
                            /
                           2 
                          *1
                       
=》
curCnt = 1;
                     root = 1  <- 
                           *1
                             \ 
                              6  <- 
                              *2
                            /
                           2 
                          *1
                       
                       =》
curCnt = 2;
                     root = 1  <- 
                           *1
                             \ 
                              6  <- 
                              *3
                            /
                           2 <-
                          *1
                       
 =》
curCnt = 2;
                     root = 1  <- 
                           *1
                             \ 
                              6  <- 
                              *3
                            /
                           2 <-
                           *1
                             \ 
                              5 
                              *1
                       
                       
worst scenario:                        
                       1 
                         2
                       
                          3 
                       
                            4 
                       
                              5
                       
                                6
cur num = 7
              
1 + 2 + 3 + ... + n - 1 = O(n^2)
                       
                  