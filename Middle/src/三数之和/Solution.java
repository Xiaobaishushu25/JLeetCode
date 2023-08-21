package 三数之和;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Xbss
 * @version 1.0
 * @create 2022-04-12-10:47
 * @descirbe ：给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组
 * 链接：https://leetcode-cn.com/problems/3sum
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 */
public class Solution {
    public static void main(String[] args) {
        int[] a={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(a);
        System.out.println(lists);
    }
    //暴力求解的话是三重遍历，所以考虑用哈希表减少时间复杂度。先二重遍历，算出两个元素的和，然后看哈希表中是否有符合条件的值，这样就可以减少时间复杂度
    //然后要考虑的是去除重复解的问题，将三个元素放在数组中排序然后加入一个list中，再将这个list放入一个set集合中，自然的实现了去重的作用
    //这样，set中的list便是所有符合题意的结果集
    //自己写的，没看答案，性能很差
    //执行结果：通过
    //执行用时：759 ms
    //, 在所有 Java 提交中击败了5.02%的用户
    //内存消耗：46.3 MB
    // 在所有 Java 提交中击败了5.00%的用户
    //通过测试用例：
    //318 / 318
    public  static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len= nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i],i);
        }
        ArrayList<List<Integer>> lists = new ArrayList<>();
        HashSet<List> set = new HashSet<>();
        for (int i = 0; i < len&&nums[i]<0; i++) {
            for (int j = i+1; j < len; j++) {
                int sum=-(nums[i]+nums[j]);
                if (map.containsKey(sum)&&map.get(sum)!=i&&map.get(sum)!=j){
                    ArrayList<Integer> list = new ArrayList<>();
                    //下面操作是为了去重，用set
                    int[] b={nums[i],nums[j],sum};
                     Arrays.sort(b);
                    for (int k = 0; k < 3; k++) {
                        list.add(b[k]);
                    }
                    set.add(list);
                 }
            }
        }
        for (List l: set) {
            lists.add(l);
        }
     return lists;
    }

}
