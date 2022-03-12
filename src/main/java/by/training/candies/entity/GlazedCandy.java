package by.training.candies.entity;

import by.training.candies.parameters.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class GlazedCandy extends AbstractCandies {
    private TypeGlazed glazed;
    private Filling filling;

    public GlazedCandy(long id, String name, Production production, Set<Ingredients> ingredients, Value value, LocalDate dateManufacture, LocalDate bestBeforeDate, TypeGlazed glazed, Filling filling) {
        super(id, name, production, ingredients, value, dateManufacture, bestBeforeDate);
        this.glazed = glazed;
        this.filling = filling;
    }

    public TypeGlazed getGlazed() {
        return glazed;
    }

    public void setGlazed(TypeGlazed glazed) {
        this.glazed = glazed;
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
