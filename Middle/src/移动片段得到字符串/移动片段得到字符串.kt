package 移动片段得到字符串
/**给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。

 **/
fun main() {
//    println(canChange("_L__R__R_","L______RR"))
//    println(canChange("R_L_","__LR"))
    println(canChange("_L__R__R_","L______RR"))
//    println(canChange("_R","R_"))
//    println(canChange("_LL__R__R_","L___L___RR"))
}
fun canChange1(start: String, target: String): Boolean {
    var l = start
    var r = start
    if ((target.first()=='R'&&start.first()!='R')||(target.last()=='L'&&start.last()!='L'))
        return false
    for((index,value) in target.withIndex()){
//        if ((value=='L'&&start[index]=='R')||(value=='R'&&start[index]=='L'))
//            return false
        if (value=='L'){
            findL(l)?.let {
                l = it
            }?:run{ return  false}
        }else if (value=='_'){
            l = l.substring(1)
        }
        if (value=='R'){
            findR(r)?.let {
                r = it
            }?:run{ return  false}
        }else if (value=='_'){
            r = r.removeSuffix("_")
        }
    }
    return true
}
fun findL(subString:String):String?{
    for ((index,value) in subString.withIndex()){
        when(value){
            '_' ->{}
            'R' -> return null
            'L' -> {
                return subString.replaceFirst("L","_").substring(1)
//                return subString.substring(1)
            }
        }
    }
    return null
}
fun findR(subString:String):String?{
    for (i in subString.indices.reversed()) {
        val value = subString[i]
        when(value){
            '_' ->{}
            'L' -> return null
            'R' -> {
                return subString.replaceAfter("R","_").substring(0,i)
//                return subString.substring(0,i)
            }
        }
    }
//    for ((index,value) in subString.withIndex()){
//        when(value){
//            '_' ->{}
//            'L' -> return null
//            'R' -> {
//                return subString.substring(index+1)
//            }
//        }
//    }
    return null
}
fun canChange2(start: String, target: String): Boolean {
    val ns = start.replace("_", "")
    val nt = target.replace("_", "")
    if (ns!=nt)
        return false
    var mutableList = start.toMutableList()
    for((index,value) in target.withIndex()){
        when(value){
            '_' -> {}
            'L' -> {
                find(mutableList,index,true)?.let {
                    mutableList = it
                }?: run { return false }
            }
            'R' -> {
                find(mutableList,index,false)?.let {
                    mutableList = it
                }?: run { return false }
            }
        }
    }
    println(mutableList.toString())
    return true
}
fun find(mutableList: MutableList<Char>,index:Int,toward:Boolean) :MutableList<Char>?{
    if (toward){
        for ((i,value) in mutableList.withIndex()){
            if (i>=index){
                if (value=='L'){
                    mutableList[i] = '1'
                    return mutableList
                }else if (value=='R'||value=='2')
                    return null
            }
        }
        return null
    }else{
        for (i in mutableList.indices.reversed()) {
            val value = mutableList[i]
            if (i<=index){
                if (value=='L'||value=='1')
                    return null
                else if (value=='R'){
                    mutableList[i] = '2'
                    return mutableList
                }
            }
        }

        return null
    }
}
fun canChange(start: String, target: String): Boolean {
    if (start.replace("_", "") != target.replace("_", ""))
        return false
    var j =0
    for ((index,value) in start.withIndex()){
        if (value=='_')
            continue
        while (target[j]=='_')
            j++
//        if (value!=target[j])
//            return false
        if (value!=target[j]||(value=='L'&&index<j)||(value=='R'&&index>j))
            return false
//        else if ((value=='R'&&target[j]!='R')||(value=='R'&&index>j))
//            return false
        else
            j++
    }
    return true
}