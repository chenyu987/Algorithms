/**
* Sort a linked list using insertion sort.
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
时间 O(n^2) 空间O(1)
思路：插入排序 
做一个空链表，然后不断加入原链表中的最小元素即可。
cur是原链表head的指针，不断向后扫描；node是空链表dummy的指针，用node.next与cur所指向的结点进行比较，
一旦发现排列好的新链表中有大于cur的结点，就把cur放在node.next，然后进行下一轮循环：cur.next作为原链表新的cur，node返回新链表起点dummy
最后，当cur = null，即遍历完整个原链表之后，新链表排序完成。返回dummy.next即可。
*/ 
 
public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
		ListNode cur = head;
		while (cur != null) {
			ListNode node = dummy;
			while (node.next != null && node.next.val <= cur.val) {
				node = node.next;
			}
			ListNode tmp = cur.next;
			cur.next = node.next;
			node.next = cur;
			cur = tmp;
		}
		return dummy.next;
  }
} 