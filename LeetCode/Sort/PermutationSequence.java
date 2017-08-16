
//Permutation sequence
n = 3:
123 (1 - 1)/2 = 0 ==> (1 - 1) / (3 - 2) = 0
132 (2 - 1)/2 = 0 
213 (3 - 1)/2 = 1
231
312
321

k = 3;

2/(3-1)! = 1; ->第二组 

213 
231

first digit is (K - 1)/(n-1)! = 2 -> already got first digit 
k -> k % 2! -> 0 -> to get first element   
－－> 0 element means 1 --> second digit is 1 -> already got second digit 
k % 2! == 2 --> mean 2 element which is 3rd element == 3 --> got third digit

0*100 + ? == 100?
1*100 + ? == 100?
  

  
for K == 1:
k==1: 1
k = 0 % 2 = 0;
  
//判断是第几个组
kth: (K - 1)/(n-1)!
firs: mod = n!
mod /= (n-i);
currnet digit -> (k-1) / (n-i)!
next k : (k-1) % (n-1)!



  