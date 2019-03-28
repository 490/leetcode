/**
 * created by zl on 2019/3/28 10:27
 */
public class simple_136_SingleNumber
{
    public int singleNumber(int[] nums)
    {
        if(nums==null||nums.length==0)
            return 0;
        int re = nums[0];
        for(int i = 1;i < nums.length;i++)
        {
            re = re ^ nums[i];
        }
        return re;
    }
}
