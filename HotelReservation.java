package assignment1;

public class HotelReservation extends Reservation{
    private Hotel h1;
    private String type;
    private int nights;
    private int price;
    public HotelReservation(String name,Hotel h1, String type, int nights){
        super(name);
        this.h1=h1;
        this.type=type;
        this.nights=nights;
        this.h1.reserveRoom(type);
        this.price= this.getCost();
    }
    public int getNumOfNights(){
        return this.nights;
    }
    public int getCost(){
        Room empty= new Room(this.type);
        int price = this.getNumOfNights()*empty.getPrice();
        return price;
    }

    public boolean equals(Object obj) {
        if (obj instanceof HotelReservation && this instanceof HotelReservation){
            if (this.reservationName() == ((HotelReservation) obj).reservationName()){
                if ((this.h1==((HotelReservation) obj).h1)&& (this.type==((HotelReservation) obj).type)){
                    if (this.getNumOfNights()== ((HotelReservation) obj).getNumOfNights()){
                        if (this.price==((HotelReservation) obj).price){
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }
}
