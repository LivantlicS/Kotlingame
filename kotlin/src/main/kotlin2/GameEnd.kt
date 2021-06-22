import kotlin.system.exitProcess

class GameEnd(name: String, hp: Int) : Player(name, hp) {
    fun gameEnd(player: Player) {
        println("""
            You suddenly disappeared from the battlefield and appeared in a black void.
            You were floating in the void and suddenly a screen appeared in front of you.
            
            Thank you for playing the Text Adventure Ninja Chronicles game.
            We hope that you enjoyed it and are expecting a perfect 5 star review ;)
            
            The game is made by Ouassim Boukayoua and Reguille With.
            And you better remember our names, because you'll be seeing us in every magazine soon.
            Oh and if you're wondering who has been describing your capabilities so perfectly,
            that would be me, Ouassim.
            You agree with me on everything, right?
            Type your answer...
        """.trimIndent())
        readLine()
        println("""
            I knew that you would agree!
            
            Thank you again for playing our game and we hope to see you again.
            Goodbye!
        """.trimIndent())
        exitProcess(-1)
    }
}