package assignment1;

public class BnBReservation extends HotelReservation{
    public BnBReservation(String name,Hotel h1, String type, int nights){
        super(name,h1,type,nights);
    }

    public int getCost() {
        return super.getCost()+(1000*super.getNumOfNights());
    }
}
