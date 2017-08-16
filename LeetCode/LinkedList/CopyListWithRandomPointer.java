
// Copy List with Random Pointer
// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.


    cur      : label = 4;
  /      \ 
 next    random: null
 /        \  
cur_1     
public RandomListNode copyRand(RandomListNode head) {
  if (head == null) return head;
  RandomListNode cur = head;
  
  while (cur != null) {
    RandomListNode newNode = new RandomListNode(cur.label);
    newNode.next = cur.next;
    cur.next = newNode;
    cur = newNode.next;
  }
  
  cur = head;
  while (cur != null && cur.next != null) {
    if (cur.random != null) {
        // important and easy to make mistake
      cur.next.random = cur.random.next;
    }
    cur = cur.next.next;
  }
  
  cur = head;
  RandomListNode newHead = cur.next;
  while (cur != null) {
    RandomListNode newNode = cur.next;
    cur.next = newNode.next;
    if (newNode.next != null) {
      newNode.next = newNode.next.next;
    }
    cur = cur.next;
  }
  return newHead;
}

   

   1  ->    2  ->     3   ->     4    
   \        \          \          \
    3        1         1           2


1.
1-> 1 ->2 ->2 3 3 4 4 
\   \       \    
 3  null     null


2.
1-> 1 ->2 ->2 3 3 4 4 
\   \   \   \    
 3  3    1   1

3.

   1  ->    2  ->     3   ->     4    
   \        \          \          \
    3        1         1           2

   1  ->    2  ->     3   ->     4    
   \        \          \          \
    3        1         1           2

