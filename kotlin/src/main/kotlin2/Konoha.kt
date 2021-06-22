open class Village(name: String, hp: Int) : Player(name, hp) {
    var tutorial = Tutorial(" ", 10,)
    open fun konoha1(player: Player) {
        println("""
            |The moment your eyes adjusted to the bright light, the shock you had was unimaginable.
            |Me: Konoha!
            |What will you do next?
            
            ---------------------------------
            A: Thinking this is some stupid dream you run back inside and go back to sleep.
            B: You started freaking out about your situation and got a panic attack.
            C: You start thinking about your situation.
            D: You decide to ask one of the villagers.
            ---------------------------------
        """.trimIndent())
        val choice = readLine()
        if (choice == "A" || choice == "a") {
            badEnding()
        }
        else if (choice == "B" || choice == "b") {
            badEnding()
        }
        else if (choice == "C" || choice == "c") {
            println("|You started thinking and thinking, but you're mind was blank.")
            println("|Suddenly out of nowhere, a blue screen appeared before your eyes, that shocked you.")
            tutorial.introduction(player)
        }
        else if (choice == "D" || choice == "d") {
            println("|You were about to head down from the apartment, when a blue screen suddenly appeared before your eyes.")
            tutorial.introduction(player)
        }
        else {
            println("|You've chosen an invalid answer. Try again.")
            konoha1(player)
        }
    }
}

