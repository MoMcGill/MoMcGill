package assignment1;

public class Room {
    private String type;
    private int price;
    private boolean availability;

    public Room(String type) {
        if (type.equalsIgnoreCase("king")) {
            this.type = "king";
            this.price = 15000;
            this.availability =true;
        }
        else if (type.equalsIgnoreCase("queen")) {
            this.type = "queen";
            this.price = 11000;
            this.availability = true;
        }
        else if (type.equalsIgnoreCase("double")) {
            this.type = "double";
            this.price = 9000;
            this.availability =true;
        }
        else {
            throw new IllegalArgumentException("This is not a valid room type");
        }
    }
    public Room(Room r1) {
        this.type = r1.type;
        this.price = r1.price;
        this.availability = r1.availability;

    }
    public String getType(){
        return this.type;
    }
    public int getPrice(){
        return this.price;
    }
    public void changeAvailability(){
        this.availability = !this.availability;
    }
    public static Room findAvailableRoom(Room[] arr_rooms, String room_type) {
        for(int i=0;i< arr_rooms.length;i++) {
            if (arr_rooms[i].type.equalsIgnoreCase(room_type)){
                return arr_rooms[i];
            }
        }
        return null;
    }
    public static boolean makeRoomAvailable(Room[] arr_rooms, String room_type) {
        for(int i=0;i< arr_rooms.length;i++) {
            if (!arr_rooms[i].availability && arr_rooms[i].type.equalsIgnoreCase(room_type)){
                arr_rooms[i].availability = true;
                return true;
            }
        }
        return false;
    }
}
