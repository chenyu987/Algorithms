// rotate list 

public ListNode rotateList(ListNode head, int k) {
  if (head == null) {
    return head;  
  }
  ListNode fast = head;
  ListNode slow = head;
  
  int idx = 0;
  while (fast != null && idx < k) {
    idx++;
    fast = fast.next;
  }
  
  if (fast == null) {
    k %= idx;
    fast = head;
    idx = 0;
    while (fast != null && idx < k) {
      fast = fast.next;
      idx++;
    }
  }
  
  while (fast.next != null) {
    slow = slow.next;
    fast = fast.next;
  }
  ListNode newHead = slow.next;
  slow.next = null;
  fast.next = head;
  return newHead;