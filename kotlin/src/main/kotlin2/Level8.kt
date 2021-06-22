class Level8(name: String, hp: Int) : Player(name, hp) {
    var gameEnding = GameEnd(" ", 0)
    var battleHealth = hp

    fun checkLives() {
        if (battleHealth <= 0) {
            badEnding()
        }
    }

    fun deathStare(player: Player) {
        println("""
            |You were looking at Obito's lifeless body, when something bizarre happened.
            |Obito's body suddenly started spasming.
            |You quickly jumped back fearing that he was about to explode.
            |You looked on with shock as his body started deforming till his whole body and face changed into that of a,
            |middle aged man with long black hair and purple eyes with multiple rings inside of them.
            |He stared into your eyes and you felt like your soul was about to jump out of you body.
            |Even with your meager intellect, you could tell that his stare could kill you.
            |Press enter to continue...
        """.trimIndent())
        readLine()
        madaraUchiha1(player)
    }

    fun madaraUchiha1(player: Player) {
        println("""
            |Madara: So you're the one who killed this useless disciple of mine.
            |Madara: Congratulations, in winning this small battle.
            |Madara: But you killing my disciple isn't something I can just ignore.
            |Madara: I Madara Uchiha always repays his debts!
            |Madara: And you owe me your life!
            
            [BAM]
            
            |Before you could do anything, a kick landed in your stomach and you got sent flying.
            |However, you quickly stabilized yourself in the air and landed on both feet.
            |Press enter to continue...
        """.trimIndent())
        readLine()
        madaraUchiha2(player)
    }

    fun madaraUchiha2(player: Player) {
        println("""
            |Me: Your disciple, huh. I can see now why he was so easy to defeat with a master like you.
            
            |Madara: You a mortal dare speak to me like that!
            
            |Me: Hahaha, not only are you weak, ugly, and stupid, but you also have a god complex.
            |Me: And don't think that I don't know about the Legendary Madara Uchiha who got a ass whooping from Hashirama Senju.
            |Me: It's only normal that he got called 'The God of Shinobi' and you 'The Ghost of the Uchiha.'
            |Me: A pathetic guy like you could never become a god.
            
            [HAHAHAHAHA! You fucked yourself! HAHAHAHAHA! Just wait and see how you're going to regret angering him.]
            [He ain't the same guy you remember him to be.]
            |Press enter to go towards your doom!
        """.trimIndent())
        readLine()
        madaraUchiha3(player)
    }

    fun madaraUchiha3(player: Player) {
        val madara = Madara("Madara Uchiha", 140)
        println("""
            |Madara: It seems like I'll just have to show you firsthand what it means to be a god!
            
            |Madara didn't waste any time and immediately ran towards you.
            |You didn't act like a coward this time and also ran towards him.
            |The two of you met in the middle and punched out towards each other.
            |Your fists collided which created a shockwave that destroyed the ground around you.
            |Madara jumped back and spew out a Fireball from his mouth.
            |But you also jumped back and dodged it.
            |The two of you glared at each other and got ready to start the real fight.
            
            |Press enter to continue...
        """.trimIndent())
        readLine()
        fightMadara(player, madara)
    }

    fun fightMadara(player: Player, madara: Madara) {
        battleHealth = player.hp

        do {
            println("""
            |Which Jutsu will you choose?
            ---------------------------------
            A: ${player.mainPlayerJutsu.jutsuName}
            B: ${player.secondPlayerJutsu.jutsuName}
            C: ${player.thirdPlayerJutsu.jutsuName}
            D: ${player.fourthPlayerJutsu.jutsuName}
            ---------------------------------
        """.trimIndent())
            val choice = readLine()
            if (choice == "A" || choice == "a") {
                println("|${player.mainPlayerJutsu.jutsuName} inflicts ${player.mainPlayerJutsu.damageInflicted} points of damage on your opponent.")
                madara.hp = madara.hp - player.mainPlayerJutsu.damageInflicted
                println("|Madara has ${madara.hp} points of health left.")
                if (madara.hp > 0) {
                    madaraAttacks(player, madara)
                } else {
                    level8End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("|${player.secondPlayerJutsu.jutsuName} inflicts ${player.secondPlayerJutsu.damageInflicted} points of damage on your opponent.")
                madara.hp = madara.hp - player.secondPlayerJutsu.damageInflicted
                println("|Madara has ${madara.hp} points of health left.")
                if (madara.hp > 0) {
                    madaraAttacks(player, madara)
                } else {
                    level8End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else if (choice == "C" || choice == "c") {
                println("|${player.thirdPlayerJutsu.jutsuName} inflicts ${player.thirdPlayerJutsu.damageInflicted} points of damage on your opponent.")
                madara.hp = madara.hp - player.thirdPlayerJutsu.damageInflicted
                println("|Madara has ${madara.hp} points of health left.")
                if (madara.hp > 0) {
                    madaraAttacks(player, madara)
                } else {
                    level8End(player)
                    break
                }
                checkLives()
                println("|You have ${battleHealth} points of health left.")
            } else if (choice == "D" || choice == "d") {
                val rnds = (1..2).random()
                if (rnds == 1) {
                    println("|${player.fourthPlayerJutsu.jutsuName} inflicts ${player.fourthPlayerJutsu.damageInflicted} points of damage on your opponent.")
                    madara.hp = madara.hp - player.fourthPlayerJutsu.damageInflicted
                    println("|Madara has ${madara.hp} points of health left.")
                    if (madara.hp > 0) {
                        madaraAttacks(player, madara)
                    } else {
                        level8End(player)
                        break
                    }
                    checkLives()
                    println("|You have ${battleHealth} points of health left.")
                } else if (rnds == 2) {
                    println("|You're Jutsu failed to work, that's just too bad.")
                    println("|Madara has ${madara.hp} points of health left.")
                    if (madara.hp > 0) {
                        madaraAttacks(player, madara)
                    } else {
                        level8End(player)
                        break
                    }
                    checkLives()
                    println("|You have ${battleHealth} points of health left.")
                }
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                fightMadara(player, madara)
            }
        } while (battleHealth > 0 || madara.hp > 0)
    }

    fun level8End(player: Player) {
        println("""
            |CONGRATULATIONS YOU'VE DEFEATED MADARA UCHIHA.
            |I don't know how you've done it, but you've defeated the strongest person on this planet and completed the game.
            
            |Me: Strongest person? But wasn't the strongest person already, me?
            |Me: After all, I easily defeate-
            
            |Bla, bla, bla. Now shut up and listen to me.
            |You'll be send back to your old world and you'll get 1 trillion dollars.
            |The gods enjoyed your fights, so they won't destroy you like everyone else.
            
            |Me: Destroy!?
            
            |Goodbye and I hope to never see you again!
        """.trimIndent())
        gameEnding.gameEnd(player)
    }

    fun madaraAttacks(player: Player, madara: Madara) {
        val rnds = (1..4).random()
        println("|Madara attacks you.")
        if (rnds == 1) {
            println("|Madara uses ${madara.mainMadaraJutsu.jutsuName} and inflicts ${madara.mainMadaraJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - madara.mainMadaraJutsu.damageInflicted
        } else if (rnds == 2) {
            println("|Madara uses ${madara.mainMadaraJutsu.jutsuName} and inflicts ${madara.mainMadaraJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - madara.secondMadaraJutsu.damageInflicted
        } else if (rnds == 3) {
            println("|Madara uses ${madara.mainMadaraJutsu.jutsuName} and inflicts ${madara.mainMadaraJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - madara.thirdMadaraJutsu.damageInflicted
        } else if (rnds == 4) {
            println("|Madara uses ${madara.mainMadaraJutsu.jutsuName} and inflicts ${madara.mainMadaraJutsu.damageInflicted} points of damage on you.")
            battleHealth = battleHealth - madara.fourthMadaraJutsu.damageInflicted
        }
    }
}