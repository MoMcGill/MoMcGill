package assignment1;


public class Hotel {
    private String name;
    private Room[] rooms;
    public static void main(String[] args){
        Room[] rooms = {new Room("double"), new Room("queen"), new Room("king")};
        Hotel hotel = new Hotel("Hotel1", rooms);
        System.out.println(hotel.name);
    }
    public Hotel(String name, Room[] rooms){
        this.name= name;
        Room[] copy_rooms= new Room[rooms.length];
        for (int i=0;i< rooms.length;i++){
            Room item= new Room(rooms[i].getType());
            copy_rooms[i]= item;
        }
        this.rooms=copy_rooms;
        }
    public int reserveRoom(String type) {
        if (this.rooms.length ==0){
            throw new IllegalArgumentException("This is an empty hotel");
        }
        Room room1= this.rooms[0].findAvailableRoom(this.rooms, type);
        if (room1 == null){
            throw new IllegalArgumentException("This is not a valid room type");
        }
        room1.changeAvailability();
        return room1.getPrice();
    }
    public boolean cancelRoom(String type){
        if (rooms.length ==0){
            throw new IllegalArgumentException("This is an empty hotel");
        }
        return this.rooms[0].makeRoomAvailable(this.rooms,type);
    }
}

