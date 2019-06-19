/**
 * created by zl on 2019/6/19 19:55
 */
public class medium_300_LongestIncreaseSeq
{
    public int lengthOfLIS(int[] nums)
    {//https://blog.csdn.net/lw_power/article/details/80758674
        int len = nums.length;
        // 先考虑极端输入
        if (len <= 1)
            return len;
        // tail 数组的定义：长度为 i+1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历一遍整个数组，使用二分查找算法
        tail[0] = nums[0];
        int res = 0;
        for (int i = 1; i < len; i++)
        {
            // 比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[res])
            {
                // 直接添加在那个元素的后面
                tail[++res] = nums[i];
            } else
            {
                // 二分查找到第 1 个比 nums[i] 还大的元素，更新到那个位置
                int l = 0;
                int r = res;
                while (l < r)
                {
                    int mid = l + (r - l) / 2;
                    // 有就啥都不做了
                    if (tail[mid] == nums[i])
                    {
                        l = mid;
                        break;
                    } else if (tail[mid] >= nums[i])
                    {
                        r = mid;
                    } else
                    {
                        l = mid + 1;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return ++res;
    }

    public static void main(String[] args) {
        medium_300_LongestIncreaseSeq longestIncreaseSeq = new medium_300_LongestIncreaseSeq();

        int[] nums = {10,9,2,5,3,7,101,18};
        longestIncreaseSeq.lengthOfLIS(nums);
    }
}
