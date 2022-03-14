package by.training.candies.parameters;

public enum Filling {
    GRILLAGE("Grillage"),
    SOUFFLE("Souffle"),
    FONDANT("Fondant"),
    WITH_PRALINE("With praline"),
    WITH_LIQUOR("With liquor"),
    JELLY("Jelly"),
    TRUFFLES("Truffles"),
    WITH_PUFFED_RICE("With puffed rice");
    private String filling;

    Filling(String filling) {
        this.filling = filling;
    }

    public static Filling getType(String filling) {
        for (Filling fil : Filling.values()) {
            if (fil.filling.equals(filling)) {
                return fil;
            }
        }
        return null;
    }
}
