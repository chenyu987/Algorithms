/**
* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
* 
* 
* Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
* 
* 
* The largest rectangle is shown in the shaded area, which has area = 10 unit.
* 
* For example,
* Given heights = [2,4,5,6,2,3],
* return 10.
*/

          1
      1   1
   1  1   1
   1  1   1      1
1  1  1   1   1  1
1  1  1   1   1  1 
          3   i
              4
      2
   1
0   
public int largestArea(int[] heights) {
  if (heights == null || heights.length == 0) return 0;
  int maxArea = 0;
  int curArea = 0;
  Stack<Integer> stack = new Stack<Integer>();
  for (int i = 0; i < heights.length; i++) {
    while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
      int idx = stack.pop();
      int height = heights[idx];
      int width = stack.isEmpty() ? i : (i-1-stack.peek());  
      curArea = height*width;
      maxArea = Math.max(maxArea, curArea);
    }
  }
  while (!stack.isEmpty()) {
    int idx = stack.pop();
    int height = heights[idx];
    int width = stack.isEmpty() ? heights.length : (heights.length-1-stack.peek());
    curArea = height*width;
    maxArea = Math.max(maxArea, curArea);
  }
  return maxArea;
}
