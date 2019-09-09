package hotel.kealifornia.demo.models;

import java.time.LocalDate;

public class Reservation {

    private int reservationId;
    private LocalDate checkInDay;
    private LocalDate checkOutDay;
    private Guest guest;
    private Room room;
    private double total;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getCheckInDay() {
        return checkInDay;
    }

    public void setCheckInDay(LocalDate checkInDay) {
        this.checkInDay = checkInDay;
    }

    public LocalDate getCheckOutDay() {
        return checkOutDay;
    }

    public void setCheckOutDay(LocalDate checkOutDay) {
        this.checkOutDay = checkOutDay;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", checkInDay=" + checkInDay +
                ", checkOutDay=" + checkOutDay +
                ", guest=" + guest +
                ", room=" + room +
                ", total=" + total +
                '}';
    }
}
