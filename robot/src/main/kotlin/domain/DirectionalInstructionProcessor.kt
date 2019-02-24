package domain

import component.Position
import constants.Direction

class DirectionalInstructionProcessor(var position: Position, var direction: Direction, val boundary: Position) : InstructionProcessor {
    private var lost: Boolean = false
    private var lostPosition = Position(0, 0)
    private lateinit var ignorePositions: Array<Position>

    override fun processInstructions(instructions: String, robotsLostPositions: Array<Position>) {
        if (instructions.length > 100) {
            throw IllegalArgumentException("Maximum length of instructions is 100")
        }
        ignorePositions = robotsLostPositions
        instructions.forEach {
            when (it) {
                'L', 'R' -> changeOrientation(it)
                'F' -> changePosition(it)
                else -> {
                    println("Invalid instruction $it")
                }
            }
        }

    }

    override fun position(): Position {
        return position
    }

    override fun direction(): String {
        return if (lost) direction.name.elementAt(0) + " " + Direction.LOST.name else "" + direction.name.elementAt(0)
    }

    override fun isRobotLost(): Boolean {
        return lost
    }

    override fun robotsLostPosition(): Position {
        return lostPosition
    }

    private fun changeOrientation(orientationChar: Char) {
        when (orientationChar) {
            'L' -> if (direction.index > 1) direction = Direction.values().get(direction.index - 1) else direction = Direction.WEST
            'R' -> if (direction.index == (Direction.values().size - 1)) direction = Direction.NORTH else direction = Direction.values().get(direction.index + 1)
        }
    }

    private fun changePosition(char: Char) {
        when (char) {
            'F' -> {
                when (direction) {
                    Direction.NORTH -> {
                        if (!isYToBeIgnored(position.y)) {
                            ++position.y
                            checkYBoundary()
                        }
                    }
                    Direction.SOUTH -> {
                        if (!isYToBeIgnored(position.y)) {
                            --position.y
                            checkYBoundary()
                        }
                    }
                    Direction.EAST -> {
                        if (!isXToBeIgnored(position.x)) {
                            ++position.x
                            checkXBoundary()
                        }
                    }
                    Direction.WEST -> {
                        if (!isXToBeIgnored(position.x)) {
                            --position.x
                            checkXBoundary()
                        }
                    }
                    else -> println("Invalid direction found !!")
                }
            }
        }
    }

    private fun checkYBoundary() {
        if (boundary.y < position.y && !lost) {
            lost = true
            lostPosition.x = position.x
            lostPosition.y = position.y
        }
    }

    private fun checkXBoundary() {
        if (boundary.x < position.x && !lost) {
            lost = true
            lostPosition.x = position.x
            lostPosition.y = position.y
        }
    }

    private fun isYToBeIgnored(y: Int): Boolean {
        ignorePositions.forEach {
            if (it.y == y + 1) return true
        }
        return false
    }

    private fun isXToBeIgnored(x: Int): Boolean {
        ignorePositions.forEach {
            if (it.x == x + 1) return true
        }
        return false
    }

}