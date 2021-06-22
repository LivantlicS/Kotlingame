open class Player(name: String, hp: Int) : Person(name, hp) {
    var mainPlayerJutsu = Jutsu("nothing", 10)
    var secondPlayerJutsu = Jutsu( "Nothing", 10)
    var thirdPlayerJutsu = Jutsu( "Nothing", 10)
    var fourthPlayerJutsu = Jutsu( "Nothing", 10)

    fun awakening() {
        println("""
            |You slowly opened your eyes and stared at an unfamiliar ceiling. You look around to see that you're sleeping on a bed in a unfamiliar room.
            |What will you do? Type the letter.
            
            ---------------------------------
            A: Go back to sleep
            B: Get a panic attack
            C: Get out of bed and look around the room
            D: Get out of bed and run out of the room
            ---------------------------------
        """.trimIndent())
        val choice = readLine()
        if (choice == "A" || choice == "a") {
            awakening()
        }
        else if (choice == "B" || choice == "b") {
            badEnding()
        }
        else if (choice == "C" || choice == "c") {
            println("""
                |You get out of bed and look around the unfamiliar room.
                |But except for the bed and some plain furniture, the room was practically empty.
                |You were still a little bit drowsy, so you decided to walk out of the apartment to get some fresh air.
                |But when you opened the door and walked outside, you got the surprise of a lifetime.
            """.trimIndent())
        }
        else if (choice == "D" || choice == "d") {
            println("""
                |You were confused and slightly panicked when you saw the unfamiliar room.
                |You got out of bed and sprinted towards the door.
                |But when you opened the door and walked outside, you got the surprise of a lifetime.
            """.trimIndent())
        }
        else {
            println("|You've chosen an invalid answer. Try again")
            awakening()
        }
    }
}