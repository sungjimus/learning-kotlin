open class Student(

    var name:String,
    var roll:Int,
    var sem:Int
    
    
)

class Regular(

    name:String,
    roll:Int,
    sem:Int
):Student(name,roll,sem)

class Research(

    name:String,
    roll:Int,
    sem:Int,
    var topic:String
):Student(name,roll,sem)


    

        


fun main(){

    var choice:Boolean=true
    val stulist=mutableListOf<Student>()

    while(choice){
        var ans:Int

        println("1.Add student info.")
        println("2.Search for student.")
        println("3.Update student detail.")
        println("4.Delete Student data.")
        println("5.Exit.")
        println("enter your choice:")

        ans=readln().toInt()

        if(ans==1){
            println("What type of student are you?\n 1.Regular student.\n 2.Research student.")
            var stutype=readln().toInt()

            when(stutype){

                    1 -> println(addstu(stulist,stutype))

                    2 -> println(addstu(stulist,stutype))

            }
            
            
        }

        else if(ans==2){
            println(search(stulist))
        }

        else if(ans==3){
            update(stulist)
        }

        else if(ans==4){

            del(stulist)
        }

        else if(ans==5){
            choice=false
        }
    }
    print("Exited succesfully")

}

fun addstu(stulist:MutableList<Student>,stutype:Int):String{

    var user:Char='y'

    var name:String
    var roll:Int
    var sem:Int

    while(user=='y' && stutype==1){

        print("Name of the student:")
        name=readln()

        print("")

        var exists:Boolean

        do{
            exists=false
            print("Roll number:")
            roll= readln().toInt()

            if(roll<0){
                exists=true
                println("The roll number is invalid.")
            }

            for(i in stulist){
                if(i.roll==roll){
                    exists=true
                    println("The roll number already exists.")
                }
            }   

        }while(exists)

    
        

        print("")

        println("Semester:")
        sem=readln().toInt()


        stulist.add(Regular(name,roll,sem))

        print("Do u wish to continue y or n: ")
        user=readln().first()

    }
    while(user=='y' && stutype==2){

        print("Name of the student:")
        name=readln()

        print("")

        var exists:Boolean

        do{
            exists=false
            print("Roll number:")
            roll= readln().toInt()

            if(roll<0){
                exists=true
                println("The roll number is invalid.")
            }

            for(i in stulist){
                if(i.roll==roll){
                    exists=true
                    println("The roll number already exists.")
                }
            }   

        }while(exists)

    
    
        print("")

        println("Semester:")
        sem=readln().toInt()

        println("Whats your research field?")
        var research:String=readln()

        stulist.add(Research(name,roll,sem,research))

        print("Do u wish to continue y or n: ")
        user=readln().first()

    }
    return("Added successfully!")
    
}

fun search(stulist:MutableList<Student>):String{

    println("Enter the roll number:")
    var find:Int=readln().toInt()

    for (i in stulist){

        if(i.roll==find && i is Regular){
            return("Name:${i.name}\nRoll:${i.roll}\nSemester:${i.sem}")
            break
        }
        else if(i.roll==find && i is Research){
            return("Name:${i.name}\nRoll:${i.roll}\nSemester:${i.sem}\nTopic:${i.topic}")
            break
        }
        
    }
    return("No result")

}

fun update(stulist:MutableList<Student>){

    print("Roll number of the student:")
    var mod:Int=readln().toInt()

    var change:String

    for(i in stulist){

        if(i.roll==mod){
            println("Name:${i.name}\nRoll:${i.roll}\nSemester:${i.sem}")
            println("what do u want to change")
            change=readln()
                
            when(change){

                "roll" -> {

                    print("New roll number:")
                    var new_roll:Int=readln().toInt()

                    i.roll=new_roll
                    println("succesfully changed.")
                }
                "semester" -> {

                    print("New semester:")
                    var new_sem:Int=readln().toInt()

                    i.sem=new_sem
                    println("succesfully changed.")
                }
            }
            break
        }
    }
    println("no result.")
}

fun del(stulist:MutableList<Student>){

    print("Roll number of the student:")
    var delete:Int=readln().toInt()

    for(i in stulist){

        if(i.roll==delete){
            stulist.remove(i)
            println("Deleted student data successfully")
            break
        }
    }
    println("student not found")

}