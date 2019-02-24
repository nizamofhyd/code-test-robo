package component

data class Position constructor(var x: Int, var y: Int) {
    init {
        if (x > 50 || y > 50) {
            throw IllegalArgumentException("Maximum value of coordinates can be 50")
        }
    }
}