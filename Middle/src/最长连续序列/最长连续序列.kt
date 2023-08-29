package 最长连续序列

fun main() {
    println(longestConsecutive(listOf<Int>(0,3,7,2,5,8,4,6,0,1).toIntArray()))
}
fun longestConsecutive(nums: IntArray): Int {
    val max = nums.max()
    val min = nums.min()
    var long = 0
    var now = 0
    for (s in min..max){
        if (nums.contains(s)){
            now++
            println(now)
            if (long<now)
                long = now
        }
        else{
            now = 0
        }
        println("long是$long")
    }
    return long
}