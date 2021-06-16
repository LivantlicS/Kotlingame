class Enemy(val name: String, var hitpoints: Int, var lives: Int) {

    fun takedamage(damage: Int) {
        val remainingHitpoints = hitpoints - damage
        if (remainingHitpoints > 9) {
            hitpoints = remainingHitpoints
            println("$name took $damage points of damage and has $hitpoints left")
        } else {
            $lives -= 1
            println("$name lost a life ")
        }
    }

}