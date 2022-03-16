package by.training.candies.parameter;

public enum Production {
    IDEAL("Ideal"),
    SPARTAK("Spartak"),
    GOOD_NEW("Good new"),
    VITROOM("Vitroom"),
    VESTA("Vesta"),
    KOMMUNARKA("Kommunarka"),
    SMAK("Smak"),
    RAIPO("Raipo");
    private String production;

    Production(String production) {
        this.production = production;
    }

    public static Production getTypeProduction(String typeProduction) {
        for (Production production : Production.values()) {
            if (production.production.equals(typeProduction)) {
                return production;
            }
        }
        return null;
    }
}
