/*
Implement int sqrt(int x).

Compute and return the square root of x.
*/

public int sqrt(int x) {
  // if wrote if (mid<= x/mid) then it can be int start int end
  long start = 1;
  long end = x / 2;
  while (start + 1 < end) {
    int mid = start + (end - start) / 2;
    // if you wrote ( if (mid*mid <=x ) then it may cause overflow
    // this method will prevent overflow
    if (mid <= x/mid) {
      end = mid;
    }
    else {
      // this part will cause overflow referring to top
      start = mid;
    }
  }
  if (end <= x/end) {
    return (int) end;
  }
  return int(start);
  }
}
