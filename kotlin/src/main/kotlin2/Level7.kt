class Level7(name: String, hp: Int) : Player(name, hp) {
    val level8 = Level8( "", 1)
    var battleHealth = hp
    fun checkLives() {
        if (battleHealth <= 0) {
            badEnding()
        }
    }
    fun choosingDirections(player: Player) {
        println("""
            ||After you went to the nearest hospital you went back to the woods,
            ||because you saw lots of ninja's gathering together. So you were hiding in the tree's so you could follow them.
            ||You've overheard ninja's talking about caputering the three-tails.
            ||*Night hits*
            ||You hear a loud voice from far:
            ||Stranger: RIN !!!
            ||Press enter to continue...
            """.trimMargin())
        readLine()
        plan(player)

    }

     fun plan(player: Player) {
        val obito = Obito("Obito", 40)
        println("""
            |you've gotten closer and you're seeing a little boy with a Chidori in his hands from far
            |What will you do next?
            
            ---------------------------------
            A: Stop the little boy
            B: Kill the litle boy
            C: Wait to see what's going to happen
            D: Watch what the other ninja's are gonna do
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
            println("|You see the little boy puncture the little girl with the chidori")
            obitoEncounter(player, obito)
        }
        else if (choice == "D" || choice == "d") {
            println("|The ninja's kill the little girl")
            obitoEncounter(player, obito)
        }
        else {
            println("|You've chosen an invalid answer. Try again.")
            plan(player)
        }
    }

    fun obitoEncounter(player: Player, obito: Obito){
        battleHealth = player.hp
        println("""
            |*You're hearing that loud scream again...*
            |Stranger: RIN!!!
            |Me: I think this dude got angry because that little girl got killed.
            |Stranger: *Killing everyone of those surrounding ninja's*
            |Stranger: *rips the head of a ninja* 
            |Me: Damn he's looking right into my eyes how the hell can he even see me.
            |Me: What the hell he's got a Sharingan eye, he's an uchiha
            |Stranger Screams: Your next ...
            |Press enter to continue..        
                """.trimIndent())
        readLine()
       obitoFight(player, obito)
    }
    fun obitoFight(player: Player, obito: Obito) {
        println("""
            ||He suddenly ran towards me, seemingly ready to kill me.
            ||Me: But I ain't no simp like him crying about a girl
            ||Me: Lemme beat his ass
        """.trimMargin())
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
                obito.hp = obito.hp - player.mainPlayerJutsu.damageInflicted
                println("|Obito has ${obito.hp} points of health left.")
                if (obito.hp > 0) {
                    obitoAttacks(player, obito)
                } else {
                    level7End(player,obito)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("|${player.secondPlayerJutsu.jutsuName} inflicts ${player.secondPlayerJutsu.damageInflicted} points of damage on your opponent.")
                obito.hp = obito.hp - player.secondPlayerJutsu.damageInflicted
                println("|Obito has ${obito.hp} points of health left.")
                if (obito.hp > 0) {
                    obitoAttacks(player, obito)
                } else {
                    level7End(player,obito)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")

            } else if (choice == "C" || choice == "c") {
                println("|${player.thirdPlayerJutsu.jutsuName} inflicts ${player.thirdPlayerJutsu.damageInflicted} points of damage on your opponent.")
                obito.hp = obito.hp - player.thirdPlayerJutsu.damageInflicted
                println("|Obito has ${obito.hp} points of health left.")
                if (obito.hp > 0) {
                    obitoAttacks(player, obito)
                } else {
                    level7End(player,obito)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")

            } else if (choice == "D" || choice == "d") {
                val rnds = (1..2).random()
                if (rnds == 1) {
                    println("|${player.fourthPlayerJutsu.jutsuName} inflicts ${player.fourthPlayerJutsu.damageInflicted} points of damage on your opponent.")
                    obito.hp = obito.hp - player.fourthPlayerJutsu.damageInflicted
                    println("|Obito has ${obito.hp} points of health left.")
                    if (obito.hp > 0) {
                        obitoAttacks(player, obito)
                    } else {
                        level7End(player,obito)
                        break
                    }
                    checkLives()
                    println("|You have ${battleHealth} points of health left.")
                } else if (rnds == 2) {
                    println("|You're Jutsu failed to work, that's just too bad.")
                    if (obito.hp > 0) {
                        obitoAttacks(player, obito)
                    } else {
                        level7End(player,obito)
                        break
                    }
                    checkLives()
                    println("|You have ${battleHealth} points of health left.")
                }
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                obitoFight(player, obito)
            }
        } while (battleHealth > 0 || obito.hp > 0)
    }
    fun level7End(player: Player, obito: Obito) {
        println("""
            |Congratulations, you've defeated Obito!
            |You've achieved a feat that few could!
            |(Of course without the our help, you wouldn't have been able to even scratch him.)
            |Your previous Jutsus will get +5 damage")
            |And your health is increased by 30")
        """.trimIndent())
        player.mainPlayerJutsu.damageInflicted = player.mainPlayerJutsu.damageInflicted + 5
        player.secondPlayerJutsu.damageInflicted = player.secondPlayerJutsu.damageInflicted + 5
        player.thirdPlayerJutsu.damageInflicted = player.thirdPlayerJutsu.damageInflicted + 5
        player.fourthPlayerJutsu.damageInflicted = player.fourthPlayerJutsu.damageInflicted + 5
        player.hp = player.hp + 30
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
        level8.deathStare(player)
    }
    fun obitoAttacks(player: Player, obito: Obito) {
        val rnds = (1..4).random()
        println("|Obito attacks you.")
        if (rnds == 1) {
            println("|Obito uses ${obito.mainObitoJutsu.jutsuName} and inflicts ${obito.mainObitoJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - obito.mainObitoJutsu.damageInflicted
        } else if (rnds == 2) {
            println("|Obito uses ${obito.secondObitoJutsu.jutsuName} and inflicts ${obito.secondObitoJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - obito.secondObitoJutsu.damageInflicted
        } else if (rnds == 3) {
            println("|Obito uses ${obito.thirdObitoJutsu.jutsuName} and inflicts ${obito.thirdObitoJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - obito.thirdObitoJutsu.damageInflicted
        } else if (rnds == 4) {
            println("|Obito uses ${obito.fourthObitoJutsu.jutsuName} and inflicts ${obito.fourthObitoJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - obito.fourthObitoJutsu.damageInflicted
        }
    }
}