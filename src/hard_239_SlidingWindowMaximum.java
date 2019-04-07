/**
 * created by zl on 2019/4/7 16:09
 */
public class hard_239_SlidingWindowMaximum
{
    public int[] maxSlidingWindow(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length)
            return new int[]{};

        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = k - 1;
        // 先求出第一个窗口的最大值
        for (int i = start; i <= end; i++)
        {
            if (nums[i] > max)
            {
                max = nums[i];
            }
        }
        result[resultIndex++] = max;
        // 从第二个窗口开始
        while (++end < nums.length)
        {
            int oldMax = max;
            // 如果当前数字（当前窗口最右边的数）比之前窗口的最大值大，则当前窗口的最大值就是该数
            if (nums[end] > max)
            {
                max = nums[end];
            }
            int oldStart = start;
            start += 1;
            // 如果当前数没有比之前的窗口的最大值大，并且之前窗口的最大值就是窗口最左边的数，
            // 则之前的最大值被新的窗口丢弃，需要找出新的窗口的最大值
            if (oldMax == max && nums[oldStart] == max)
            {
                // 先把当前窗口最左边的数当成最大值，遍历该窗口，找出最大值
                max = nums[start];
                for (int i = start; i <= end; i++)
                {
                    if (nums[i] > max)
                    {
                        max = nums[i];
                    }
                }
            }
            result[resultIndex++] = max;
        }

        return result;
    }
}
