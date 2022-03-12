package by.training.candies.entity;


import by.training.candies.parameters.Ingredients;
import by.training.candies.parameters.Production;
import by.training.candies.parameters.Value;

import java.time.LocalDate;
import java.util.*;

public abstract class AbstractCandies {  //// TODO: 12.03.2022 использовать Builder
    private long id;
    private String name;
    private LocalDate dateManufacture;
    private LocalDate dateExpiration;

    private Production production;
    private Set<Ingredients> ingredients;  //// TODO: 12.03.2022 как отобразить множество в xsd?
    private Value value;


    AbstractCandies(long id, String name, Production production, Set<Ingredients> ingredients, Value value, LocalDate dateManufacture, LocalDate bestBeforeDate) {
        this.id = id;
        this.name = name;
        this.production = production;
        this.ingredients = ingredients;
        this.value = value;
        this.dateManufacture = dateManufacture;
        this.dateExpiration = bestBeforeDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Production getProduction() {
        return production;
    }

    public Set<Ingredients> getIngredients() {
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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public void setIngredients(Set<Ingredients> ingredients) {
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
        AbstractCandies that = (AbstractCandies) o;
        return id == that.id && Objects.equals(name, that.name) && production == that.production && Objects.equals(ingredients, that.ingredients) && Objects.equals(value, that.value) && Objects.equals(dateManufacture, that.dateManufacture) && Objects.equals(dateExpiration, that.dateExpiration);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this});
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
