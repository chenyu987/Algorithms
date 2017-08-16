//gray code
/**
* The gray code is a binary numeral system where two successive values differ in only one bit.
* 
* Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
* 
* For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
* 
* 00 - 0
* 01 - 1
* 11 - 3
* 10 - 2
* Note:
* For a given n, a gray code sequence is not uniquely defined.
* 
* For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
*/

1: 0     1

2: 00    01     11     10 

3: 000   001    011    010    110     111     101    100 

4: 16个

public List<Integer> grayCode(int n) {
  List<Integer> res = new ArrayList<>();
  res.add(0);
  for (int i = 0; i < n; i++) {
//   1左移i位
    int hiBit = 1<<i;
    int len = res.size();
    for (int j = len - 1; j >= 0; j--) {
      int curNum = res.get(j);
      curNum += hiBit;
      res.add(curNum);
    }
  }
  return res;
}