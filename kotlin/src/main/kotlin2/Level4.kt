class Level4(name: String, hp: Int) : Player(name, hp) {
    val level5 = Level5(" ", 1)
    var battleHealth = hp

    fun checkLives() {
        if (battleHealth <= 0) {
            badEnding()
        }
    }

    fun choosingDirection(player: Player) {
        println("""
            |After you chose your Jutsu, no more messages appeared.
            |What do you want to do now?
            ---------------------------------
            A: Look around the cave.
            B: Exit the cave.
            ---------------------------------
        """.trimIndent())
        val choice = readLine()
        if (choice == "A" || choice == "a") {
            player.hp = player.hp + 10
            println("""
                |You decided to look around the cave, which was pretty much empty.
                |But suddenly from the corner of your eye, you spotted something shiny.
                |You decided to check it out and grabbed the shiny item on the ground.
                
                [CONGRATULATIONS! You have found a special item!]
                [This is a ring that will boost your health by 10 points!]
                [Health plus +10]
                [Current health: ${player.hp}]
                |Press enter to continue...
            """.trimIndent())
            readLine()
            exitCave(player)
        } else if (choice == "B" || choice == "b") {
            exitCave(player)
        } else {
            println("|Wrong answer try again.")
            choosingDirection(player)
        }
    }

    fun exitCave(player: Player) {
        println("""
            |You've walked out of the cave and got met by a heatwave.
            |It felt like it was at least 40 degrees outside.
            |But seeing all the sand in front of you, it made sense.
            |You've landed in a desert.
            |Would you like to go back to the cave and hide or would you like to move forwards?
            ---------------------------------
            A: Hide
            B: Move forward
            ---------------------------------
        """.trimIndent())
        val choice = readLine()
        if (choice == "A" || choice == "a") {
            println("""
                |You've went back into the cave to hide like a coward.
                |However right after you entered, the cave started caving in and a giant boulder blocked you entrance.
                |You've tried desperately to get out, but it was all for naught as a giant boulder flattened your ass.
            """.trimIndent())
            badEnding()
        } else if (choice == "B" || choice == "b") {
            println("""
                |You've walked out of the cave, and just as you've exited it, the cave caved in and you've escaped with your life by just a hairs breath.
                |Me: 'Damn, it's almost as if someone wants me dead,' you thought. Not knowing how true that was...
                |You've looked around, but no matter how far you've looked, you couldn't see anything, but the endless desert in front of you and the giant mountain behind you.
                |Press enter to continue...
            """.trimIndent())
            readLine()
            directionExit(player)
        }
    }

    fun directionExit(player: Player) {
        println("|Which way do you want to go?")
        println("|Left, Right, or Forward")
        val direction = readLine()
        when (direction) {
            "Left" -> left()
            "Right" -> right()
            "Forward" -> forward(player)
            else -> {
                println("Wrong answer. Try again.\n")
                directionExit(player)
            }
        }
    }

    fun left() {
        println("""
            |You've chosen to go left.
            
            |You've started walking through the scorching desert.
            |You've kept walking an walking, and your vision started getting blurry.
            |After walking for a couple of minutes you suddenly feel down.
            |You've looked at your leg and saw a giant scorpion attached to it.
            |Me: Fuck!
            |You're world got taken over by darkness.
        """.trimIndent())
        badEnding()
    }

    fun right() {
        println("""
            |You've chosen to go right.
            |You've started walking right through the scorching desert.
            |After walking for about 10 minutes, you arrived at a small oasis.
            |You're thirsty, so you kneeled down in front of it and started drinking the water.
            |After having your fill, you chose to continue walking.
            |After 10 minutes of walking, you felt yourself becoming lightheaded.
            |And after another 5 minutes your legs gave out and you fell onto the sand.
            
            |[You're idiocy knows no bounds.]
            |[You drank a lethal dose of poison from the oasis.]
            |[Players will die in 3... 2... 1...]
        """.trimIndent())
        badEnding()
    }

    fun forward(player: Player) {
        println("""
            |You've chosen to go forward.
            |You started walking forward through the scorching desert.
            |After walking for about 20 minutes, you spotted a black dot in the distance.
            |The black dots started coming closer and closer to you, till it was standing a couple of meters oposite of you.
            |It was a guy about 16 years of age, with red hair and a Japanese letter on his forehead which means love.
            |Press enter to continue...
        """.trimIndent())
        readLine()
        fightGaara1(player)
    }

    fun fightGaara1(player: Player) {
        battleHealth = player.hp
        val gaara = Gaara("Gaara", 80)
        println("""
            |Me: Yo, I"m ${player.name}, and who are you? you asked.
            |Gaara: You've entered into my land without permission. For that I'll have to kill you."
            |Me: Wait...
            |Before you could reason with him, you saw the sand around you rise up and suddenly fly towards you.
            |You quickly jumped back dodging the attack.
            
            [Gaara of the Desert]
            [Blood thirsty and will kill without hesitation.]
            [Unable to reason with]
            [Relationship status: Prey & Predator]
            
            |Press enter to continue...
        """.trimIndent())
        readLine()
        fightGaara2(player, gaara)
    }

    fun fightGaara2(player: Player, gaara: Gaara) {
        println("|Gaara didn't give you any time to catch your breath, but you won't bow down that easily, right?")

        do {
            println("""
                |Which one of your Jutsus will you use?
                ---------------------------------
                A: ${player.mainPlayerJutsu.jutsuName}
                B: ${player.secondPlayerJutsu.jutsuName}
                C: ${player.thirdPlayerJutsu.jutsuName}
                ---------------------------------
            """.trimIndent())
            val choice = readLine()
            if (choice == "A" || choice == "a") {
                println("|${player.mainPlayerJutsu.jutsuName} inflicts ${player.mainPlayerJutsu.damageInflicted} points of damage on your opponent")
                gaara.hp = gaara.hp - player.mainPlayerJutsu.damageInflicted
                println("|Gaara has ${gaara.hp} points of health left.")
                if (gaara.hp > 0) {
                    gaaraAttacks(player, gaara)
                } else {
                    level4End(player)
                    break
                }
                checkLives()
                println("|You have " + battleHealth + " points of health left.")
            } else if (choice == "B" || choice == "b") {
                println("|${player.secondPlayerJutsu.jutsuName} inflicts ${player.secondPlayerJutsu.damageInflicted} points of damage on your opponent")
                gaara.hp = gaara.hp - player.secondPlayerJutsu.damageInflicted
                println("|Gaara has ${gaara.hp} points of health left.")
                if (gaara.hp > 0) {
                    gaaraAttacks(player, gaara)
                } else {
                    level4End(player)
                    break
                }
                checkLives()
                println("|You have " + battleHealth + " points of health left.")
            } else if (choice == "C" || choice == "c") {
                println("|${player.thirdPlayerJutsu.jutsuName} inflicts ${player.thirdPlayerJutsu.damageInflicted} points of damage on your opponent")
                gaara.hp = gaara.hp - player.thirdPlayerJutsu.damageInflicted
                println("|Gaara has ${gaara.hp} points of health left.")
                if (gaara.hp > 0) {
                    gaaraAttacks(player, gaara)
                } else {
                    level4End(player)
                    break
                }
                checkLives()
                println("|You have " + battleHealth + " points of health left.")
            } else {
                println("|You didn't enter the correct answer. Please try again.")
                fightGaara2(player, gaara)
            }
        } while (battleHealth > 0 || gaara.hp > 0)
    }

    fun level4End(player: Player) {
        println("""
            |Congratulations! You've defeated Gaara of the Desert, someone who killed countless people when he could barely walk.
            |And even though it was mainly because of our help, you actually contributed to this win a little bit more than your previous battles.
            |Who knows, maybe you'll be able to win all on your own in the future!
            |(Yeah, right.)
            |Well anyway, enough about that, since you've defeated another opponent, you'll get your fourth Jutsu!
            |You'll be able to choose between these four Jutsus.
            [Meteor, Susanoo, Rasenshuriken, Indra's Arrow]
            |Press enter to continue...
        """.trimIndent())
        readLine()
        println("""
            |Now, let me explain these Jutsus a little bit, they're special after all.
            |These Jutsus will have a 50 % chance to fail.
            |But of course their power is great.
            |The meteor is just as it sounds. A giant meteor falling down on your opponent.
            |The Susanoo is a giant armor that you'll be able to control. It gives you a sword that few could withstand.
            |The Rasenshuriken is a Rasengan, which is a blue ball that rotates really fast. 
            |The Rasenshuriken adds a shuriken shaped wind around the ball which greatly increases it's power.
            |And finally, the Indra's Arrow. It basically is a giant arrow made out of lightning, said to be the most powerful lightning Jutsu
            |So which will it be?
            [Meteor, Susanoo, Rasenshuriken, Indra's Arrow]
        """.trimIndent())
        val chosenJutsu4 = readLine()
        if (chosenJutsu4 == "Meteor") {
            player.fourthPlayerJutsu = Jutsu("Meteor", 50)
        } else if(chosenJutsu4 == "Susanoo") {
            player.fourthPlayerJutsu = Jutsu("Susanoo", 51)
        } else if(chosenJutsu4 == "Rasenshuriken") {
            player.fourthPlayerJutsu = Jutsu("Rasenshuriken", 52)
        } else if(chosenJutsu4 == "Indra's Arrow") {
            player.fourthPlayerJutsu = Jutsu("Indra's Arrow", 52)
        } else {
            println("|You didn't enter the correct answer. Please try again.")
            level4End(player)
        }
        println("""
            |You've chosen ${player.fourthPlayerJutsu.jutsuName}")
            |${player.fourthPlayerJutsu}
            |Your previous Jutsus will also get +5 damage")
            |And your health is increased by 10")
        """.trimIndent())
        player.mainPlayerJutsu.damageInflicted = player.mainPlayerJutsu.damageInflicted + 5
        player.secondPlayerJutsu.damageInflicted = player.secondPlayerJutsu.damageInflicted + 5
        player.thirdPlayerJutsu.damageInflicted = player.thirdPlayerJutsu.damageInflicted + 5
        player.hp = player.hp + 10
        println("""
            |${player.mainPlayerJutsu}
            |${player.secondPlayerJutsu}
            |${player.thirdPlayerJutsu}
            |${player.fourthPlayerJutsu}
            ---------------------------------
            |Press enter to continue...
        """.trimIndent())
        readLine()
        level5.choosingDirections(player)
    }

    fun gaaraAttacks(player: Player, gaara: Gaara) {
        val rnds = (1..4).random()
        println("|Gaara attacks you.")
        if (rnds == 1) {
            println("|Gaara uses " + gaara.mainGaaraJutsu.jutsuName + " and inflicts " + gaara.mainGaaraJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - gaara.mainGaaraJutsu.damageInflicted
        } else if (rnds == 2) {
            println("|Gaara uses " + gaara.secondGaaraJutsu.jutsuName + " and inflicts " + gaara.secondGaaraJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - gaara.secondGaaraJutsu.damageInflicted
        } else if (rnds == 3) {
            println("|Gaara uses " + gaara.thirdGaaraJutsu.jutsuName + " and inflicts " + gaara.thirdGaaraJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - gaara.thirdGaaraJutsu.damageInflicted
        } else if (rnds == 4) {
            println("|Gaara uses " + gaara.fourthGaaraJutsu.jutsuName + " and inflicts " + gaara.fourthGaaraJutsu.damageInflicted + " points of damage on you.")
            battleHealth = battleHealth - gaara.fourthGaaraJutsu.damageInflicted
        }
    }

}