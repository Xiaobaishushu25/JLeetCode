package 移动零

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *  https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
fun main() {
//    moveZeroes(listOf<Int>(1,0,21,5,0,0,4,7,8,9,0,0).toIntArray())
    moveZeroes(listOf<Int>(0,1,0,3,12).toIntArray())
}

/**
 * 现遍历给定数组，遇到零计数器+1，不是零将当前元素前移计数器个位置，最后将数组最后计数器个元素置0
 * 时间
 * 464ms 击败 6.42%使用 Kotlin 的用户
 * 内存
 * 38.31MB 击败 50.46%使用 Kotlin 的用户
 * @param nums
 */
fun moveZeroes(nums: IntArray): Unit {
    var zeroCount = 0
    for ((index,value) in nums.withIndex()){
        if (value==0)
            zeroCount++
        else
            moveItem(index,zeroCount,nums)
    }
    var lastZero = nums.size-1
    for (i in 1..zeroCount){
        nums[lastZero--] = 0
    }
    nums.forEach { print(" $it") }
}
fun moveItem(begin:Int,num:Int,nums:IntArray){
//    println("正在将$begin 的元素${nums[begin]}移到${begin-num}的位置上-${nums[begin-num]}")
    nums[begin-num] = nums[begin]
}