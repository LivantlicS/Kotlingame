class Level6(name: String, hp: Int) : Player(name, hp) {
    val level7 = Level7( "", 1)
    var battleHealth = hp
    var orochimaruHealth = 30
    fun checkLives() {
        if (battleHealth <= 0) {
            badEnding()
        }
    }

    fun choosingDirections(player: Player) {
        println("""
            ||Before you're leaving the Temple of Sasori, you're drinken from the waterfountain.
            ||*Leaves the Temple of Sasori*
            ||Me: Woah I did not know that i was brought to the forest.
            ||*Walks around in the forest* 
            ||Me: is that a cabin? let me look in side maybe there is something to eat for me!
            ||*Eats all the food in the refridgerator*
            ||Uknown: WHO IS THAT IN MY HOUSE!!!
            ||Press enter to continue...
            """.trimMargin())
        readLine()
        choosingDirections2(player)
    }
    fun choosingDirections2(player: Player) {
        battleHealth = player.hp
        val orochimaru = Orochimaru("Orochimaru", 40)
        println("""
            ||Me: I'm so sorry I was so hungry and I had nothing to eat the whole day...
            ||Unkown Woman: Oh my dear what happened to you?
            ||Me: Some bullies beat me up today :(
            ||Unkown woman: let me grab something for you to heal your wounds!
            ||Unkown woman: *Treats the wounds*
            ||Unkown woman: 1 day I would like to have a body like yours hmm
            ||Me: huh?
            ||Me: AAH it hurts !!!
            ||Unkown woman: it's supposed to Muhahaha
            ||Me: You bitch you set me up!
            ||Press enter to continue...
            """.trimMargin())
        readLine()
        unkownFight(player, orochimaru)
    }
    fun unkownFight(player: Player, orochimaru: Orochimaru) {
        println("|I suddenly ran towards Her, seemingly ready to kill you.")
        println("|But you weren't a coward anymore and got in a fighting stance, ready to beat her to a pulp.")
        do {
            println("|Which one of your jutsu's will you use?")
            println("---------------------------------")
            println("A: ${player.mainPlayerJutsu.jutsuName}")
            println("B: ${player.secondPlayerJutsu.jutsuName}")
            println("C: ${player.thirdPlayerJutsu.jutsuName}")
            println("D: ${player.fourthPlayerJutsu.jutsuName}")
            println("---------------------------------")
            val choice = readLine()
            if (choice == "A" || choice == "a") {
                println("|${player.mainPlayerJutsu.jutsuName} inflicts ${player.mainPlayerJutsu.damageInflicted} points of damage on your opponent.")
                orochimaruHealth = orochimaruHealth - player.mainPlayerJutsu.damageInflicted
                println("|Unkown woman has ${orochimaruHealth} points of health left.")
                if (orochimaruHealth > 0) {
                    orochimaruAttacks(player, orochimaru)
                } else {
                    orochimaruEncounter(player,orochimaru)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("|${player.secondPlayerJutsu.jutsuName} inflicts ${player.secondPlayerJutsu.damageInflicted} points of damage on your opponent.")
                orochimaruHealth = orochimaruHealth - player.secondPlayerJutsu.damageInflicted
                println("|Unkown woman has ${orochimaruHealth} points of health left.")
                if (orochimaruHealth > 0) {
                    orochimaruAttacks(player, orochimaru)
                } else {
                    orochimaruEncounter(player,orochimaru)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")

            } else if (choice == "C" || choice == "c") {
                println("|${player.thirdPlayerJutsu.jutsuName} inflicts ${player.thirdPlayerJutsu.damageInflicted} points of damage on your opponent.")
                orochimaruHealth = orochimaruHealth - player.thirdPlayerJutsu.damageInflicted
                println("|Unkown woman has ${orochimaruHealth} points of health left.")
                if (orochimaruHealth > 0) {
                    orochimaruAttacks(player, orochimaru)
                } else {
                    orochimaruEncounter(player,orochimaru)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")

            } else if (choice == "D" || choice == "d") {
                println("|${player.fourthPlayerJutsu.jutsuName} inflicts ${player.fourthPlayerJutsu.damageInflicted} points of damage on your opponent.")
                orochimaruHealth = orochimaruHealth - player.fourthPlayerJutsu.damageInflicted
                println("|Unkown woman has ${orochimaruHealth} points of health left.")
                if (orochimaruHealth > 0) {
                    orochimaruAttacks(player, orochimaru)
                } else {
                    orochimaruEncounter(player,orochimaru)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                unkownFight(player, orochimaru)
            }
        } while (battleHealth > 0 || orochimaruHealth > 0)
    }
    fun orochimaruEncounter(player: Player, orochimaru: Orochimaru){
        orochimaruHealth = orochimaru.hp
        println("""
            |*Unkown woman's mask breaks*
            |Me: Orochimaru!?
            |Orochimaru: wel well took you long enough...
            |Me: I'm going to kill you! 
            |Orochimaru: Come and get me then! 
            |Press enter to continue...
        """.trimIndent())
        readLine()
        orochimaruFight(player,orochimaru)
    }
    fun orochimaruFight(player: Player, orochimaru: Orochimaru) {
        println("|She suddenly ran towards Her, seemingly ready to kill you.")
        println("|But you weren't a coward anymore and got in a fighting stance, ready to beat him to a pulp.")
        do {
            println("|Which one of your Jutsu's will you use?")
            println("---------------------------------")
            println("A: ${player.mainPlayerJutsu.jutsuName}")
            println("B: ${player.secondPlayerJutsu.jutsuName}")
            println("C: ${player.thirdPlayerJutsu.jutsuName}")
            println("D: ${player.fourthPlayerJutsu.jutsuName}")
            println("---------------------------------")
            val choice = readLine()
            if (choice == "A" || choice == "a") {
                println("|${player.mainPlayerJutsu.jutsuName} inflicts ${player.mainPlayerJutsu.damageInflicted} points of damage on your opponent.")
                orochimaruHealth = orochimaruHealth - player.mainPlayerJutsu.damageInflicted
                println("|Orochimaru has ${orochimaruHealth} points of health left.")
                if (orochimaruHealth > 0) {
                    orochimaruAttacks(player, orochimaru)
                } else {
                    level6End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("|${player.secondPlayerJutsu.jutsuName} inflicts ${player.secondPlayerJutsu.damageInflicted} points of damage on your opponent.")
                orochimaruHealth = orochimaruHealth - player.secondPlayerJutsu.damageInflicted
                println("|Orochimaru has ${orochimaruHealth} points of health left.")
                if (orochimaruHealth > 0) {
                    orochimaruAttacks(player, orochimaru)
                } else {
                    level6End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")

            } else if (choice == "C" || choice == "c") {
                println("|${player.thirdPlayerJutsu.jutsuName} inflicts ${player.thirdPlayerJutsu.damageInflicted} points of damage on your opponent.")
                orochimaruHealth = orochimaruHealth - player.thirdPlayerJutsu.damageInflicted
                println("|Orochimaru has ${orochimaruHealth} points of health left.")
                if (orochimaruHealth > 0) {
                    orochimaruAttacks(player, orochimaru)
                } else {
                    level6End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")

            } else if (choice == "D" || choice == "d") {
                val rnds = (1..2).random()
                if (rnds == 1) {
                    println("|${player.fourthPlayerJutsu.jutsuName} inflicts ${player.fourthPlayerJutsu.damageInflicted} points of damage on your opponent.")
                    orochimaru.hp = orochimaru.hp - player.fourthPlayerJutsu.damageInflicted
                    println("|Orochimaru has ${orochimaru.hp} points of health left.")
                    if (orochimaru.hp > 0) {
                        orochimaruAttacks(player, orochimaru)
                    } else {
                        level6End(player)
                        break
                    }
                    checkLives()
                    println("|You have ${battleHealth} points of health left.")
                } else if (rnds == 2) {
                    println("|You're Jutsu failed to work, that's just too bad.")
                    if (orochimaru.hp > 0) {
                        orochimaruAttacks(player, orochimaru)
                    } else {
                        level6End(player)
                        break
                    }
                    checkLives()
                    println("|You have ${battleHealth} points of health left.")
                }
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                orochimaruFight(player, orochimaru)
            }
        } while (battleHealth > 0 || orochimaruHealth > 0)
    }

    fun level6End(player: Player) {
        println("""
            |Congratulations, you've defeated Orochimaru!
            |You've achieved a feat that few could!
            (Of course without the our help, you wouldn't have been able to even scratch him.)
            |Your previous Jutsus will get +5 damage")
            |And your health is increased by 20")
        """.trimIndent())
        player.mainPlayerJutsu.damageInflicted = player.mainPlayerJutsu.damageInflicted + 5
        player.secondPlayerJutsu.damageInflicted = player.secondPlayerJutsu.damageInflicted + 5
        player.thirdPlayerJutsu.damageInflicted = player.thirdPlayerJutsu.damageInflicted + 5
        player.fourthPlayerJutsu.damageInflicted = player.fourthPlayerJutsu.damageInflicted + 5
        player.hp = player.hp + 20
        println("""
            ---------------------------------
            ${player.mainPlayerJutsu}
            ${player.secondPlayerJutsu}
            ${player.thirdPlayerJutsu}
            ${player.fourthPlayerJutsu}
            ---------------------------------
            |Press enter to continue...
        """.trimIndent())
        readLine()
        level7.choosingDirections(player)
    }

    fun orochimaruAttacks(player: Player, orochimaru: Orochimaru) {
        val rnds = (1..4).random()
        println("|Orochimaru woman attacks you.")
        if (rnds == 1) {
            println("|Orochimaru uses ${orochimaru.mainOrochimaruJutsu.jutsuName} and inflicts ${orochimaru.mainOrochimaruJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - orochimaru.mainOrochimaruJutsu.damageInflicted
        } else if (rnds == 2) {
            println("|Orochimaru uses ${orochimaru.secondOrochimaruJutsu.jutsuName} and inflicts ${orochimaru.secondOrochimaruJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - orochimaru.secondOrochimaruJutsu.damageInflicted
        } else if (rnds == 3) {
            println("|Orochimaru uses ${orochimaru.thirdOrochimaruJutsu.jutsuName} and inflicts ${orochimaru.thirdOrochimaruJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - orochimaru.thirdOrochimaruJutsu.damageInflicted
        } else if (rnds == 4) {
            println("|Orochimaru uses ${orochimaru.fourthOrochimaruJutsu.jutsuName} and inflicts ${orochimaru.fourthOrochimaruJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - orochimaru.fourthOrochimaruJutsu.damageInflicted
        }
    }
}

