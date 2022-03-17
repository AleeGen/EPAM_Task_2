package by.training.candies.entity;

public enum Ingredient {
    WATER("Water"),
    SUGAR("Sugar"),
    VANILLIN("Vanillin"),
    FRUCTOSE("Fructose"),
    STARCH("Starch"),
    BUTTER("Butter"),
    VEGETABLE_FAT("Vegetable fat"),
    MILK("Milk"),
    WAFER("Wafer"),
    FLOUR("Flour"),
    SALT("Salt");

    private final String ingredients;

    Ingredient(String ingredients) {
        this.ingredients = ingredients;
    }

    public static Ingredient getIngredients(String ingredients) {
        for (Ingredient ingr : Ingredient.values()) {
            if (ingr.ingredients.equals(ingredients)) {
                return ingr;
            }
        }
        return null;
    }
}
