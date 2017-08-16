
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7



public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null || l2 != null) {
            // sum = l1 == null? 0: l1.val + l2 == null? 0: l2.val + carry;
            int num1 = l1 == null? 0: l1.val;
            int num2 = l2 == null? 0: l2.val;
            sum = num1 + num2 + carry;
            head.next = new ListNode(sum % 10);
            carry = sum / 10;
            head = head.next;
            l1 = l1 == null? l1: l1.next;
            l2 = l2 == null? l2: l2.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return reverse(dummy.next);
    }

    
    private ListNode reverse(ListNode l1) {
        ListNode prev = null;
        ListNode cur = l1;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}