import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("|Choose your name: ")
    val name = readLine()
    println("|Hello $name, welcome to the Ninja Chronicles.")
    println("|I see that you've chosen the path Ninja. This road will be dangerous, but if you prevail, only happiness awaits you.")
    val player = Player("$name", 50)
    val playerV = Village("$name", 50)

    println("|Press enter to continue...")
    readLine()

    player.awakening()
    playerV.konoha1(player)
}

fun badEnding() {
    println("""
        |You fucked up and died.
        |You were so bad that even the enemies felt pity for you.
        |Even Madara Uchiha had a split second thought about showing you a little bit of mercy for you patheticness.
    """.trimIndent())
    exitProcess(-1)
}

