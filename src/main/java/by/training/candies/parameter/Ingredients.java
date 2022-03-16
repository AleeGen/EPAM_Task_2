package by.training.candies.parameter;

public enum Ingredients {
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

    private String ingredients;

    Ingredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public static Ingredients getIngredients(String ingredients) {
        for (Ingredients ingr : Ingredients.values()) {
            if (ingr.ingredients.equals(ingredients)) {
                return ingr;
            }
        }
        return null;
    }
}
