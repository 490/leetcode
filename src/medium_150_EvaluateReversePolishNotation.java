import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * created by zl on 2019/5/17 15:53
 */
public class medium_150_EvaluateReversePolishNotation
{
    public int evalRPN(String[] tokens)
    {
        if(tokens==null || tokens.length==0)
        {
            return 0;
        }
        Set<String> set=new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        Stack<Integer> stack=new Stack<>();
        for(String item: tokens)
        {
            if(set.contains(item))
            {
                int a=stack.pop();
                int b=stack.pop();
                stack.push(cal(item,b,a));
            }else
            {
                stack.push(Integer.parseInt(item));
            }
        }
        return stack.pop();
    }

    private int cal(String sig,int a,int b)
    {
        switch(sig)
        {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return 0;
    }
}
