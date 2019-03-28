import java.util.HashMap;

/**
 * created by zl on 2019/3/28 20:03
 */
public class simple_219_ContainsDuplicateII
{
    public boolean containsNearbyDuplicate(int[] nums, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            /*put返回value 或 null
            *如果key没有重复，put成功，则返回null，如p1、p2；

            如果key重复了，返回的是map.get(key)，也就是之前这个key对应的value，
            然后更新value

             */
            Integer lastIndex = map.put(nums[i], i);
            if (lastIndex != null && i - lastIndex <= k)
            {
                return true;
            }
        }
        return false;
    }
}
