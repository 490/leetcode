import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * created by zl on 2019/3/28 20:45
 */
public class simple_225_ImplementStackusingQueues
{
    private Queue<Integer> queue = new LinkedList<Integer>();
    /** Initialize your data structure here. */


    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for(int i =0;i<queue.size()-1;i++){
            queue.add(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
