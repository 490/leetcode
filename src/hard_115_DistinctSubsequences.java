/**
 * created by zl on 2019/6/21 9:28
 */
public class hard_115_DistinctSubsequences
{
    public int numDistinct(String s, String t)
    {
        // dp[0]表示空串
        int[] dp = new int[t.length() + 1];
        // dp[0]永远是1，因为不管S多长，都只能找到一个空串，与T相等
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = t.length() - 1; j >= 0; j--)
            {
                if (t.charAt(j) == s.charAt(i))
                {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
    public static void main(String[] args) {
        hard_115_DistinctSubsequences distinctSubsequences = new hard_115_DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct("babgbag","bag"));;
    }

}
