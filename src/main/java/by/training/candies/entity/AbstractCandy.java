package by.training.candies.entity;


import java.time.LocalDate;
import java.util.*;

public abstract class AbstractCandy {
    private String id;
    private String name;
    private Production production;
    private LocalDate dateManufacture;
    private LocalDate dateExpiration;
    private Set<Ingredient> ingredients;
    private Value value;

    AbstractCandy() {
        ingredients = new HashSet<>();
        value = new Value();
    }

    AbstractCandy(String id, String name, Production production, Set<Ingredient> ingredients, Value value, LocalDate dateManufacture, LocalDate bestBeforeDate) {
        this.id = id;
        this.name = name;
        this.production = production;
        this.ingredients = ingredients;
        this.value = value;
        this.dateManufacture = dateManufacture;
        this.dateExpiration = bestBeforeDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Production getProduction() {
        return production;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Value getValue() {
        return value;
    }

    public LocalDate getDateManufacture() {
        return dateManufacture;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public void setDateManufacture(LocalDate dateManufacture) {
        this.dateManufacture = dateManufacture;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCandy that = (AbstractCandy) o;
        return id.equals(that.id) && Objects.equals(name, that.name) && production == that.production && Objects.equals(ingredients, that.ingredients) && Objects.equals(value, that.value) && Objects.equals(dateManufacture, that.dateManufacture) && Objects.equals(dateExpiration, that.dateExpiration);
    }

    @Override
    public int hashCode() {
        return id.hashCode() + name.hashCode() + production.hashCode()
                + dateManufacture.hashCode() + dateExpiration.hashCode()
                + ingredients.hashCode() + value.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().append("id=").append(id)
                .append(", name='").append(name).append('\'')
                .append(", production=").append(production)
                .append(", ingredients=").append(ingredients)
                .append(", value=").append(value).append(", dateManufacture=")
                .append(dateManufacture).append(", bestBeforeDate=")
                .append(dateExpiration).toString();
    }
}
