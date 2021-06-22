class Level5(name: String, hp: Int) : Player(name, hp) {
    val level6 = Level6("", 1)
    val karasu = "Karasu"
    val kuroari = "Kuroari"
    val hiruko = "Hiruko"
    val sandaime = "Sandaime"
    var battleHealth = hp
    var puppets = ""
    fun checkLives() {
        if (battleHealth <= 0) {
            badEnding()
        }
    }

    fun choosingDirections(player: Player) {
        println("""
                        ||You've gotten lost in the desert. Because the sun is hot you've gotten thirsty and you want to drink water. there is no place to get water near you, so you keep on walking ....
                        ||2 Hours later you bump into a stranger.
                        ||Stranger: Well, hallo my friend can I help you with anything?
                        ||Me: yes, do you know a place where I could drink water?
                        ||Stranger: You could go to one of the 4 puppet tempels.they'll be having water fountains inside. there is 1 in the north, 1 in the east, 1 in the west and 1 in the south.
                        ||Me: Weird, why would there be any tempels in the middle of the desert?
                        ||Stranger: Today 1000 years ago There was a boy named Sasori he had 4 puppets his parents threw them away because they did not like the puppets.
                        ||Stranger: The puppets came alive and killed his parents. Sasori was so mad at his Puppets he stored them away in sepret tempels.
                        ||Press enter to continue...
            """.trimMargin())
        readLine()
        choosingDirections2(player)
    }
    fun choosingDirections2(player: Player) {
        println("""
                        |Me: Do those puppets have names?
                        |Stranger: the names of those puppets were: Karasu, Kuroari, Hiruko, or Sandaime
                        |Me: than I would like to go to the temple of the South.
                        |Stranger: That's the Temple where the scariest puppet was kept.
                        |Me: what's the  name of that puppet?
                        |Stranger: The name of the puppet was...
                        [Choose between these 4 names...]
                        [Karasu, Kuroari, Hiruko, Sandaime]
        """.trimIndent())
        puppets = readLine().toString()
        when (puppets) {
            karasu -> puppet1(player)
            kuroari -> puppet2(player)
            hiruko -> puppet3(player)
            sandaime -> puppet4(player)
            else -> {
                println("|Wrong answer. Try again.")
                choosingDirections2(player)
            }
        }
    }
    fun puppet1(player: Player) {
        println("|Stranger: You've chosen $karasu the puppet of Agility")
        player.mainPlayerJutsu.damageInflicted = player.mainPlayerJutsu.damageInflicted + 5
        Warp(player)
    }

    fun puppet2(player: Player) {
        println("|Stranger: You've chosen $kuroari the puppet of Speed")
        player.secondPlayerJutsu.damageInflicted = player.secondPlayerJutsu.damageInflicted + 5
        Warp(player)
    }

    fun puppet3(player: Player) {
        println("|Stranger: You've chosen $hiruko the puppet of Inteligent")
        player.thirdPlayerJutsu.damageInflicted = player.thirdPlayerJutsu.damageInflicted + 5
        Warp(player)
    }

    fun puppet4(player: Player) {
        println("|Stranger: You've chosen $sandaime the puppet of Strength")
        player.fourthPlayerJutsu.damageInflicted = player.fourthPlayerJutsu.damageInflicted + 2
        Warp(player)
    }

    fun Warp(player: Player) {
        println("""
            |Me: What? how did I do that???
            |Stranger: *Warps us to the temple of $puppets*
            |Stranger: MUHAHAHAHA You've walked in my trapcard *drops cloak*
            |Press enter to continue...
        """.trimIndent())
        readLine()
        sasoriEncounter(player)
    }
    fun sasoriEncounter(player: Player) {
        println("""
            |Me: Wait what is that you Sasori?
            |Sasori: well that took you long enough
            |Me: you should of died 1000 years ago how are you still alive?
            |Sasori: I've sealed my hart in the puppet of $puppets and now I'm immortal
            |Press enter to continue...
            """.trimIndent())
        readLine()
        sasoriEncounter2(player)
    }
    fun sasoriEncounter2(player: Player) {
        battleHealth = player.hp
        val sasori = Sasori("Sasori", 40)
        println("""
            ||Sasori: Any last words? before I make a puppet out of you?
            ||Press enter to continue...
        """.trimMargin())
        readLine()
        sasoriFight(player, sasori)
    }
    fun sasoriFight(player: Player, sasori: Sasori) {
        println("""
            |Sasori suddenly ran towards you, seemingly ready to kill you.
            |But you weren't a coward anymore and got in a fighting stance, ready to beat him to a pulp.
        """.trimIndent())
        do {
            println("""
                |Which one of your Jutsus will you use?
                ---------------------------------
                A: ${player.mainPlayerJutsu.jutsuName}
                B: ${player.secondPlayerJutsu.jutsuName}
                C: ${player.thirdPlayerJutsu.jutsuName}
                D: ${player.fourthPlayerJutsu.jutsuName}
                ---------------------------------
            """.trimIndent())
            val choice = readLine()
            if (choice == "A" || choice == "a") {
                println("|${player.mainPlayerJutsu.jutsuName} inflicts ${player.mainPlayerJutsu.damageInflicted} points of damage on your opponent")
                sasori.hp = sasori.hp - player.mainPlayerJutsu.damageInflicted
                println("|Sasori has ${sasori.hp} points of health left.")
                if (sasori.hp > 0) {
                    sasoriAttacks(player, sasori)
                } else {
                    level5End(player)
                    break
                }
                checkLives()
                println("|You have " + battleHealth + " points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("|${player.secondPlayerJutsu.jutsuName} inflicts ${player.secondPlayerJutsu.damageInflicted} points of damage on your opponent")
                sasori.hp = sasori.hp - player.secondPlayerJutsu.damageInflicted
                println("|Sasori has ${sasori.hp} points of health left.")
                if (sasori.hp > 0) {
                    sasoriAttacks(player, sasori)
                } else {
                    level5End(player)
                    break
                }
                checkLives()
                println("|You have " + battleHealth + " points of health left.")

            } else if (choice == "C" || choice == "c") {
                println("|${player.thirdPlayerJutsu.jutsuName} inflicts ${player.thirdPlayerJutsu.damageInflicted} points of damage on your opponent")
                sasori.hp = sasori.hp - player.thirdPlayerJutsu.damageInflicted
                println("|Sasori has ${sasori.hp} points of health left.")
                if (sasori.hp > 0) {
                    sasoriAttacks(player, sasori)
                } else {
                    level5End(player)
                    break
                }
                checkLives()
                println("|You have " + battleHealth + " points of health left.")

            } else if (choice == "D" || choice == "d") {
                val rnds = (1..2).random()
                if (rnds == 1) {
                    println("|${player.fourthPlayerJutsu.jutsuName} inflicts ${player.fourthPlayerJutsu.damageInflicted} points of damage on your opponent")
                    sasori.hp = sasori.hp - player.fourthPlayerJutsu.damageInflicted
                    println("|Sasori has ${sasori.hp} points of health left.")
                    if (sasori.hp > 0) {
                        sasoriAttacks(player, sasori)
                    } else {
                        level5End(player)
                        break
                    }
                    checkLives()
                    println("|You have " + battleHealth + " points of health left.")
                } else if (rnds == 2) {
                    println("|You're Jutsu failed to work, that's just too bad.")
                    if (sasori.hp > 0) {
                        sasoriAttacks(player, sasori)
                    } else {
                        level5End(player)
                        break
                    }
                    checkLives()
                    println("|You have " + battleHealth + " points of health left.")
                }
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                sasoriFight(player, sasori)
            }
        } while (battleHealth > 0 || sasori.hp > 0)
    }
    fun level5End(player: Player) {
        println("""
            |Congratulations, you've defeated Sasori!
            |You've achieved a feat that few could!
            |(Of course without the our help, you wouldn't have been able to even scratch him.)
            |Your previous Jutsus will get +5 damage")
            |And your health is increased by 10")
        """.trimIndent())
        player.mainPlayerJutsu.damageInflicted = player.mainPlayerJutsu.damageInflicted + 5
        player.secondPlayerJutsu.damageInflicted = player.secondPlayerJutsu.damageInflicted + 5
        player.thirdPlayerJutsu.damageInflicted = player.thirdPlayerJutsu.damageInflicted + 5
        player.fourthPlayerJutsu.damageInflicted = player.fourthPlayerJutsu.damageInflicted + 5
        player.hp = player.hp + 10
        println("""
            ---------------------------------
            |${player.mainPlayerJutsu}
            |${player.secondPlayerJutsu}
            |${player.thirdPlayerJutsu}
            |${player.fourthPlayerJutsu}
            ---------------------------------
            |Press enter to continue...
        """.trimIndent())
        readLine()
        level6.choosingDirections(player)
    }
    fun sasoriAttacks(player: Player, sasori: Sasori) {
        val rnds = (1..4).random()
        println("|Sasori attacks you.")
        if (rnds == 1) {
            println("|Sasori uses " + sasori.mainSasoriJutsu.jutsuName + " and inflicts " + sasori.mainSasoriJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - sasori.mainSasoriJutsu.damageInflicted
        } else if (rnds == 2) {
            println("|Sasori uses " + sasori.secondSasoriJutsu.jutsuName + " and inflicts " + sasori.secondSasoriJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - sasori.secondSasoriJutsu.damageInflicted
        } else if (rnds == 3) {
            println("|Sasori uses  " + sasori.thirdSasoriJutsu.jutsuName + " and inflicts " + sasori.thirdSasoriJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - sasori.thirdSasoriJutsu.damageInflicted
        } else if (rnds == 4) {
            println("|Sasori uses " + sasori.fourthSasoriJutsu.jutsuName + " and inflicts " + sasori.fourthSasoriJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - sasori.fourthSasoriJutsu.damageInflicted
        }
    }
}