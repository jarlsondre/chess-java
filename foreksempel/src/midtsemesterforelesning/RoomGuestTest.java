package midtsemesterforelesning;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RoomGuestTest extends TestCase {
    Guest guest1 = new Guest("g1");;
    Room room1 = new Room(true, true, 1, 101);
    Room room2 = new Room(true, true, 1, 102);
    Guest guest2  = new Guest("g2");;

    @Before
    public void setup() {

    }
    @Test
    public void testSetRoom(){
        guest1.changeRoom(this.room1);
        assertEquals(room1, guest1.getRoom());
        assertEquals(guest1, room1.getGuest());
        assertNull(room2.getGuest());
    }
    @Test
    public void testChangeRoom(){
        guest1.changeRoom(room1);
        guest1.changeRoom(room2);
        assertEquals(room2, guest1.getRoom());
        assertEquals(guest1, room2.getGuest());
        assertNull(room1.getGuest());
    }
    @Test
    public void testChangeOccupiedRoom(){
        guest1.changeRoom(room1);
        guest2.changeRoom(room2);
        guest1.changeRoom(room2);
        assertEquals(room2, guest1.getRoom());
        assertEquals(guest1, room2.getGuest());
        assertNull(room1.getGuest());
        assertNull(guest2.getRoom());
    }
}
