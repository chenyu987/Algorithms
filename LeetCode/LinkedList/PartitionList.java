/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. You should preserve the original relative order of the nodes in each of the two partitions. For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 
// Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;

        // 1 -> 2 -> 2
        // 4 -> 3 -> 5
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }
}


// Space O(1)
/*
Partition List

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x. You should preserve the original relative order of the nodes in each of the two partitions. For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
 
// Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
       s               f 
       3 -> 5 -> 0     7
                f.n   next 
                 0 -> 5
              3->0
                      
   dummy -> 1 ->  4 ->  3 ->  2 -> 5  -> 2
            s                      
                        f
                                  next
                              2 -> 4
                         1 -> 2    
                                        3-> 5
                                       f                              
           s 
           
  dummy -> 1 ->  2 ->  4 ->  3  -> 5  -> 2
  
public ListNode partitionList(ListNode head, int x) {
  if (head == null || head.next == null) return head;
  ListNode dummy = new ListNode(0);
  dummy.next = head;
  ListNode slow = dummy;
  ListNode fast = dummy;
  while (fast.next != null) {
    if (fast.next.val < x) {
      if (fast != slow) {
        ListNode next = fast.next.next;
        fast.next.next = slow.next;
        slow.next = fast.next;
        fast.next = next;
      } else {
        fast = fast.next;  
      }
      slow = slow.next;
    } else {
      fast = fast.next;
    }
  }
  return dummy.next;
}


