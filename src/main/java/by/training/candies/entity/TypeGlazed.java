package by.training.candies.entity;

public enum TypeGlazed {
    CHOCOLATE("Chololate"),
    FAT("Fat"),
    CARAMEL("Caramel"),
    DAIRY("Dairy"),
    WHITE("White"),
    SUGAR("Sugar"),
    MISSING;

    private final String type;

    TypeGlazed() {
        type = "";
    }


    TypeGlazed(String type) {
        this.type = type;
    }


    public static TypeGlazed getType(String typeGlazed) {
        for (TypeGlazed glazed : TypeGlazed.values()) {
            if (glazed.type.equals(typeGlazed)) {
                return glazed;
            }
        }
        return MISSING;
    }
}
