package assignment1;
public class Airport {
    private int x;
    private int y;
    private int fees;

    public Airport(int x, int y, int fees) {
        this.x = x;
        this.y = y;
        this.fees = fees;
    }
    public int getFees() {
        return this.fees;
    }
    public static int getDistance(Airport a1, Airport a2 ) {
        double distance = Math.pow(Math.pow((a1.x - a2.x),2) + Math.pow((a1.y - a2.y),2),0.5);
        if (distance - (int) distance > 0.0) {
            return (int) distance + 1;
        }
        return (int) distance;
    }
}

