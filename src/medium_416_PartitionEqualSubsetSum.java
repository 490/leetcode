/**
 * created by zl on 2019/4/11 19:25
 */
public class medium_416_PartitionEqualSubsetSum
{
    public boolean canPartition(int[] nums)
    {
        if(nums == null || nums.length == 0)
            return false;
        int sum = 0;
        for(int num : nums)
        {
            sum += num;
        }
        if(sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i = 0; i < nums.length; i++)
        {
            for(int j = sum; j >= nums[i]; j--)
            {
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        medium_416_PartitionEqualSubsetSum medium_416_partitionEqualSubsetSum = new medium_416_PartitionEqualSubsetSum();
        medium_416_partitionEqualSubsetSum.canPartition(new int[]{1,5,11,5});
    }
}
