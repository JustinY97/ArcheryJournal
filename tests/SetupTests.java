import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetupTests {
    Setup testSetup = new Setup("Test Setup");
    Scanner scan = new Scanner(System.in);
    @Test
    public void idTest(){
        assertEquals("Test Setup", testSetup.getId());
        String newID = "Test Setup";
        testSetup.setId(newID);
        assertEquals(newID, testSetup.getId());
    }

    @Test
    public void manufacturerTest(){
        testSetup.setManufacturer("Mathews");
        assertEquals("Mathews", testSetup.getManufacturer());
    }

    @Test
    public void modelTest(){
        testSetup.setModel("Apex 8");
        assertEquals("Apex 8", testSetup.getModel());
    }

    @Test
    public void drawlengthTest(){
        testSetup.setDrawLength(29.5);
        assertEquals(29.5, testSetup.getDrawLength());
    }

    @Test
    public void poundageTest(){
        testSetup.setPoundage(60.0);
        assertEquals(60.0, testSetup.getPoundage());
    }
}
