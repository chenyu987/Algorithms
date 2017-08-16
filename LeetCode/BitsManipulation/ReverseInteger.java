x = 123 -> res = 321 with sign
Integer.MIN_VALUE; 

int -2^31 --- +2^31 - 1

public int reverse(int x) {
  long res = 0;
  //if x is Integer.Min_Value, then it is overflow(int -2^31 --- +2^31 - 1)
  long xL = Math.abs((long)x);
  while (xL > 10) {
    //十进制的左移+补零
    res *= 10;
    res += xL%10;
    if (res > Integer.MAX_VALUE) {
      return 0;
    }
    //相当于十进制的右移
    xL /= 10;
  }
  return (int) (x > 0 ? res : -res);  
}