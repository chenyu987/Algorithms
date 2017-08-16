/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
//  3->4->5->2->7->null 
 
public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode ptr1 = head;
    ListNode ptr2 = head.next;
    
    while (ptr2 != null) {
      ListNode ptr2Next = ptr2.next;
      ptr2.next = ptr1;
      ptr1 = ptr2;
      ptr2 = ptr2Next;
    }
    head.next = null;
    return ptr1;
  }
}

// from jiuzhang
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
