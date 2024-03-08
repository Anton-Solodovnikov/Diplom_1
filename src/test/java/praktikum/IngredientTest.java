package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100F},
                {FILLING,"dinosaur", 200.50F},
        };
    }
    @Test
    public void createIngredientTest() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals("Неверный тип ингредиента", type, ingredient.getType());
        assertEquals("Неверное имя ингредиента", name, ingredient.getName());
        assertEquals("Неверная цена ингредиента", price, ingredient.getPrice(), 0.0F);
    }
}
