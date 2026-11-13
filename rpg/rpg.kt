class Player(

    var room:String,
    var inventory: MutableList<String> = mutableListOf()
)

fun main(){

    var player_action:String
    var exists:Boolean
    var player_choice:String=""
    var user=Player("Bedroom")

    println("=== MINI ADVENTURE")

    println("")

    println("Room:The castle bedroom\nMission: Look for a hint to the key.\n")


    do{

        println("1.Check the drawers\n2.Look under the carpet.\n3.Look above the closet.\n\n")
        println("Option.")
        print("Whats your choice:")
        player_action=readln()

        exists=false

        println("")

        when(player_action){

        "1" -> {
            println("You found old photographs of the king and his family, nothing worth taking.\n")
            exists=true
        }

        "2" -> {
            println("Theres something written underneath the carpet.\"The answer is look where gods reside\"")
            exists=true
        }

        "3" -> {
            
            if("key" !in user.inventory){
                println("You found the key on top of the closet.\n")
                println("Key stored in your inventory.\n")
                user.inventory.add("key")
                println("Now you can enter the next room.")
                print("Proceed(yes or no):\n\n")
                player_choice=readln()
            }
            else if("key" in user.inventory){
                println("\nKey already found,please proceed.")
                print("Proceed(yes or no):\n\n")
                player_choice=readln()
            }
            
            if(player_choice=="yes"){
                exists=false
                vault(user)
            }
            else{
                exists=true
            }
        }
        "option"-> {

            println(user_option(user))
            exists=true
        }

    }

    }while(exists)


}

fun vault(user:Player){

    var player_action:String
    var player_choice:String=""
    user.room="Royal Vault"


    var exists:Boolean

    println("You've entered the royal vault.")
    println("Mission:Look for the key to the garden.\n")
    
    do{
        exists=false

        println("1.Holy sword.(grab).\n2.The light armour.\n  Option\n")
        player_action=readln()

        when(player_action){

            "1"->{
                
                if("Holy Sword" in user.inventory){
                    println("You've already found the key to the lock.\nPlease proceed(yes or no):\n")
                    player_choice=readln()
                }
                else if ("Holy Sword" !in user.inventory){
                    user.inventory.add("Holy Sword")                    
                    println("Took the holy sword.The lock on the door is shaped like the great sword.\nDo you wish to open the door?")
                    player_choice=readln()
                    
                }
                if(player_choice=="yes"){
                    exists=false
                    println("You've made it out!!Good job.")

                }
                else{
                    exists=true
                }
            }
            "2"->{
                println("Put on the light armour.Unfortunatly the door is still locked.")
                exists=true
            }
            "option"->{
                println(user_option(user))
                exists=true

            }

        }

    }while(exists)

}

fun user_option(user:Player):String{

    var stash=""

    println("1.Current Room\n2.Inventory.")
    var player_choice=readln()

    when(player_choice){

        "1"->{
            return("Current Room:${user.room}")
        }
        "2"->{

            if(user.inventory.isEmpty()){
                return("Inventory empty.")
            }
            else{
                for(i in user.inventory){
                    stash+="$i\n"
                }
                return(stash)
            }
        }

        else->return("Invalid Option.")
    }
    
    

}