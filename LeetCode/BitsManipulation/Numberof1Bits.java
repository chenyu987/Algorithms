
/**
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

unsigned integer
1011
&  1   bit-and
______
0001   cnt++;

0000
&  1
_____
0001

0  1  2  3

1  0  1  1

0  1  0  1

public int hammingWeight(int n) {
  int cnt = 0;
  while (n != 0) {
    if ((n & 1) == 1) {
      cnt++;
    }
    //unsigned shift (move without sign)
    //when shifting to right the first position will always adding 0: 100000...1 will become 0100000...1
    n >>>= 1; 
    // if we write like this ,we are assuming the first 0 or 1 is the sign 10000...0001 will become 11.....0
    // n >>= 1;
  }  
  return cnt;
}


// if would like to know the same idea of 十进位，see reverseInteger leetcode#7
