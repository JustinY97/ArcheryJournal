import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompetitionsTests {

    static Competition competition = new Competition("Test Comeptition", 10, 3);
    static Date now = Date.from(Instant.now());

    @BeforeAll
    public static void insertCompetitorInfo(){
        competition.addCompetitorInfo("Jacob", 298);
        competition.addCompetitorInfo("James", 299);
        competition.addCompetitorInfo("Tyler", 279);
        competition.ends = new Integer[competition.numEnds][competition.arrowsPerEnd];
        competition.setDate(now);


    }

    @Test
    public void checkDate(){
        assertEquals(now, competition.getDate());
    }

    @Test
    public void addCompetitorTest(){
        competition.addCompetitorInfo("Justin", 300);
        assertTrue(this.competition.competitorsScores.size() == 4);
    }

    @Test
    public void changeTitleTest(){
        competition.changeTitle("Test Changed");
        assertEquals("Test Changed", competition.getTitle());
    }

    @Test
    public void detailsTest(){
        competition.printDetails();
    }

    @Test
    public void setLocationTest(){
        competition.setLocation("Vegas");
        assertEquals("Vegas", competition.getLocation());
    }

    @Test
    public void scoreCalculationTest(){
        Integer[] scores = new Integer[]{10, 9, 10};
        competition.addEnd(1, scores);
        competition.addEnd(2, scores);
        competition.addEnd(3, scores);
        competition.addEnd(4, scores);
        competition.addEnd(5, scores);
        competition.addEnd(6, scores);
        competition.addEnd(7, scores);
        competition.addEnd(8, scores);
        competition.addEnd(9, scores);
        competition.addEnd(10, scores);
        competition.calculateScore();
        assertEquals(290, competition.getScore());
    }

    @Test
    public void standingTest(){
        competition.setStanding(2);
        assertEquals(2, competition.getStanding());
    }

    /*@Test
    public void rankingTest(){
        competition.printRanks();
        assertTrue(true, String.valueOf(true));
    }*/


}
