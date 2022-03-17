package by.training.candies.entity;

public enum Filling {
    GRILLAGE("Grillage"),
    SOUFFLE("Souffle"),
    FONDANT("Fondant"),
    WITH_PRALINE("With praline"),
    WITH_LIQUOR("With liquor"),
    JELLY("Jelly"),
    TRUFFLES("Truffles"),
    WITH_PUFFED_RICE("With puffed rice");
    private final String fill;

    Filling(String fill) {
        this.fill = fill;
    }

    public static Filling getType(String fill) {
        for (Filling fil : Filling.values()) {
            if (fil.fill.equals(fill)) {
                return fil;
            }
        }
        return null;
    }
}
