package 移动零

fun main() {

}
fun moveZeroes(nums: IntArray): Unit {
    val zero = mutableListOf<Int>()
    for((index,value) in nums.withIndex()){
        if (value==0){
            zero.add(index)
        }
    }
    for ((index,value) in zero.withIndex()){
        for (i in 0)
    }
}