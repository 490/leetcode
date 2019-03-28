/**
 * created by zl on 2019/3/28 9:32
 */
public class simple_121_BestTimetoBuyandSellStock
{
    public int maxProfit(int[] prices)
    {

        int len = prices.length;
        if(prices==null||len==0)
            return 0;
        if(len == 1)
            return 0;
        int min = prices[0];
        int maxdiff = prices[1]-min;
        for(int i = 2;i <len;i++)
        {
            if(prices[i-1]<min)
                min = prices[i-1];
            if(maxdiff < prices[i]-min)
                maxdiff = prices[i]-min;

        }
        return maxdiff>0?maxdiff:0;
    }
}
