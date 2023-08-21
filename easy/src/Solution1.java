/**
 * @author Xbss
 * @version 1.0
 * @create 2022-02-04-16:43
 * @descirbe
 */

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个整数数组 nums和一个整数目标值target，请你在该数组中找出 和为目标值 target 的两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
*/
public class Solution1 {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        
       int[] arr={2,7,11,15};
        int[] arr2 = Solution1.twoSum(arr, 9);
        for (int a:arr2
             ) {
            System.out.println(a);
        }
    }
   // 法一：暴力求解
    public static int [] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[i]+nums[j]==target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[10];
    }
    //法二：哈希表
    public static int[]  twoSum(int[] nums,int target){
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target-nums[i])){
                return new int[]{hash.get(target - nums[i]), i};
            }
           hash.put(nums[i],i);
        }
        return new int[10];
    }
}
