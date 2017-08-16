从有序链表中删除重复的数字，并且返回删除后的头结点例如输入链表为1->1->2,返回1->2


public class RemoveDuplicatesfromSortedList {
     public ListNode deleteDuplicates(ListNode head) {
         if(head==null){
             return head;
         }
         ListNode result = new ListNode(-1);
         result.next = head;
         while(head.next!=null){
             if(head.next.val==head.val){
                 head.next = head.next.next;
             }else{
                 head = head.next;
             }
             
         }
         return result.next;
     }
     
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}