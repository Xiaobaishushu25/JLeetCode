package 最长回文子串;

/**
 * @author Xbss
 * @version 1.0
 * @create 2022-03-20-21:22
 * @descirbe ：给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 */
public class Solution {
    public static void main(String[] args) {
        String s="suinoposd";
//        System.out.println(longestPalindrome(s));
        System.out.println(Answer(s));
//        System.out.println(Judge(s));
    }
    public static  String longestPalindrome(String s) {
        int max=1;
        String maxsub=new String();
        if (s.length()==1){
            return s;
        }
        for (int i = 0; i < s.length(); i++) {
            //本来纯暴力求解是超时的，这里的求字串优化了一下，本来是int j = i+1，把所有字串遍历，现在只遍历i+max的，能ac。
            for (int j = i+max; j < s.length()+1; j++) {
                String x=s.substring(i,j);
               if(Judge(x)){
                  if (x.length()>max){
                      max=x.length();
                      maxsub=x;
                  }
              }
            }
        }
        if (!(maxsub.length()>0)){
            return String.valueOf(s.charAt(0));
        }
        System.out.println("最长值为"+max);
        return maxsub;
    }
    //判断是否是回文串
    public static boolean Judge(String s){
        int low=0;
        int high=s.length()-1;
        while(low<high){
             if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    //动态规划：用空间换时间，递推，二维数组
    public  static String Answer(String s){
        if (s.length()==1){
            return s;
        }
        int max=0;
        String maxsub=new String();
        boolean[][] b=new boolean[s.length()][s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            b[i][i]=true;
//        }
        for (int j = 1; j< s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(j)!=s.charAt(i)){
                    b[i][j]=false;
                }else {
                    if (j-i<2){
                        b[i][j]=true;
                    }else {
                        b[i][j]=b[i+1][j-1];
                    }
                }
                if (b[i][j]&&j-i+1>max){
                    max=j-i+1;
                    maxsub=s.substring(i,j+1);
//                    System.out.println("j+1"+j+1);
                }
            }
        }
        return maxsub;
    }
}
