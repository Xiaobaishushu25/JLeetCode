package 电话号码的字母组合;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Xbss
 * @version 1.0
 * @create 2022-04-16-20:49
 * @descirbe ：给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *            给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *            输入：digits = "23"
 *            输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class Solution {
    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        System.out.println(list);
    }
    /**
     * @Author Xiaobaishushu
     * @Description :执行结果：
     * 通过
     * 执行用时：0 ms,在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了25.33%的用户
     * 通过测试用例：
     * 25 / 25
     * @Date 2022/4/17 12:45
     * @Param [digits]
     * @return java.util.List<java.lang.String>
     **/
    public static List<String> letterCombinations(String digits) {
        int len=digits.length();
        if (len==0){
            return new ArrayList<>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < map.get(digits.charAt(i)).length(); j++) {
//                StringBuffer buffer = new StringBuffer();
//                buffer.append(map.get(digits.charAt(j)));
//            }
//            for (int j = i+1; j < len; j++) {
//
//            }
//        }
        ArrayList<String> list = new ArrayList<>();
        back(list,0,new StringBuilder(),digits,map);
        return list;
    }
    //回溯，类似树的深度递归
    public static void back(List<String> list,int index,StringBuilder builder,String dig,HashMap<Character,String> map){
        //当builder长度等于dig长度，则这条路已经走到最深处，已经可以返回了
        if (index==dig.length()){
            list.add(builder.toString());
            return ;
        }else {
            for (int j = 0; j < map.get(dig.charAt(index)).length(); j++) {
                builder.append(map.get(dig.charAt(index)).charAt(j));
                //向深处遍历
                back(list,index+1, builder,dig,map);
                //一条路走到底后，回退一步
                builder.deleteCharAt(builder.length()-1);
            }
        }
    }
}
