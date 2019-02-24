package domain

import component.Position

interface InstructionProcessor {

    fun processInstructions(instructions: String, ignorePositions: Array<Position>)

    fun position(): Position

    fun direction(): String

    fun isRobotLost(): Boolean

    fun robotsLostPosition(): Position
}