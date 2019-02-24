import component.Position
import org.junit.Test

class PositionTest {


    @Test(expected = IllegalArgumentException::class)
    fun positionX() {

        val position = Position(52, 0)

    }

    @Test(expected = IllegalArgumentException::class)
    fun positionY() {

        val position = Position(49, 90)

    }
}