


public ListNode plusOne(ListNode l1) {
    int carry = 1;
    int sum = 0;
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while(l1 != null) {
        sum = carry + l1.val;
        head.next = new ListNode(sum % 10);
        carry = sum/10;
        head = head.next;
        l1 = l1.next;
    }
    if (carry == 1) {
        head.next = new ListNode(1);
    }
    return dummy.next;
}