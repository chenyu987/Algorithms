public class Solution {
    int size;
    int capacity;
    ListNode tail;
    ListNode head;
    Map<Integer, ListNode> map = new Map<Integer, ListNode>();
    public LRUCache(int capacity){
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
        this.capacity = capacity;
        this.map = new HashMap<Integer, ListNode>();
    }

    public int get(int key) {
        ListNode n = map.get(key);
        if (n !=null) {
            moveToHead(n);
            return n.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        ListNode n = map.get(key);
        if (n != null) {
            n.val = value;
            moveToHead(n);
        } else {
            n = new ListNode(value, key);
            attachToHead(n);
            size++;
        }
        if (size > capacity) {
            removeLast();
            size--;
        }
//        will this overlap the last value in hashmap?
        map.put(key, n);

    }
    private void attachToHead(ListNode n) {
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
    }

    private void moveToHead(ListNode n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        attachToHead(n);
    }
    private void removeLast() {
        ListNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }
    public class ListNode {
        ListNode prev;
        ListNode next;
        int val;
        int key;
        public ListNode(int v, int k) {
            this.val = v;
            this.prev = null;
            this.next = null;
            this.key = k;
        }
    }

}