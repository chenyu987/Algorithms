Add Two Numbers
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
递归写法 Recursive
复杂度
时间O(n) 空间(n) 递归栈空间

思路
本题的思路很简单，按照小学数学中学习的加法原理从末尾到首位，对每一位对齐相加即可。技巧在于如何处理不同长度的数字，以及进位和最高位的判断。这里对于不同长度的数字，我们通过将较短的数字补0来保证每一位都能相加。递归写法的思路比较直接，即判断该轮递归中两个ListNode是否为null。

全部为null时，返回进位值
有一个为null时，返回不为null的那个ListNode和进位相加的值
都不为null时，返回 两个ListNode和进位相加的值
代码
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }

    public ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1==null && l2==null){
            return carry == 0? null : new ListNode(carry);
        }
        if(l1==null && l2!=null){
            l1 = new ListNode(0);
        }
        if(l2==null && l1!=null){
            l2 = new ListNode(0);
        }
        int sum = l1.val + l2.val + carry;
        ListNode curr = new ListNode(sum % 10);
        curr.next = helper(l1.next, l2.next, sum / 10);
        return curr;
    }
}
迭代写法 Iterative
复杂度
时间O(n) 空间(1)

思路
迭代写法相比之下更为晦涩，因为需要处理的分支较多，边界条件的组合比较复杂。过程同样是对齐相加，不足位补0。迭代终止条件是两个ListNode都为null。

注意
迭代方法操作链表的时候要记得手动更新链表的指针到next
迭代方法操作链表时可以使用一个dummy的头指针简化操作
不可以在其中一个链表结束后直接将另一个链表串接至结果中，因为可能产生连锁进位
代码
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
后续 Follow Up
Q：如果将数字从链表改为由数组表示的话如何解决？ A：迭代写法仍然可以用于数组，具体请参见大整数相加的专题文章。

Q：如果这是一个类的话该如何实现？ A：将链表或者数组作为成员变量(member variable)，提供对其操作的各种方法(method)。