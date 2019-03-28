import java.util.HashSet;
import java.util.Set;

/**
 * created by zl on 2019/3/28 16:57
 *
 * 重点；用set记录重复
 */
public class simple_202_HappyNumber
{
    public boolean isHappy(int n)
    {
        Set<Integer> set = new HashSet<Integer>();
        int sum,remain;
        while(set.add(n))
        {
            sum=0;
            while(n>0)
            {
                remain = n%10;
                sum += remain*remain;
                n /= 10;
            }
            if(sum==1)
                return true;
            else
                n=sum;
        }
        return false;

    }
}
