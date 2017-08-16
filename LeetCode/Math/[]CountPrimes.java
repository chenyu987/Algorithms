Description:

Count the number of prime numbers less than a non-negative number, n.


public class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
}


 204
Count Primes
 
質數有時亦為都叫素數，而英文就叫質數做prime number或者prime
 
composite 合数

prime : 2 -> prime/2;

public int countPrime(int n) {
  boolean[] notprime = new boolean[n];
  int count = 0;
  for (int i= 2; i < n / 2; i++) {
    for (int j = i; i*j < n; j++) {
      notprime[i*j] = true; 
    }
  }
  for (int i = 2; i < n; i++) {
    if (!notprime[i]) count++;
  }
  return count;
}
