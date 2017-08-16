
Pascal's Triangle I

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5, Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


// Wrote in meeting
public List<List<Integer>> generate (int numRows) {
  List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
  if (numRows <= 0) return res;
  List<Integer> tmp = new ArrayList<Integer>();
  tmp.add(1);
  res.add(tmp);
  for (int i = 1; i < numRows; i++) {
    tmp = new ArrayList<Integer>();
    tmp.add(1);
    for (int j = 0; j < i - 1; j++) {
      tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
    }
    tmp.add(1);
    res.add(tmp);
  }
  return res;
}

// from segment fault, one difference (j <i- 1? i)

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows <= 0) return res;
        List<Integer> one = new ArrayList<Integer>();
        one.add(1);
        res.add(one);
        for(int i = 1; i < numRows; i++){
            List<Integer> line = new ArrayList<Integer>();
            // 加入第一个1
            line.add(1);
            // 加入中间的数
            for(int j = 1; j < i; j++){
                line.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            // 加入最后一个1
            line.add(1);
            res.add(line);
        }
        return res;
    }
}