import java.util.ArrayList;
import java.util.List;

/**
 * created by zl on 2019/3/30 10:11
 */
public class simple_438_FindAllAnagramsinaString
{

        public List<Integer> findAnagrams(String s, String p)
        {
            List<Integer> res = new ArrayList<>();
            int m=s.length();
            int n=p.length();
            if(m<n)
                return res;
            int[] map = new int[26];
            for(char ch: p.toCharArray())
                map[ch-'a']++;  //how many letters of each kind in the mode p

            int counter=n;
            int left=0, right=0;  //两个指针表示窗口的左端和右端
            char []ss = s.toCharArray();

            while(right<m)
            {
                System.out.println("map[ss[right]-'a']="+map[ss[right]-'a']+", ss[right]="+ss[right]+", right="+right);
                if(map[ss[right]-'a']-- >=1)  //there's a letter of mode
                    counter--;
                right++;  //每次都要向右移动一次, 如果对应字符出现次数大于等于1说明该字符在p中, 将counter减1
                if(counter==0)  // 如果counter减为0, 将左端点index加入返回值
                    res.add(left);
                System.out.println("right="+right+",count="+counter);
                if(right-left==n)
                {
                    //说明窗口大小超出限制, 需要left右移一位同时判断left对应字符是否在p中,并决定是否对counter加1
                    System.out.println("map[ss[left]-'a']="+map[ss[left]-'a']+", ss[left]="+ss[left]+", left="+left);
                    if(map[ss[left]-'a']++>=0)
                        counter++;
                    left++;
                }
            }
            return res;
        }

    public static void main(String[] args) {
        simple_438_FindAllAnagramsinaString findAllAnagramsinaString = new simple_438_FindAllAnagramsinaString();
        findAllAnagramsinaString.findAnagrams("cbaebabacd","abc");
    }

}
