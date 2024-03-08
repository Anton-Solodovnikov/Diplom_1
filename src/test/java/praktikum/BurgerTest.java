package praktikum;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient ingredient2;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        String mockValue = "bunName";
        Mockito.when(bun.getName()).thenReturn(mockValue);
        burger.setBuns(bun);
        assertEquals("Не произошло добавление булки", mockValue, burger.bun.getName());
    }
    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertTrue("Ингредиент не добавлен", burger.ingredients.contains(ingredient));
    }
    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int index = burger.ingredients.indexOf(ingredient);
        burger.removeIngredient(index);
        assertFalse("Ингредиент не удален", burger.ingredients.contains(ingredient));
    }
    @Test
    public void moveIngredientTest() {
        String mockValue = "ingredientName";
        Mockito.when(ingredient.getName()).thenReturn(mockValue);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        int index = burger.ingredients.indexOf(ingredient);
        int newIndex = burger.ingredients.indexOf(ingredient2);
        burger.moveIngredient(index, newIndex);
        assertEquals(
                "Ингредиент не перемещается", mockValue, burger.ingredients.get(newIndex).getName());
    }
    @Test
    public void getPriceTest() {
        float bunPrice = 100F;
        float ingredientPrice = 300F;
        float expectBurgerPrice = 800F;
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        assertEquals("Цена формируется неверно", expectBurgerPrice, burger.getPrice(), 0.0);
    }
}
