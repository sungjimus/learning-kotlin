class student(

    var name:String,
    val roll:Int
)

fun main(){

    val stulist= mutableListOf<student>()

    println("enter your name:")
    var name:String=readln()

    println("enter your roll number:")
    var roll:Int=readln().toInt()

    stulist.add(student(name,roll))

    println("the name ${stulist[0].name}")
    println("the roll ${stulist[0].roll}")
    
}

