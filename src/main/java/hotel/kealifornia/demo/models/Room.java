package hotel.kealifornia.demo.models;

import java.util.List;

public class Room {

    private int roomId;
    private String name;
    private double price;
    private int numOfGuests;
    private int hotelId;
    private List<Reservation> reservations;

    public Room() {
    }

    public Room(int roomId, String name, double price, int numOfGuests, int hotelId) {
        this.roomId = roomId;
        this.name = name;
        this.price = price;
        this.numOfGuests = numOfGuests;
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumOfGuests() {
        return numOfGuests;
    }

    public void setNumOfGuests(int numOfGuests) {
        this.numOfGuests = numOfGuests;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", numOfGuests=" + numOfGuests +
                ", hotelId=" + hotelId +
                ", reservations=" + reservations +
                '}';
    }
}
