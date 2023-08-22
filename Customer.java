package assignment1;

public class Customer {
    private String name;
    private int balance;
    private Basket basket;
    public Customer(String name,int balance){
        this.name=name;
        this.balance=balance;
        Basket b1= new Basket();
        this.basket=b1;
    }
    public String getName(){
        return this.name;
    }
    public int getBalance(){
        return this.balance;
    }
    public Basket getBasket(){
        return this.basket;
    }
    public int addFunds(int add_cents){
        if (add_cents <0){
            throw new IllegalArgumentException("Number has to be positive");
        }
        else{
            this.balance+=add_cents;
            return this.balance;
        }
    }
    public int addToBasket(Reservation res){
        try{
            return this.basket.add(res);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Invalid input");
        }
    }
    public int addToBasket(Hotel hotel,String type, int nights, boolean breakfast){
        if (breakfast == true){
            BnBReservation BnB= new BnBReservation(this.getName(), hotel, type,nights);
            try{
                return this.basket.add(BnB);
            }
            catch(Exception e){
                throw new IllegalArgumentException("Invalid input");
            }
        }
        else{
            HotelReservation hres= new HotelReservation(this.getName(), hotel, type,nights);
            try{
                return this.basket.add(hres);
            }
            catch(Exception e){
                throw new IllegalArgumentException("Invalid input");
            }
        }
    }
    public int addToBasket(Airport a1, Airport a2){
        FlightReservation f1= new FlightReservation(this.getName(),a1,a2);
        try{
            return this.basket.add(f1);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Reservation not added");
        }
    }
    public boolean removeFromBasket(Reservation res){
        try{
            return this.basket.remove(res);
        }
        catch(Exception e) {
            throw new IllegalArgumentException("Reservation not added");
        }
    }
    public int checkOut(){
        if (this.balance < this.basket.getTotalCost()){
            throw new IllegalStateException();
        }
        else{
            this.balance= this.getBalance() - this.basket.getTotalCost();
            this.basket.clear();
            return this.getBalance();
        }
    }
}
