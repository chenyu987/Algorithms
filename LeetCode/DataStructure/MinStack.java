// Min Stack
// Design a stack that supports push, pop, top, and retrieving theminimum element in constant time.

// push(x) -- Push element x onto stack. 
// pop() -- Removes the element on
// top of the stack. top() -- Get the top element. getMin() -- Retrieve
// the minimum element in the stack.
// 双栈法
// 复杂度
// 时间 O(N) 空间 O(1)

// 思路
// 暴力的方法是遍历一遍栈得出最小值，这样不用任何空间。但如果我们能使用空间来记录到目前为之最小的数呢？我们只要记录一个最小数的顺序，和栈的操作顺序对应起来就可以在任何时候做到O(1)获取最小值了。因为这个最小值的顺序也是先进后出，我们同样用一个栈来记录。这样主栈在push时，如果该值小于等于副栈顶，就也push进副栈中。当主栈pop时，如果pop出的元素是副栈栈顶的话，副栈也要pop。

// 注意
// 判断是否加入副栈时，等于的情况也要加入，因为可能有多个重复的最小值，我们也需要多次抛出这些重复的最小值
// 当栈为空时，peek会抛出异常，这里要和面试官沟通好如何处理栈为空的情况
// 代码

class MinStack {
    
    Stack<Integer> stk = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        stk.push(x);
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        int x = stk.pop();
        if(!min.isEmpty() && min.peek() == x){
            min.pop();
        }
    }

    public int top() {
        if(!stk.isEmpty()){
            return stk.peek();
        } else {
            return 0;
        }
    }

    public int getMin() {
        if(!min.isEmpty()){
           return min.peek();
        } else {
            return 0;
        }
    }
}