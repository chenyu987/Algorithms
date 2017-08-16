  
<------->O
<-------> length: a 
 
length of list: L
distance between entry of circle and meeting point: x

a + x = (n-m)*r 
a + x = (n-1)*r + r = (n-1)*r + L - a 
-> a = L - a - x  
  
public ListNode hasCircleII (ListNode head) {
  if (head == null || head.next == null) return false;
  ListNode slow = head;
  ListNode fast = head;
  while (fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;
    if (fast == slow) {
      break;  
    }
  }
  if (fast == null || fast.next == null) return null;
  slow = head;
  while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
  }
  return fast;
}



142 Linked List Cycle II


                     7
                    / \
                   8   6
                    \ /
1 -> 2 -> 3 -> 4 ->  5


1 -> 5: m

5 -> reunion: k

5 -> 5: n

slow step: m + k

fast step: m + xn + k

slow -> 5: n - k

m + xn + k + n - k = m + (x+1)n



n - k + xn == m 

(x+1)*n == m + k


provement:

2*(m + k) = m + k + n*T  
=>  m + k = n*T
=>  m + k = 


public ListNode circleII(ListNode head) {
  if (head == null || head.next == null) return false;
  ListNode slow = head;
  ListNode fast = head;
  while (fast != null && fast.next != null) {
    fast = fast.next.next;
    slow = slow.next;
    if (fast == slow) break;
  }
  slow = head;
  while (slow != fast) {
    slow = slow.next;
    fast = fast.next;
  }
  return slow;
}