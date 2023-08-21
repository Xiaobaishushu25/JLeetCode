package 盛水最多的容器;

/**
 * @author Xbss
 * @version 1.0
 * @create 2022-04-11-22:58
 * @descirbe ：给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点(i, 0)和(i, height[i])。
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。（有点抽象，可以看图）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class Solution {
    public static void main(String[] args) {
        int[] a={1,8,6,2,5,4,8,3,7};
//        int i = maxArea(a);
//        System.out.println(i);
        int answer = Answer(a);
        System.out.println(answer);
    }
    //暴力循环超时，此时想优化的解法，本来是想固定一个指针另一个指针右移，看看能不能由高度比较排除某种情况，但是高不确定，同时底在增大，所以行不通
    //看了答案的思路后发现差不多，只要左右指针一开始指在开始和结尾，内移的时候底在缩小，所以只需要移动两条高中比较小的的高即可，因为底在缩小，所以高
    //只有在变大的情况下可能变大（双指针）
    public static int maxArea(int[] height) {
        int max=0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int high=Math.min(height[i],height[j] );
                int may=(j-i)*high;
                if (may>max){
                    max=may;
                }
            }
        }
        return max;
    }
    //这个答案在我看了大概题解思路直接写的哦，没有看别人的代码实现
    public  static int Answer(int[] a) {
        int low=0;
        int high=a.length-1;
        int max=0;
        while(low<high){
            int bot=high-low;
            int height=Math.min(a[low],a[high]);
            if (max<(bot*height)){
                max=bot*height;
            }
            if (a[low]<a[high]){
                low++;
            }else {
                high--;
            }
        }
    return max;
    }
}
