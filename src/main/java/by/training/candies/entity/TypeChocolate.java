package by.training.candies.entity;

public enum TypeChocolate {
    BITTER("Bitter"),
    LACTIC("Lactic"),
    WHITE("White");
    private final String type;

    TypeChocolate(String type) {
        this.type = type;
    }

    public static TypeChocolate getType(String type) {
        for (TypeChocolate typeChocolate : TypeChocolate.values()) {
            if (typeChocolate.type.equals(type)) {
                return typeChocolate;
            }
        }
        return null;
    }
}
