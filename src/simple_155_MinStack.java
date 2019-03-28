import java.util.Stack;

/**
 * created by zl on 2019/3/28 10:44
 *
 * 只用一个stack实现，，其余算法都是要辅助栈
 */
public class simple_155_MinStack
{
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack ;
    public simple_155_MinStack()
    {
        stack = new Stack<Integer>();
    }
    public void push(int x)
    {
        // only push the old minimum value when the current
        // minimum value changes after pushing the new value x
        if(x <= min)
        {
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop()
    {
        // if pop operation could result in the changing of the current minimum value,
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min)
            min=stack.pop();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return min;
    }
}
