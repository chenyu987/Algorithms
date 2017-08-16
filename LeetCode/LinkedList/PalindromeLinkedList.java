/**
* Given a singly linked list, determine if it is a palindrome.
* 
* Follow up:
* Could you do it in O(n) time and O(1) space?
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
复杂度
时间：O(O) 空间：O(1)

思路：
1. 找链表中点
2. 从中点之后翻转列表
3. 双指针一个指向头,另一个指向中点下一个,顺序对比.如果都一样,则原链表是回文列表
*/ 

 1 2 3 4 3 2 1 
  
       p1 
 1 2 3 4 1 2 3 
              p2
              
      s     f
1 2 3 4 4 3 2 1
// important: 中点下标是len/2 - 1

public class PalindromeLinkedList {
  public boolean isPalindrome(ListNode head) {
    if (head == null) return true;
    ListNode mid = findMiddle(head);
    mid.next = reverse(mid.next);
    ListNode ptr1 = head;
    ListNode ptr2 = mid.next;
    while (ptr1 != null && ptr2 != null) {
      if (ptr1.val != ptr2.val) return false;
      ptr1 = ptr1.next;
      ptr2 = ptr2.next;
    }
    return true;    
  }

  
//   如果让slow停在4， 那么这么写
// 如果让slow停在3， 那么这样初始：
 //  slow     fast
 // dummy ->  head -> .... -> null
  private ListNode findMiddle(ListNode head) {
    if (head == null) return null;
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
  
null <- 1 <- 2 <- 3   

1 2 3 

  private ListNode reverse(ListNode head) {
    ListNode prev = null;
    while (head != null) {
      ListNode tmp = head.next;
      head.next = prev;
      prev = head;
      head = tmp;
    }
    return prev;
  }
}




// previous
234
Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Follow up: Could you do it in O(n) time and O(1) space?

1-> 2 -> 3 -> 4 -> 3 -> 2-> 1

1-> 2 -> 3 -> 4-> null     null <- 3 <- 2 <- 1

public boolean palindromeLinkedList(ListNode head) {
  if (head == null) return false;
  ListNode fast = head;
  ListNode slow = head;
  while (fast.next != null && fast.next.next != null) {
    fast = fast.next.next;
    slow = slow.next;
  }
  ListNode head2 = slow.next;
  ListNode prev = null;
  while (head2 != null) {
    ListNode tmp = head2.next;
    head2.next = prev;
    prev = head2;
    head2 = tmp;
  }
  
  while (head != null && prev != null) {
    if (prev.val != head.val) {
      return false;
    }
    head = head.next;
    prev = prev.next;
  }
  return true;
}
