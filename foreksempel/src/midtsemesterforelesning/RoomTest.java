package midtsemesterforelesning;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class RoomTest extends TestCase {

    @Before
    public void setup() {
        // Her kan vi gjøre klar eventuelle objekter vi skal bruke ved hver test
    }

    @Test
    public void testValidRoomNumber() {
        Room room = new Room(true, true, 2, 204);
        assertEquals(204, room.getRoomnumber());
    }

    @Test
    public void testChangeRoomNumber() {
        Room room = new Room(true, true, 2, 204);
        assertEquals(204, room.getRoomnumber());
        room.setRoomnumber(205);
        assertEquals(205, room.getRoomnumber());

    }

    @Test
    public void testInvalidRoomNumber() {
        try {
            Room room = new Room(true, true, 2, 305);
            fail();
        }
        catch (IllegalArgumentException e) {

        }
    }
}
