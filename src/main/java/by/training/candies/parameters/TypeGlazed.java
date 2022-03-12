package by.training.candies.parameters;

public enum TypeGlazed {
    CHOCOLATE("Chololate"),
    FAT("Fat"),
    CARAMEL("Caramel"),
    DAIRY("Dairy"),
    WHITE("White"),
    SUGAR("Sugar"),
    MISSING;   //// TODO: 12.03.2022 как указать в xsd пустое значение?
    private String type;

    TypeGlazed() {
    }

    TypeGlazed(String type) {
        this.type = type;
    }

    public static TypeGlazed getTypeGlazed(String typeGlazed) {
        for (TypeGlazed glazed : TypeGlazed.values()) {
            if (glazed.type.equals(typeGlazed)) {
                return glazed;
            }
        }
        return null;
    }
}
