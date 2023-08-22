package assignment1;

public class FlightReservation extends Reservation {
    private Airport departure;
    private Airport arrival;

    public FlightReservation(String name,Airport departure, Airport arrival) {
        super(name);
        this.departure=departure;
        this.arrival=arrival;
        if (Airport.getDistance(departure,arrival) == 0){
            throw new IllegalArgumentException("This is not a valid room type");
        }
    }
    public int getCost() {
        int fuel_cost=124;
        double distance = 167.52;
        double total_cost=5375;
        total_cost+=this.departure.getFees() + this.arrival.getFees();
        total_cost+= (Airport.getDistance(departure,arrival)/distance)*fuel_cost;
        if (total_cost% ((int)total_cost) ==0.0) {
            return (int) total_cost;
        }
        else{
            return (int) total_cost +1;
        }
    }
    public boolean equals(Object obj){
        if (obj instanceof FlightReservation && this instanceof FlightReservation){
            if (this.reservationName() == ((FlightReservation) obj).reservationName()){
                if (Airport.getDistance(this.departure,((FlightReservation) obj).departure) == 0 && (Airport.getDistance(this.arrival,((FlightReservation) obj).arrival)==0) ){
                    return true;
                }
            }

        }
        return false;

    }
}

