open class Attack(val AttackName: String, var damageInflicted: Int) {
    override fun toString(): String {
        return "$AttackName inflicts $damageInflicted points of damage".trimIndent()
    }

}