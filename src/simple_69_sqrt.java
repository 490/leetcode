/**
 * created by zl on 2019/3/28 13:13
 */
public class simple_69_sqrt
{
    public int mySqrt(int x)
    {
        int left = 1, right = x;
        while (left <= right)
        {
            int mid = (right + left) / 2;
            if (mid == x / mid)
            {
                return mid;
            }
            else if (mid < x / mid)
            {
                left = mid + 1;
            } else
            {
                right = mid - 1;
            }
        }
        return right;
    }
}
