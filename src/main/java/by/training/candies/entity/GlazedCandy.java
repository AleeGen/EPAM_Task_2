package by.training.candies.entity;

import java.time.LocalDate;
import java.util.Set;

public class GlazedCandy extends AbstractCandy {
    private TypeGlazed glazed;
    private Filling filling;

    public GlazedCandy() {
    }

    public GlazedCandy(String id, String name, Production production, Set<Ingredient> ingredients, Value value, LocalDate dateManufacture, LocalDate bestBeforeDate, TypeGlazed glazed, Filling filling) {
        super(id, name, production, ingredients, value, dateManufacture, bestBeforeDate);
        this.glazed = glazed;
        this.filling = filling;
    }

    public TypeGlazed getTypeGlazed() {
        return glazed;
    }

    public void setTypeGlazed(TypeGlazed glazed) {
        this.glazed = glazed;
    }

    public Filling getFilling() {
        return filling;
    }

    public void setFilling(Filling filling) {
        this.filling = filling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || !super.equals(o)) return false;
        GlazedCandy that = (GlazedCandy) o;
        return glazed == that.glazed && filling == that.filling;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + glazed.hashCode() + filling.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().append("GlazedCandy{")
                .append(super.toString()).append(", glazed=")
                .append(glazed).append(", filling=")
                .append(filling).append('}').toString();
    }
}
