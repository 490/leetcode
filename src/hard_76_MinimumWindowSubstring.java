/**
 * created by zl on 2019/4/4 17:48
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class hard_76_MinimumWindowSubstring
{
    public String minWindow(String S, String T)
    {
        int[] srcHash = new int[255];
        // 记录目标字符串每个字母出现次数
        for(int i = 0; i < T.length(); i++)
        {
            srcHash[T.charAt(i)]++;
        }
        int start = 0,i= 0;
        // 用于记录窗口内每个字母出现次数
        int[] destHash = new int[255];
        int found = 0;
        int begin = -1, end = S.length(), minLength = S.length();
        for(start = i = 0; i < S.length(); i++)
        {
            // 每来一个字符给它的出现次数加1
            destHash[S.charAt(i)]++;
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)])
                found++;
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if(found == T.length())
            {
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while(start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)])
                {
                    destHash[S.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if(i - start < minLength)
                {
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[S.charAt(start)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;
            }
        }
        // 如果begin没有修改过，返回空
        return begin == -1 ? "" : S.substring(begin,end + 1);
    }
}
