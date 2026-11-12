open class Student(

    var name:String,
    var roll:Int,
    var sem:Int,
    var intro:String
)

class Regular(

    name:String,
    roll:Int,
    sem:Int,
    intro:String
):Student(name,roll,sem,intro)

class Research(

    name:String,
    roll:Int,
    sem:Int,
    intro:String,
    var topic:String
):Student(name,roll,sem,intro)

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

        when(ans){

            1 ->{
                println("What type of student are you?\n 1.Regular student.\n 2.Research student.")
                var stutype=readln().toInt()

                when(stutype){

                    1 -> println(addstu(stulist,stutype))

                    2 -> println(addstu(stulist,stutype))

                }
            }
            2 ->println(search(stulist,))

            3 ->update(stulist)

            4 ->println(del(stulist))

            5 ->choice=false
        }
    }
    print("Exited succesfully")

}

fun addstu(stulist:MutableList<Student>,stutype:Int):String{

    var user:Char='y'

    var name:String
    var roll:Int=0
    var sem:Int=0
    var exists:Boolean

    while(user=='y' && stutype==1){

        do{
            print("Name:")
            name=readln()

            exists=false
            if(name.any{it.isDigit()}){
                exists=true
                println("Only characters should be typed.")
            }
            else if(name.isBlank()){
                exists=true
                println("Name cannot be blank.")
            }

        }while(exists)

        print("")

        

        do{
            try{

                exists=false
                print("Roll number:")
                roll= readln().toInt()

                if(roll<=0){
                    exists=true
                    println("The roll number is invalid.")
                }

                for(i in stulist){
                    if(i.roll==roll){
                        exists=true
                        println("The roll number already exists.")
                    }
                }

            }   

            catch(e:NumberFormatException){
                exists=true
                println("Enter a valid roll number.")
            }

        }while(exists)

        do{
            try{

                exists=false
                print("Semester:")
                sem= readln().toInt()

                if(sem<0 || sem>8){
                    exists=true
                    println("The semester is invalid.")
                }

            }   

            catch(e:NumberFormatException){
                exists=true
                println("Enter a valid semester.")
            }

        }while(exists)

        print("")

        println("")

        println("Write an introduction for yourself.")
        var intro:String=readln()
        
        stulist.add(Regular(name,roll,sem,intro))

        print("Do u wish to continue y or n: ")
        user=readln().first()

    }
    while(user=='y' && stutype==2){

        print("Name of the student:")
        name=readln()

        print("")

        var exists:Boolean

        do{
            try{

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

            }   

            catch(e:NumberFormatException){
                exists=true
                println("Enter a valid roll number.")
            }

        }while(exists)

    
    
        print("")

       do{
            try{

                exists=false
                print("Semester:")
                sem= readln().toInt()

                if(sem<0 && sem>8){
                    exists=true
                    println("The semester is invalid.")
                }

            }   

            catch(e:NumberFormatException){
                exists=true
                println("Enter a valid semester.")
            }

        }while(exists)

        println("Write an introduction for yourself.")
        var intro:String=readln()

        println("Whats your research field?")
        var research:String=readln()

        stulist.add(Research(name,roll,sem,intro,research))

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
            return("Name:${i.name}\nRoll:${i.roll}\nSemester:${i.sem}\nIntroduction:${i.intro}")
            break
        }
        else if(i.roll==find && i is Research){
            return("Name:${i.name}\nRoll:${i.roll}\nSemester:${i.sem}\nTopic:${i.topic}\nIntro:${i.intro}")
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

fun del(stulist:MutableList<Student>):String{

    print("Roll number of the student:")
    var delete:Int=readln().toInt()

    for(i in stulist){

        if(i.roll==delete){
            stulist.remove(i)
            return("Deleted student data successfully")
            break
        }
    }
    return("student not found")

}