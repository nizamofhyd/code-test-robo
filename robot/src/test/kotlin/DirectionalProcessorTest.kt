import component.Position
import constants.Direction
import domain.DirectionalInstructionProcessor
import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals

class DirectionalProcessorTest {

    var mockPosition = Position(0, 0)
    var mockBoundary = Position(0, 0)
    var mockDirection = Direction.EAST

    @Test(expected = IllegalArgumentException::class)
    fun testInstructionLength() {
        val instructionProcessor = DirectionalInstructionProcessor(mockPosition, mockDirection, mockBoundary)

        instructionProcessor.processInstructions(
                "RFFFRGSGFSAAGASDGASDGAGADGASDGADGADSGADSGADGADGADGADGASDGADGADGAGADGSDGEWQETWE" +
                        "GWEHGASDGASDGRFFFRGSGFSAAGASDGASDGAGADGASDGADGADSGADSGADGADGADGADGASDGADGADGAGADGSDGEWQETWEGWEHGASDGASDG",
                emptyArray())
    }

    @Test
    fun testInstructions1() {
        mockBoundary = Position(5, 3)
        mockPosition = Position(1, 1)
        mockDirection = Direction.EAST
        val instructionProcessor = DirectionalInstructionProcessor(mockPosition, mockDirection, mockBoundary)


        instructionProcessor.processInstructions("RFRFRFRF", emptyArray())

        println("x: ${instructionProcessor.position().x}, y:${instructionProcessor.position().y}")
        println(instructionProcessor.direction())
        assertEquals(1, instructionProcessor.position().x)
        assertEquals(1, instructionProcessor.position().y)
    }

    @Test
    fun testInstructions2() {

        mockBoundary = Position(5, 3)
        mockPosition = Position(3, 2)
        mockDirection = Direction.NORTH
        val instructionProcessor = DirectionalInstructionProcessor(mockPosition, mockDirection, mockBoundary)

        instructionProcessor.processInstructions("FRRFLLFFRRFLL", emptyArray())

        println("x: ${instructionProcessor.position().x}, y:${instructionProcessor.position().y}")
        println(instructionProcessor.direction())
        assertEquals(3, instructionProcessor.position().x)
        assertEquals(3, instructionProcessor.position().y)
    }

    @Test
    fun testInstruction3() {

        mockBoundary = Position(5, 3)
        mockPosition = Position(0, 3)
        mockDirection = Direction.WEST
        val instructionProcessor = DirectionalInstructionProcessor(mockPosition, mockDirection, mockBoundary)


        instructionProcessor.processInstructions("LLFFFLFLFL", Array(1) {
            Position(3, 4)
        })

        println("x: ${instructionProcessor.position().x}, y:${instructionProcessor.position().y}")
        println(instructionProcessor.direction())
        assertEquals(2, instructionProcessor.position().x)
        assertEquals(3, instructionProcessor.position().y)
    }
}