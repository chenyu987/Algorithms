
// Version 1:
// 双队列法
// 复杂度
// 时间 O(N) 空间 O(N)

// 思路
// 和Implement Queue using Stack类似，我们也可以用两个队列来模拟栈的操作。当push时，我们将数字offer进非空的队列就行了。当pop时，因为要拿的是队列最后一个数
// 我们先将它前面的数offer进另一个队列，然后单独拿出最后一个数，并且不再offer进另一个队列，这样，另一个队列就少了最后一个数，而我们也拿到了最后一个数，而本来的队列就变成空了，等待下次的pop操作来填满。top操作和pop一样，区别在于我们拿到最后一个数后，还要再把它offer进另一个队列中。


public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int size;
    public MyStack() {
        this.queue1 = new LinkedList<Integer>();
        this.queue2 = new LinkedList<Integer>();
        this.size = 0;
    }
    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
        size++;
    }
    public int pop() {
        if (size == 0) {
            return -1;
        }
        int res = 0;
        if (queue1.isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                queue1.offer(queue2.poll());
            }
            res = queue2.poll();
        } else {
            for (int i = 0; i < size - 1; i++) {
                queue2.offer(queue1.poll());
            }
            res = queue1.poll();
        }
        size--;
        return result;
    }
    
    public int top() {
        if (size == 0) {
            return -1;
        }
        int top = pop();
        if (queue1.isEmpty()) {
            queue2.offer(top);
        } else {
            queue1.offer(top);
        }
        size++;
        return top;
    }
    public boolean empty() {
        return size == 0;
    }
    
}


