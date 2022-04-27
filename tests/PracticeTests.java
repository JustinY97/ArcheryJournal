import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.time.Instant;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PracticeTests {

    Practice practice = new Practice("Test Practice", 10, 3);
    static Date now = Date.from(Instant.now());

    @Test
    public void endArrayTest(){
        Integer[] test = {10, 9, 8};
        practice.addEnd(1, test);
        HashMap<String, Double> details = practice.endStats(1);
        assertEquals(27, details.get("Sum"));
        assertEquals(9.0, details.get("Average"));
    }

    @Test
    public void titleTest(){
        assertEquals("Test Practice", practice.getTitle());
    }

    @Test
    public void setDateTest(){
        practice.setDate(now);
        assertEquals(now, practice.getDate());
    }
    @Test
    public void getLocationTest(){
        practice.setLocation("Practice Range #3");
        assertEquals("Practice Range #3", practice.getLocation());
    }
}
