// Linked List Cycle I
// Given a linked list, determine if it has a cycle in it.

// Follow up: Can you solve it without using extra space?
// 快慢指针法
// 复杂度
// 时间 O(N) 空间 O(1)

// 思路
// 这是一道非常经典的双指针题。我们从头设置一个快指针，一个慢指针。快指针一次走两步，慢指针一次走一步，如果快指针走到了尽头，则说明链表无环。如果快指针和慢指针相遇，则说明链表有环。为什么相遇就说明有环呢？设想一个有环链表，快慢指针最后都会走到环上，而这个环就像一个环形跑道一样，慢指针在后面，快指针在前面，但实际上快指针也在追慢指针，希望能超慢指针一圈。他们在这个跑道上，总会有一天快指针追上了慢指针。我们不用担心快指针跳过了慢指针，因为他们两的速度差是1，所以她们俩在环上的距离总是每次减1，最后总能减到0。

// 代码
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}