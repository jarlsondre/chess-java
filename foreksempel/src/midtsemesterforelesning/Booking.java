package midtsemesterforelesning;

import java.util.Date;

public class Booking {

    private Room room;
    private Guest guest;
    private Date date;
    private boolean flexible;

    public Booking(Room room, Guest guest, Date date, boolean flexible) {
        this.room = room;
        this.guest = guest;
        this.date = date;
        this.flexible = flexible;
    }

    public Booking(Room room, Guest guest, Date date) {
        this.room = room;
        this.guest = guest;
        this.date = date;
        this.flexible = false;
    }

    // Oppgave 2B
    public void changeRoom(Room room) {
        //Passer på at rommet ikke peker på denne bookingen lenger
        this.room.removeBooking(this);
        this.room = room;

        if (!room.hasBooking(this)) {
            room.addBooking(this);
        }
    }

    public Room getRoom() {
        return room;
    }

    public Guest getGuest() {
        return guest;
    }

    public Date getDate() {
        return date;
    }

    public boolean isFlexible() {
        return flexible;
    }

    public void cancelBooking() {
        room.removeBooking(this);
        guest.removeBooking(this);
    }
}
