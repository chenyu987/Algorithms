Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

public ListNode removeLinkedListElement(ListNode head, int val) {
  ListNode dummy = new ListNode(0);
  dummy.next = head;
  head = dummy;
  while (head.next != null) {
    if (head.next.val == val) {
      head.next = head.next.next;
    }
    head = head.next;
  }
  return dummy.next;
}

