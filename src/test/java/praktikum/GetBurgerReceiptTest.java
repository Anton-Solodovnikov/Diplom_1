package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class GetBurgerReceiptTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    private String mockBunName;
    private float mockBunPrice;
    private IngredientType mockIngredientType;
    private String mockIngredientName;
    private float mockIngredientPrice;

    public GetBurgerReceiptTest(String mockBunName, float mockBunPrice, IngredientType mockIngredientType, String mockIngredientName, float mockIngredientPrice) {
        this.mockBunName = mockBunName;
        this.mockBunPrice = mockBunPrice;
        this.mockIngredientType = mockIngredientType;
        this.mockIngredientName = mockIngredientName;
        this.mockIngredientPrice = mockIngredientPrice;
    }
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"black bun", 100F, SAUCE, "sour cream", 200F},
                {"white bun", 200.50F, FILLING, "sausage", 300.50F}
        };
    }
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(mockBunName);
        Mockito.when(bun.getPrice()).thenReturn(mockBunPrice);
        Mockito.when(ingredient.getType()).thenReturn(mockIngredientType);
        Mockito.when(ingredient.getName()).thenReturn(mockIngredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(mockIngredientPrice);
        String expectedReceipt = String.format("(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %f%n",
                bun.getName(),
                ingredient.getType().toString().toLowerCase(),
                ingredient.getName(),
                bun.getName(),
                burger.getPrice());
        assertEquals("Неверный рецепт",expectedReceipt, burger.getReceipt());
    }
}
