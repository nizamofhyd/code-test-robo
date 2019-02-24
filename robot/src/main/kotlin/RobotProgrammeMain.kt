import component.Grid
import component.Position
import component.Robot
import constants.Direction
import domain.DirectionalInstructionProcessor

fun main(args: Array<String>) {
    println("Running the robots now")

    val gridPosition = Position(5, 3)
    val grid = Grid(gridPosition)

    println("Robot1 launched")
    val robot1 = Robot(DirectionalInstructionProcessor(Position(1, 1), Direction.EAST, gridPosition),
            grid)
    robot1.processInstructions("RFRFRFRF")
    println("x: ${robot1.position().x}, y:${robot1.position().y}")
    println(robot1.direction())

    println("Robot2 launched")
    val robot2 = Robot(DirectionalInstructionProcessor(Position(3, 2), Direction.NORTH, gridPosition),
            grid)
    robot2.processInstructions("FRRFLLFFRRFLL")
    println("x: ${robot2.position().x}, y:${robot2.position().y}")
    println(robot2.direction())

    println("Robot3 launched")
    val robot3 = Robot(DirectionalInstructionProcessor(Position(0, 3), Direction.WEST, gridPosition),
            grid)
    robot3.processInstructions("LLFFFLFLFL")
    println("x: ${robot3.position().x}, y:${robot3.position().y}")
    println(robot3.direction())

}