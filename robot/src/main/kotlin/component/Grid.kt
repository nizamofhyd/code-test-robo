package component

class Grid(private val gridBoundary: Position) {

    private var robotsLostPositions = emptyArray<Position>()

    fun lostRobotsPositions(): Array<Position> {
        return robotsLostPositions
    }

    fun updateLostRobotPosition(lostPosition: Position) {
        robotsLostPositions = robotsLostPositions.plusElement(lostPosition)
    }
}