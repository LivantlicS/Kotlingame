open class Jutsu(val jutsuName: String, var damageInflicted: Int) {
    override fun toString(): String {
        return "$jutsuName inflicts $damageInflicted points of damage".trimIndent()
    }

}

