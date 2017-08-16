143 Reorder List
           fast
 1 - 2 - 3 -4 -5 -6
    slow
  
               fast
 1 - 2 - 3 - 4
       slow


 1- 6- 2- 5 - 3 -4

Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example, Given {1,2,3,4}, reorder it to {1,4,2,3}


public ListNode reorderList(ListNode head) {
  if (root == null) return root;
  ListNode slow = head;
  ListNode fast = head.next;
  while (fast != null && fast.next !=null) {
    fast = fast.next.next;
    slow = slow.next;
  }
  ListNode head2 = reverse(slow.next);
  //if stops at 3
  slow.next = null;
  ListNode cur = new ListNode(0);
  ListNode dummy = cur;
  while (head != null && head2 != null) {
   cur.next = head;
   head = head.next;
   cur = cur.next;
   cur.next = head2;
   head2 = head2.next;
   cur = cur.next;
  }
  if (head != null) cur.next = head;
  if (head2 != null) cur.next = head2;
  return dummy.next;
}

null <- 1   2 -> 3 -> 4 -> null
      prev head

   null <- 1
prev    

private reverseList(ListNode head) {
  if (head == null || head.next == null) return head;
  ListNode prev = null;
  while (head != null) {
    ListNode tmp = head.next;
    head.next = prev;
    prev = head;
    head = tmp;
  }
  return prev;
}