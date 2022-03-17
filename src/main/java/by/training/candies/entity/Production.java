package by.training.candies.entity;

public enum Production {
    IDEAL("Ideal"),
    SPARTAK("Spartak"),
    GOOD_NEW("Good new"),
    VITROOM("Vitroom"),
    VESTA("Vesta"),
    KOMMUNARKA("Kommunarka"),
    SMAK("Smak"),
    RAIPO("Raipo");
    private final String typeProduction;

    Production(String typeProduction) {
        this.typeProduction = typeProduction;
    }

    public static Production getTypeProduction(String typeProduction) {
        for (Production prod : Production.values()) {
            if (prod.typeProduction.equals(typeProduction)) {
                return prod;
            }
        }
        return null;
    }
}
