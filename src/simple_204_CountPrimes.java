/**
 * created by zl on 2019/3/28 19:05
 *
 * 厄拉多塞筛法
 */
public class simple_204_CountPrimes
{
    public int countPrimes(int n)
    {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++)
        {
            if (notPrime[i] == false)
            {
                count++;
                for (int j = 2; i*j < n; j++)
                {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}
