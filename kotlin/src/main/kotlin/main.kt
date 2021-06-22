import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("|Choose your name: ")
    val name = readLine()
    println("|Hello $name, welcome to the Ninja Chronicles.")
    println("|I see that you've chosen the path Ninja. This road will be dangerous, but if you prevail, only happiness awaits you.")
    val player = Player("$name", 50)

    //room.choosingDirection()

    println("|Press enter to continue...")
    readLine()


}
