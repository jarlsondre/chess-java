package midtsemesterforelesning;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Hotel implements Iterable<Room>{


    private String name;
    // Oppgave 1C
    private List<Room> rooms = new ArrayList<Room>();

    //Oppgave 2C
    private List<Booking> bookings = new ArrayList<>();



    public Hotel(String name) {
        this.name = name;
    }

    // Oppgave 1C)
    public int getNumberofRooms() {
        return rooms.size();
    }


    // Går ut ifra at et nytt rom alltid er ledig og tilgjengelig. Oppgave 1C
    public void addRoom(int floor, int roomNumber) {
        Room room = new Room(true, true, floor, roomNumber);
        rooms.add(room);
    }
    // Oppgave 1C
    public int getNumberOfAvailableRooms(){

        int count = 0;
        for (Room r: rooms) {
            if (r.isAvailable()) {
                count += 1;
            }
        }
        // return count;
        // Med streams. midtsemesterforberedelse.Room::isAvailable blir det samme som (room -> room.isAvailable())
        return (int) rooms.stream().filter(Room::isAvailable).count();
    }

    // Oppgave 2C)
    public boolean addBooking(Booking booking) {
        // Vi må sjekke om rommet er ledige på denne datoen
        Date date = booking.getDate();
        Room room = booking.getRoom();

        // Sjekker at rommet faktisk er på dette hotellet
        if (!rooms.contains(room)) {
            return false;
        }

        // Vi får tak i alle bookingene tilknyttet dette rommet
        // Vi benytter av oss teknikken "Uskyldig inntil motsatte er bevist"
        boolean roomisAvailable = true;
        for(Booking book: bookings) {
            if (book.getRoom() == room) {
                // Deretter sjekker vi om bookingen gjelder datoen vi prøver å booke på
                if(isSameDay(book.getDate(), date)) {
                    roomisAvailable = false;
                }
            }
        }
        if (roomisAvailable) {
            bookings.add(booking);
            return true;
        }
        return false;
    }

    // Oppgave 2D
    public boolean removeBooking(Booking booking) {
        if (booking.isFlexible()) {
            bookings.remove(booking);
            // Må og opprettholde gyldige verdier for rommet og gjesten
            booking.cancelBooking();
            return true;
        }
        return false;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        LocalDate localDate1 = date1.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate localDate2 = date2.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return localDate1.isEqual(localDate2);
    }


    // Oppgave 2E og 4
    public boolean checkin(Guest guest, Date date) {
        // Vi gjør dette med streams - får alle bookingsene for denne gjesten, og sjekker deretter om noen matcher på denne datoen
        boolean checkedIn =  bookings.stream().filter(booking -> booking.getGuest() == guest).map(booking -> booking.getDate()).anyMatch(d -> isSameDay(d, date));

        // Oppgave 4
        if (guest.getStatus() != null && checkedIn) {
            System.out.println(guest.getStatus().welcomeGift());
        }
        return checkedIn;

    }

    public Map<Guest, Integer> getNumberOfBookingsPerGuest() {
        // En map hvor vi kan mappe hver gjest til hvor mange bookigner de har
        Map<Guest, Integer>  map = new HashMap<>();
        // Iterer gjennom alle bookinger
        for (Booking b: bookings)
        {
            // Hvis ikke gjesten finnes fra før av, ta 0, hvis ikke ta så mange ganger vi har funnet tidligere
            int bookings = map.getOrDefault(b.getGuest(), 0) + 1;
            map.put(b.getGuest(), bookings);

        }
    return map;

    }

    public List<Room> roomsSortedByRoomNumber() {

        // Vi lager en kopi av listen, slik at ingen kan endre originale lista
        List<Room> roomCopy = new ArrayList(rooms);
        Collections.sort(roomCopy);
        return roomCopy;
    }

    public List<Room> roomsSortedByCleaned() {
        // Vi lager en kopi av listen, slik at ingen kan endre originale lista

        List<Room> roomCopy = new ArrayList(rooms);
        roomCopy.sort(new RoomComparator());
        return roomCopy;
    }

    public List<Room> roomsSortedByAvailability() {
        // Vi lager en kopi av listen, slik at ingen kan endre originale lista

        List<Room> roomCopy = new ArrayList(rooms);
        roomCopy.sort((r1, r2) ->  Boolean.valueOf(r1.isAvailable()).compareTo(r2.isAvailable()));
        return roomCopy;
    }

    // Oppgave 3A
    public void newDay(){
        for (Room room: rooms) {
            if (!room.isAvailable()) {
                room.setClean(false);
            }
        }
        // Med streams
        // rooms.stream().filter(r -> !r.isAvailable()).forEach(room -> room.setClean(false));
    }


    public static void main(String[] args) {
        Room r1 = new Room(true, true, 2, 202);
        Room r2 = new Room(true, true, 1, 101);
        Room r3 = new Room(true, true, 2, 201);
        Hotel hotel = new Hotel("Britannia");
        hotel.addRoom(2, 202);
        hotel.addRoom(1, 101);
        hotel.addRoom(2, 201);
        Guest g1 = new Guest("Vegard");
        Guest g2 = new Guest("Magnus");
        Booking b1 = new Booking(r1, g1, new Date());
        Booking b2 = new Booking(r2, g2, new Date());
        Booking b3 = new Booking(r3, g1, new Date(2020, 3, 9));

        boolean booking1ok = hotel.addBooking(b1);
        boolean booking2ok = hotel.addBooking(b2);
        boolean booking3ok = hotel.addBooking(b3);
        g1.setStatus(new GoldLoyaltuStatus());
        boolean checkInOk1 = hotel.checkin(g1, new Date());
        boolean checkInOk2 = hotel.checkin(g1, new Date(2020, 3, 10));
        Map<Guest, Integer> map = hotel.getNumberOfBookingsPerGuest();
        System.out.println("test done");
    }

    // Oppgave 3C - vi returnerer iteratoren til underliggende listen
    @Override
    public Iterator<Room> iterator() {
        return rooms.iterator();
    }
}
