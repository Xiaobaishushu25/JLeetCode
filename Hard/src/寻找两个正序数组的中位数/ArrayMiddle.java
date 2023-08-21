package 寻找两个正序数组的中位数;

import com.sun.scenario.effect.Merge;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Xbss
 * @version 1.0
 * @create 2022-03-20-16:46
 * @descirbe :给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class ArrayMiddle {
    public static void main(String[] args) {
        int[] a={1,3};
        int[] b={4,2};
        findMedianSortedArrays(a,b);
//        for (int i = 0; i <a.length; i++) {
//            System.out.println(a[i]);
//        }
    }
    public  static  double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
             arr.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
             arr.add(nums2[i]);
        }
        Collections.sort(arr);
//        for (int i : arr) {
//            System.out.println(i);
//        }
//        System.out.println("大小为:"+arr.size());
//        QuickSort(arr,0,arr.size()-1);
        if (arr.size()%2==1){
            System.out.println("奇数");
            System.out.println(arr.size()/2+1);
//            double x=arr.get(arr.size()/2);
            System.out.println(arr.get(arr.size()/2));
            return arr.get(arr.size()/2);
        }else {
            System.out.println("偶数");
            System.out.println(arr.size()/2-1);
            double x1=arr.get(arr.size()/2-1);
            double x2=arr.get(arr.size()/2);
//            double x=((arr.get(arr.size()/2-1))+arr.get(arr.size()/2))/2;
            double x=(x1+x2)/2;
            System.out.println(x);
            return x;
        }
    }
    //自己写了个快排没用上，而且复杂度也不行，快排是nlogn.
    public static void QuickSort(Integer[] arr,int left,int right){
        int low=left;
        int high=right;
        int key=left;
        int temp=0;
        if (left>=right){
            return;
        }
        while(low<high){
            while (low<high&&arr[high]>=arr[key]){
                high--;
            }
            while (low<high&&arr[low]<=arr[key]){
                low++;
            }
            temp=arr[high];
            arr[high]=arr[low];
            arr[low]=temp;
        }
        temp=arr[low];
        arr[low]=arr[key];
        arr[key]=temp;
        QuickSort(arr,left,low-1);
        QuickSort(arr,low+1,right);
    }

}
