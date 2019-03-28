/**
 * created by zl on 2019/3/28 14:53
 * 数有几个5,1*5.。。。5*5.。。10*5
 * 5*5这种就需要再n/=5再数一次
*/


 public class simple_172_FactorialTrailingZeroes
{
    public int trailingZeroes(int n)
    {
        int count = 0;
        while(n>0)
        {
            count += (n/5);
            n/=5;
        }

        return count;
    }
}
