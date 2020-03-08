package midtsemesterforelesning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Guest {

    private String name;

    private Room room ;
    // Oppgave 2A
    private Collection<Booking> bookings = new ArrayList<>();

    // Oppgave 4
    private HotelLoyaltyStatus status;

    public Guest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    // Oppgave 2A
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    // Oppgave 2A
    public void addBooking(Date date, Room room) {
        Booking booking = new Booking(room, this, date);
        addBooking(booking); //Vi ønsker alltid å gjenbruke metoder vi har skrevet tidligere
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public String toString() {
        return name;
    }
    // Oppgave 4
    public void setStatus(HotelLoyaltyStatus status) {
        this.status = status;
    }

    public HotelLoyaltyStatus getStatus() {
        return status;
    }



    public void changeRoom(Room room) {
        Room oldRoom = this.room;
        this.room = room;
        // Sjekker at gamle rommet ikke har denne gjesten
        if (oldRoom != null & oldRoom.getGuest() == this) {
            oldRoom.setGuest(null);
        }
        // Oppdaterer nye rommet om det trengs
        if (room != null & this.room.getGuest() != this) {
            this.room.setGuest(this);
        }

    }

    public Room getRoom() {
        return room;
    }
}
