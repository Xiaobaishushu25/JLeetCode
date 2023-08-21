package 字形变换;

/**
 * @author Xbss
 * @version 1.0
 * @create 2022-03-21-22:34
 * @descirbe ：将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。
 *             比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：
 *             P   A   H   N
 *             A P L S I I G
 *             Y   I   R
 *             之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class Solution {
    public static void main(String[] args) {
        String s=new String("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers."
        );
//           convert(s,2);
//        Answer(s,2);
        Update(s,2);
    }

    //到最后又是超时了:思路是创建一个二维数组然后按规律遍历填入字符，最后在遍历数组得到答案
    //优化思路：遍历二维数组浪费大量时间而且有很多空间没有用到，最后是按行遍历所以不妨一行设为一个数组，用 StringBuilder存放
    public static String convert(String s, int numRows) {
        int index=0;
        if (numRows==1){
            return s;
        }
         char[][] a=new char[numRows][s.length()];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j]='0';
            }
            System.out.println();
        }
        // 从列开始
             for (int j = 0; j <s.length(); j++) {
                 //如果列数除以numRows - 1刚好除尽的话，就是这一列全部填充
                     if (j % (numRows - 1) == 0) {
                             for (int i = 0; i < numRows; i++) {
                                 if (index<s.length()) {
                                     a[i][j] = s.charAt(index++);
                                 }
                             }
                     } else {
                         //除不尽就是两个整列的中间的，按规律填充
                         int x = j % (numRows - 1);
                         if (index<s.length()) {
                             a[numRows - 1 - x][j] = s.charAt(index++);
                         }
                     }
                 }
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
                if (a[i][j]!='0'){
                     builder.append(a[i][j]);
                 }
            }
            System.out.println();
        }
        System.out.println(builder);
        return builder.toString();
    }
    /**
     * @Author Xiaobaishushu
     * @Description ：执行用时：4 ms, 在所有 Java 提交中击败了82.08%的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了61.50%的用户
     * 通过测试用例：1157 / 1157
     * @Date 2022/3/22 10:56
     * @Param [s, numRows]
     * @return java.lang.String
     **/
    //根据别人的StringBuilder启发把二维数组换成了StringBuilder数组，果然快多了。
    public static String Update(String s,int numRows){
        int len = s.length();
        if (len == 0 || numRows < 1) {
            return "";
        }
        if (numRows==1){
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            res[i]=new StringBuilder();
        }
        int j=0;
        int index=0;
        for ( j = 0; j <s.length(); j++) {
            int m=j % (numRows - 1);
            //如果列数除以numRows - 1刚好除尽的话，就是这一列全部填充
            if (m == 0) {
                for (int i = 0; i < numRows; i++) {
                    if (index<s.length()) {
                        res[i].append(s.charAt(index++)) ;
                    }
                }
            } else {
                //除不尽就是两个整列的中间的，按规律填充
                if (index<s.length()) {
                    res[numRows-1-m].append(s.charAt(index++));
                }
            }
        }
        StringBuilder builder = new StringBuilder(s.length());
        for (int i = 0; i < numRows; i++) {
            builder.append(res[i]);
        }
//        System.out.println(builder);
        return builder.toString();
    }
    /**
     * @Author Xiaobaishushu
     * @Description ：执行用时：4 ms, 在所有 Java 提交中击败了82.08%的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了61.40%的用户
     * 通过测试用例：1157 / 1157
     * @Date 2022/3/22 10:56
     * @Param [s, numRows]
     * @return java.lang.String
     **/
    //看的别人的答案用的是StringBuilder，没用二维数组
    public static String Answer(String s, int numRows) {
        int len = s.length();
        if (len == 0 || numRows < 1) {
            return "";
        }
        if (numRows==1){
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < numRows; ++i) {
            res[i] = new StringBuilder();
        }
        int ans;
        int remain;
        for (int i = 0; i < len; ++i) {
            ans = i / (numRows-1);
            remain = i % (numRows-1);
            if (ans % 2 == 0) {
                res[remain].append(s.charAt(i));
            } else {
                res[numRows-remain-1].append(s.charAt(i));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; ++i) {
            stringBuilder.append(res[i].toString());
        }
        return stringBuilder.toString();
    }
}
