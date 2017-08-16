/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

// This version has many fault
// public class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         ListNode result = new ListNode();
//         ListNode dummy = new ListNode();
//         dummy.next = result;
//         int sum;
//         int carry;
//         int mod;
//         while (l1 != null || l2 != null) {
//             int num1 = l1 == null? 0 : l1.val;
//             int num2 = l2 == null? 0 : l2.val;
//             sum = l1.val + l2.val + carry;
//             carry = sum / 10;
//             mod = sum % 10;
//             result.val = mod;
//             result = result.next;
//             l1 = l1 == null? null : l1.next;
//             l2 = l2 == null? null : l2.next;
//         }
//         if (carry != 0) result.next = new ListNode(carry);
//         return dummy.next;
//     }
// }

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        if(l1 == null && l2 == null){
            return dummyHead;
        }
        int sum = 0, carry = 0;
        ListNode curr = dummyHead;
        while(l1!=null || l2!=null){
            int num1 = l1 == null? 0 : l1.val;
            int num2 = l2 == null? 0 : l2.val;
            sum = num1 + num2 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}


// Wrote Myself
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
  ListNode dummy = new ListNode(0);
  if (l1 == null && l2 == null) return dummy;
  int sum = 0;
  int carry = 0;
  int mod = 0;
  ListNode cur = dummy;
  while (l1 != null || l2 != null) {
    int num1 = l1 == null? 0: l1.val;
    int num2 = l2 == null? 0: l2.val;
    sum = num1 + num2 + carry;
    carry = sum / 10;
    mod = sum % 10;
    cur.next = new ListNode(mod);
    cur = cur.next;
    l1 = l1 == null? null : l1.next;
    l2 = l2 == null? null : l2.next;
  }
  if (carry != 0) {
    cur.next = new ListNode(carry);
  }
  return dummy.next;
}
