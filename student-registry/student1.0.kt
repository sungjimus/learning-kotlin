class student(

    val name:String,
    val roll:Int,
    val sem:Int
)

fun main(){

    val stulist=mutableListOf<student>()

    var user:Int=1
    while(user!=-1){

        print("enter your name:")
        var name:String=readln()

        println("")

        print("enter your roll number:")
        var roll:Int=readln().toInt()

        for(i in stulist){

            if(i.roll==roll){
                print("The entered roll already exists")
            }
        }
        

        println("")

        print("enter your semester:")
        var sem:Int=readln().toInt()

        println("")

        stulist.add(student(name,roll,sem))

        print("do u wish to continue(1 to continue and -1 to stop):")
        user=readln().toInt()

    }

    for(student in stulist){

            println("student Name:${student.name}")
            println("student Roll:${student.roll}")
            println("student Semester:${student.sem}")
    }
}