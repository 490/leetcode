import java.util.ArrayList;
import java.util.List;

/**
 * created by zl on 2019/4/11 14:59
 */
public class medium_131_PalindromePartitioning
{
    public List<List<String>> partition(String s)
    {
        List<List<String>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(),s,0);
        return list;
    }
    private void backtrack(List<List<String>> list, List<String> tempList, String s, int start)
    {
        if(start == s.length())
        {
            list.add(new ArrayList<>(tempList));
        }
        else
        {
            for(int i = start;i < s.length();i++)
            {
                if(isPalindrome(s,start,i))
                {
                    tempList.add(s.substring(start,i+1));
                    backtrack(list,tempList,s,i+1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
    }
    private boolean isPalindrome(String s,int lo,int hi)
    {
        while(lo < hi)
        {
            if(s.charAt(lo++) != s.charAt(hi--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        medium_131_PalindromePartitioning medium_131_palindromePartitioning = new medium_131_PalindromePartitioning();
        medium_131_palindromePartitioning.partition("aab");
    }
}
