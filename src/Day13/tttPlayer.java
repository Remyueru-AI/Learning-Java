package Day13;

public class tttPlayer {
    char playerMark;
    private int turnPoint = 0;

    tttPlayer(char playerMark) {
        this.playerMark = playerMark;
    }

    public int getTurnPoint() {
        return turnPoint;
    }

    public void setTurnPoint(int turnPoint) {
        this.turnPoint = turnPoint;
    }
}
