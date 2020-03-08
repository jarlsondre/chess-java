package midtsemesterforelesning;

import java.util.ArrayList;
import java.util.Collection;

public class Room implements Comparable<Room>{

    private boolean available ;
    private boolean clean;
    private int floor;
    private int roomnumber;

    // Oppgave 1B
    private Guest guest;

    //Collection - vi har ingen grunn til å hente bookings på index eller sortere bookingsene
    private Collection<Booking> bookings = new ArrayList<Booking>();

    public Room(boolean available, boolean clean, int floor, int roomnumber) {

        this.available = available;
        this.clean = clean;
        this.floor = floor;
        if (!validateRoomNumber(roomnumber)) {
            throw new IllegalArgumentException("Not a valid room number for this floor");
        }
        this.roomnumber = roomnumber;
    }



    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public int getFloor() {
        return floor;
    }


    public int getRoomnumber() {
        return roomnumber;
    }
    // Oppgave 1A
    private boolean validateRoomNumber(int roomnumber) {
        return Integer.toString(roomnumber).startsWith(Integer.toString(floor));

    }
    // Oppgave AA
    public void setRoomnumber(int roomnumber) {
        if (!validateRoomNumber(roomnumber)) {
            throw new IllegalArgumentException("Not a valid roomnumber for this floor");
        }
        this.roomnumber = roomnumber;

    }

    // Oppgave 2A
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    // Oppgave 2B
    public boolean hasBooking(Booking booking) {
        return bookings.contains(booking);
    }
    // Oppgave 2B
    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    @Override
    public int compareTo(Room o) {
        return this.roomnumber - o.getRoomnumber();
    }


    // Oppgave 1B)
    public void setGuest(Guest guest) {

        // Bruker samme monster her
        Guest oldGuest = this.guest;
        this.guest = guest;
        if (oldGuest != null && oldGuest.getRoom() == this) {
            oldGuest.changeRoom(null);
        }
        if (this.guest != null && this.guest.getRoom() != this) {
            this.guest.changeRoom(this);
        }
    }

    public Guest getGuest() {
        return guest;
    }
}
