import java.util.Arrays;

/**
 * created by zl on 2019/4/10 10:18
 */
public class medium_322_CoinChange
{
    int total;
    public int coinChange(int[] coins, int amount)
    {
        total = Integer.MAX_VALUE;
        if(amount == 0)
            return 0;
        Arrays.sort(coins);
        count(amount, coins.length-1, coins, 0);
        return total == Integer.MAX_VALUE?-1:total;
    }
    void count(int amount, int index, int[] coins, int count)
    {
        if(index < 0 || count >= total -1)
            return;
        int c = amount/coins[index];
        for(int i = c; i >=0; i--)
        {
            int newCount = count + i;//已经使用的硬币数
            int rem = amount - i*coins[index];//使用了这几个后，还剩多少钱没算
            if(rem > 0 && newCount<total)
                count(rem, index - 1, coins, newCount);
            else if(newCount<total)
                total = newCount;//记录全局最小使用硬币数量
            else if(newCount>=total-1)
                break;
        }

    }
}
/*class Solution {
    public int coinChange(int[] coins, int amount)
    {

        int[] dp = new int[amount+1];
        for(int i=0;i<dp.length;i++)
        {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int coin : coins)
        {
            for (int i = coin; i <= amount; ++i)
          if (dp[i - coin] != Integer.MAX_VALUE)  //
            {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

}*/