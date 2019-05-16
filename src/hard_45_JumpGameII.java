/**
 * created by zl on 2019/5/16 8:40
 */
public class hard_45_JumpGameII
{
    public int jump(int[] nums)
    {
        int res = 0, n = nums.length, last = 0, cur = 0;
        for (int i = 0; i < n - 1; ++i)
        {
            cur = Math.max(cur, i + nums[i]);
            //此时仅靠上一次的last已经够（i）不到这里了，需要再迈一步（res），
            //同时更新last，代表更新后不需要迈步就能够得到的范围
            if (i == last)
            {
                last = cur;
                ++res;
                if (cur >= n - 1)
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        hard_45_JumpGameII jumpGameII = new hard_45_JumpGameII();
        int[] s = {2,3,1,1,4};
        jumpGameII.jump(s);
    }
}
