/**
 * created by zl on 2019/3/28 9:55
 */
public class simple_122_BestTimetoBuyandSellStockII
{
    public int maxProfit(int[] prices)
    {

        int r=0;
        for(int i =0;i<prices.length-1;i++)
        {
            if(prices[i]<prices[i+1])
                r += prices[i+1]-prices[i];
        }
        return r;
    }
}
