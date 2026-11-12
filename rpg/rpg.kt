fun main(){

    var player_action:String
    var player_room:String
    var exists:Boolean
    var player_choice:String=""
    var inventory=mutableListOf<String>()
    var treasury=mutableListOf<String>()

    println("=== MINI ADVENTURE")

    println("")

    println("Room:The castle bedroom\nMission: Look for a hint to the key.\n")

    do{

        println("1.Check the drawers\n2.Look under the carpet.\n3.Look above the closet.\n\n")
        println("Inventory.")
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
            
            if("key" !in inventory){
                println("You found the key on top of the closet.\n")
                println("Key stored in your inventory.\n")
                inventory.add("key")
                println("Now you can enter the next room.")
                print("Proceed(yes or no):\n\n")
                player_choice=readln()
            }
            else if("key" in inventory){
                println("\nKey already found,please proceed.")
                print("Proceed(yes or no):\n\n")
                player_choice=readln()
            }
            
            if(player_choice=="yes"){
                exists=false
                vault(inventory)
            }
            else{
                exists=true
            }
        }
        "inventory"-> {

            println(Inventory(inventory))
            exists=true
        }

    }

    }while(exists)


}

fun vault(inventory:MutableList<String>){

    println("You've entered the royal vault.")
    println("Inevntory.")




}

fun Inventory(inventory:MutableList<String>):String{

    var stash=""
    if(inventory.isEmpty()){
        return("Inventory is emtpy.")
    }

    else{

        for(i in inventory){
            stash="$i\n"
        }       
    } 
    return(stash)
}