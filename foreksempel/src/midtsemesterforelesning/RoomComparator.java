package midtsemesterforelesning;

import java.util.Comparator;


// Oppgave 3B
public class RoomComparator implements Comparator<Room> {


    @Override
    public int compare(Room o1, Room o2) {
        if (o1.isClean() == o2.isClean()) {
            // Returnrerer da forskjelle på romnummeret
            return o1.getRoomnumber() - o2.getRoomnumber();
        }
        // ? - operatoren er tilsvarende en if-setning, hvor det som kommer etter :  er en del av Else
        return o1.isClean() ? 1 : -1;
    }
}
