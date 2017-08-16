// Merge two sorted list and return it as a new list

// use a dummy node to start

public class Solution {
    public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
            // this part is else if because they may symotanously be null
        } else if (l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}