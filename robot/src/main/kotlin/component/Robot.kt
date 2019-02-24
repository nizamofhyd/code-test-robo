package component

import domain.InstructionProcessor

class Robot(private val processor: InstructionProcessor,
            private val grid: Grid) {

    fun processInstructions(instructions: String) {
        processor.processInstructions(instructions, grid.lostRobotsPositions())
        if (processor.isRobotLost()){
            grid.updateLostRobotPosition(processor.robotsLostPosition())
        }
    }

    fun position(): Position {
        return processor.position()
    }

    fun direction(): String {
        return processor.direction()
    }
}