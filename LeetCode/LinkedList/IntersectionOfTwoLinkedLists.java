题目：Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

解答：

public class Solution {
    //非常聪明的解法，因为两个linkedlist的长度不一样，所以它让两个指针通过两次循环，
    //来把两个linkedlist都扫一遍。因为公共的部分相同，所以当它们相遇的时候，就是intersection。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
    }
}

Method II
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodea = headA, nodeb = headB;
        int lena = 0, lenb = 0;
        // 计算链表A的长度
        while(nodea != null){
            lena++;
            nodea = nodea.next;
        }
        // 计算链表B的长度
        while(nodeb != null){
            lenb++;
            nodeb = nodeb.next;
        }
        // 让较长的链表先飞一会
        for(int i = 0; i < Math.abs(lena - lenb); i++){
            if(lenb > lena) headB = headB.next;
            else if(lena > lenb) headA = headA.next;
        }
        while(headA != null && headB != null){
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}