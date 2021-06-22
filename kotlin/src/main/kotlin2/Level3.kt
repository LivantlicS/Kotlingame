class Level3(name: String, hp: Int) : Player(name, hp) {
    val level4 = Level4(" ", 1)
    var battleHealth = hp

    fun checkLives() {
        if (battleHealth <= 0) {
            badEnding()
        }
    }

    fun choosingDirection(player: Player) {

        println("""
            |You've suddenly disappeared from the tutorial stage and appeared on a bench in a expansive grassland.
            |Choose a direction:
            |North, East, South, or West
        """.trimIndent())
        val direction = readLine()
        when (direction) {
            "North" -> north(player)
            "East" -> east(player)
            "South" -> south(player)
            "West" -> west(player)
            else -> {
                println("|Wrong answer. Try again.")
                choosingDirection(player)
            }
        }
    }

    fun north(player: Player) {
        println("|You've chosen to go north and started walking.")
        walking(player)
    }

    fun east(player: Player) {
        println("|You've chosen to go east and started walking.")
        walking(player)
    }

    fun south(player: Player) {
        println("|You've chosen to go south and started walking.")
        walking(player)
    }

    fun west(player: Player) {
        println("|You've chosen to go west and started walking.")
        walking(player)
    }

    fun walking(player: Player) {
        println("""
            |The sun is standing high in the sky, radiating heat which is making you thirsty.
            |You kept walking and walking, till you were about to collapse from exhaustion.
            |But it was then when you spotted something in the distance.
            |Thinking you've finally found your destination, you ran towards it desperately.
            |But the closer you got, the more your face started to morph from desperation to devastation.You arrived at the object you saw, and you almost felt like killing yourself.
            |Me: Why am I back at this stupid chair!
            |Me: Did I walk in a circle?
            |Press enter to continue...
        """.trimIndent())
        readLine()
        sasukeEncounter(player)
        //level6.choosingDirections(player)
    }

    fun sasukeEncounter(player: Player) {
        println("""
            |You decided to take a seat on the bench and rest.
            |But as you were about to take a seat, you sensed a great danger and immediately jumped away from the bench.
            |A second latter, the bench got cut in half by what looked like a lightning blade.
            |Sasuke: Who are you and what are you doing in my domain?
            |Press enter to continue...
        """.trimIndent())
        readLine()
        println("""
            [Sasuke Uchiha]
            [Someone that won't show no mercy and is hell bend on getting revenge.]
            [Revenge on his brother that massacred his clan and parents.]
            [Relationship status: Enemy]
            |Press enter to continue...
        """.trimIndent())
        sasukeFight1(player)
    }

    fun sasukeFight1(player: Player) {
        battleHealth = player.hp
        val sasuke = Sasuke("Sasuke", 40)
        println("""
            |Me: Your domain? It's a pretty shitty place if you can only walk around in circles.
            |His eyes suddenly turned red with three black comma's in them.
            |Sasuke: Release!
            |You looked around in bewilderment as the sky started cracking and withing a couple of seconds, 
            |the world fell into an abyss and you suddenly appeared in a spacious cave.
            
            |Me: What the hell was that!
            |Sasuke: You were trapped in my Genjutsu, a illusionary technique.
            |Sasuke: You would have kept on walking forever if you stayed there.
            |Me: Then why did you get me out? Wouldn't it have been better for you to leave me there till I was completely tired out?
            |Sasuke: That would have been a good strategy against someone stronger than me, but you aren't worth the wait.
            |Press enter to continue...
        """.trimIndent())
        readLine()
        sasukeFight2(player, sasuke)
    }

    fun sasukeFight2(player: Player, sasuke: Sasuke) {
        println("|Sasuke suddenly ran towards you, seemingly ready to kill you.")
        println("|But you weren't a coward anymore and got in a fighting stance, ready to beat him to a pulp.")

        do {
            println("""
                |Which one of your Jutsus will you use?
                ---------------------------------
                A: ${player.mainPlayerJutsu.jutsuName}
                B: ${player.secondPlayerJutsu.jutsuName}
                ---------------------------------
            """.trimIndent())
            val choice = readLine()
            if (choice == "A" || choice == "a") {
                println("|${player.mainPlayerJutsu.jutsuName} inflicts ${player.mainPlayerJutsu.damageInflicted} points of damage on your opponent.")
                sasuke.hp = sasuke.hp - player.mainPlayerJutsu.damageInflicted
                println("|Sasuke has ${sasuke.hp} points of health left.")
                if (sasuke.hp > 0) {
                    sasukeAttacks(player, sasuke)
                } else {
                    level3End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("|${player.secondPlayerJutsu.jutsuName} inflicts ${player.secondPlayerJutsu.damageInflicted} points of damage on your opponent.")
                sasuke.hp = sasuke.hp - player.secondPlayerJutsu.damageInflicted
                println("|Sasuke has ${sasuke.hp} points of health left.")
                if (sasuke.hp > 0) {
                    sasukeAttacks(player, sasuke)
                } else {
                    level3End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                sasukeFight2(player, sasuke)
            }
        } while (battleHealth > 0 || sasuke.hp > 0)
    }

    fun level3End(player: Player) {
        println("""
            |Congratulations, you've defeated Sasuke Uchiha!
            |You've achieved a feat that few could!
            |(Of course without our help, you wouldn't have been able to even scratch him.)
            |But that's besides the point.
            |Go ahead an choose your third Jutsu.
            [Earth Dragon, Water Dragon, Fire Dragon, Lightning Dragon]
        """.trimIndent())

        val chosenJutsu3 = readLine()
        if (chosenJutsu3 == "Earth Dragon") {
            player.thirdPlayerJutsu = Jutsu("Earth Dragon", 17)
        } else if(chosenJutsu3 == "Water Dragon") {
            player.thirdPlayerJutsu = Jutsu("Water Dragon", 15)
        } else if(chosenJutsu3 == "Fire Dragon") {
            player.thirdPlayerJutsu = Jutsu("Fire Dragon", 19)
        } else if(chosenJutsu3 == "Lightning Dragon") {
            player.thirdPlayerJutsu = Jutsu("Lightning Dragon", 19)
        } else {
            println("You didn't enter the correct answer. Please try again.")
            level3End(player)
        }
        println("""
            |You've chosen ${player.thirdPlayerJutsu.jutsuName}")
            |${player.thirdPlayerJutsu}
            |Your previous Jutsus will also get +5 damage")
            |And your health is increased by 10")
        """.trimIndent())
        player.mainPlayerJutsu.damageInflicted = player.mainPlayerJutsu.damageInflicted + 5
        player.secondPlayerJutsu.damageInflicted = player.secondPlayerJutsu.damageInflicted + 5
        player.hp = player.hp + 10
        println("""
            ---------------------------------
            |${player.mainPlayerJutsu}
            |${player.secondPlayerJutsu}
            |${player.thirdPlayerJutsu}
            ---------------------------------
            |Press enter to continue...
        """.trimIndent())
        readLine()
        level4.choosingDirection(player)
    }

    fun sasukeAttacks(player: Player, sasuke: Sasuke) {
        val rnds = (1..4).random()
        println("|Sasuke attacks you.")
        if (rnds == 1) {
            println("|Sasuke uses ${sasuke.mainSasukeJutsu.jutsuName} and inflicts ${sasuke.mainSasukeJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - sasuke.mainSasukeJutsu.damageInflicted
        } else if (rnds == 2) {
            println("|Sasuke uses ${sasuke.secondSasukeJutsu.jutsuName} and inflicts ${sasuke.secondSasukeJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - sasuke.secondSasukeJutsu.damageInflicted
        } else if (rnds == 3) {
            println("|Sasuke uses ${sasuke.thirdSasukeJutsu.jutsuName} and inflicts ${sasuke.thirdSasukeJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - sasuke.thirdSasukeJutsu.damageInflicted
        } else if (rnds == 4) {
            println("|Sasuke uses ${sasuke.fourthSasukeJutsu.jutsuName} and inflicts ${sasuke.fourthSasukeJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - sasuke.fourthSasukeJutsu.damageInflicted
        }
    }
}