open class Tutorial(name: String,  hp: Int) : Person(name, hp) {
    var level3 = Level3(" ", 10,)
    var battleHealth = hp

    fun checkLives() {
        if (battleHealth <= 0) {
            badEnding()
        }
    }

    fun introduction(player: Player) {
        println("""
            |Welcome user to the Naruto RE game!
            |You are one of the few people from all around the universe to have the privilege of participating in this game.
            |This game was created because the gods took pity on failures like you.
            |You couldn't get a girlfriend, you had no friends, you parents were disappointed in you, and all you did was game and watch anime.
            |But you've lucked out and now you can use your worthless life to entertain the gods by fighting to the death!
            |Press enter to start the tutorial!
        """.trimIndent())
        readLine()
        choosingJutsu(player)
    }

    fun choosingJutsu(player: Player) {
        println("""
            |Start by choosing a Jutsu.
            |A Jutsu will be your main means of attacking.
            |You can choose between the Rasengan and the Chidori.
        """.trimIndent())
        val chosenJutsu = readLine()
        if (chosenJutsu == "Rasengan") {
            player.mainPlayerJutsu = Jutsu("Rasengan", 11)
        } else if(chosenJutsu == "Chidori") {
            player.mainPlayerJutsu = Jutsu("Chidori", 10)
        } else {
            println("|You didn't enter the correct answer. Please try again.")
            choosingJutsu(player)
        }
        println("|You've chosen: ${player.mainPlayerJutsu.jutsuName}")
        println(player.mainPlayerJutsu)
        tutorial1(player)
    }

    fun tutorial1(player: Player) {
        val mizuki = Mizuki("Mizuki", 20)
        println("""
            |You will train with an opponent.
            |Your first opponent is Mizuki!
            |To damage an opponent, you can use your Jutsus.
            |Let's start your first fight!
            |Just don't embarrass yourself more than you already have.
            |Press enter to continue...
        """.trimIndent())
        readLine()
        tutorial2(player, mizuki)
    }

    fun mizukiTakesDmg(player: Player, mizuki: Mizuki) {
        mizuki.hp = mizuki.hp - player.mainPlayerJutsu.damageInflicted
        println("|Mizuki has ${mizuki.hp} points of health left.")
    }

    fun tutorial2(player: Player, mizuki: Mizuki) {
        var battleHealth = player.hp
        println("""
            |So you're the idiot they sent to take me down.
            |How unfortunate for you.
            |Mizuki ran towards you ready and got ready to attack.
        """.trimIndent())
        do {
            println("""
                |What will you use?
                ---------------------------------
                A: ${player.mainPlayerJutsu.jutsuName}
                B: Fall dead
                ---------------------------------
            """.trimIndent())
            val rnds = (1..2).random()
            val choice = readLine()
            if (choice == "A" || choice == "a") {
                println("|${player.mainPlayerJutsu.jutsuName} inflicts ${player.mainPlayerJutsu.damageInflicted} points of damage on your opponent.")
                mizukiTakesDmg(player, mizuki)
                if (mizuki.hp > 0) {
                    println("|Mizuki fights back.")
                    if (rnds == 1) {
                        println("|Mizuki uses ${mizuki.mainMizukiJutsu.jutsuName} and inflicts ${mizuki.mainMizukiJutsu.damageInflicted} points of damage on you.")
                        battleHealth = battleHealth - mizuki.mainMizukiJutsu.damageInflicted
                    } else if (rnds == 2) {
                        println("|Mizuki uses ${mizuki.secondMizukiJutsu.jutsuName} and inflicts ${mizuki.secondMizukiJutsu.damageInflicted} points of damage on you.")
                        battleHealth = battleHealth - mizuki.secondMizukiJutsu.damageInflicted
                    }
                } else {
                    tutorialEnd(player)
                    break
                }
                checkLives()
                println("|You have " + battleHealth + " points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("""
                    |You fell on the ground trying to act dead.
                    |But Mizuki wasn't stupid and realized what you did.
                    |He stab you right through the head with a Kunai.
                """.trimIndent())
                badEnding()
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                tutorial2(player, mizuki)
            }
        } while (battleHealth > 0 || mizuki.hp > 0)
    }

    fun tutorialEnd(player: Player) {
        println("""
            |Congratulations! You have defeated Mizuki the loser!
            |You're awarded a new Jutsu!
            |You can choose between the Fireball , Watergun or Windblade.
        """.trimIndent())
        val chosenJutsu2 = readLine()
        if (chosenJutsu2 == "Fireball") {
            player.secondPlayerJutsu = Jutsu("Fireball", 11)
        } else if(chosenJutsu2 == "Watergun") {
            player.secondPlayerJutsu = Jutsu("Watergun", 10)
        } else if(chosenJutsu2 == "Windblade") {
            player.secondPlayerJutsu = Jutsu("Windblade", 12)
        } else {
            println("|You didn't enter the correct answer. Please try again.")
            tutorialEnd(player)
        }
        player.hp = player.hp + 10
        println("""
            |You've chosen: ${player.secondPlayerJutsu.jutsuName}
            |${player.secondPlayerJutsu}
            |Your health has been restored and increased by 10 points.
            |Current hp: ${player.hp}
            |You'll be send to level 3. (Arriving in Konoha was level 1 and the tutorial was level 2 if you couldn't figure it out by now.)
            |Press enter to continue...
        """.trimIndent())
        readLine()
        level3.choosingDirection(player)
    }
}