package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BunTest {
    @Test
    public void createBunTest() {
        String testName = "black bun";
        float testPrice = 100;
        Bun bun = new Bun(testName, testPrice);
        assertEquals("Неверное имя булки", testName, bun.getName());
        assertEquals("Неверная цена булки", testPrice, bun.getPrice(), 0.0);
    }

}
