/**
 * created by zl on 2019/3/28 16:14
 */
public class simple_191_Numberof1Bits
{
    public int hammingWeight(int n)
    {
        int count  = 1;
        int re = 0;
        while(n!=0)
        {
            if((n & count) >0)
            {
                re ++;
            }
            n = n >>> 1;

        }
        return re;
    }
}
