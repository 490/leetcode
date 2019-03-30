/**
 * created by zl on 2019/3/28 21:18
 */
public class simple_231_PowerofTwo
{public boolean isPowerOfTwo(int n)
{
    if(n<=0)
        return false;
    return (n & (n-1)) == 0?true:false;
}
}
