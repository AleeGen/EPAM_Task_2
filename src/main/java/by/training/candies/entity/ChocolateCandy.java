package by.training.candies.entity;

import by.training.candies.parameters.*;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class ChocolateCandy extends AbstractCandy {

    private Form form;
    private TypeChocolate typeChocolate;

    public ChocolateCandy() {
        super();
    }

    public ChocolateCandy(String id, String name, Production production, Set<Ingredients> ingredients, Value value, LocalDate dateManufacture, LocalDate bestBeforeDate, TypeChocolate typeChocolate, Form form) {
        super(id, name, production, ingredients, value, dateManufacture, bestBeforeDate);
        this.typeChocolate = typeChocolate;
        this.form = form;
    }


    public Form getForm() {
        return form;
    }

    public TypeChocolate getTypeChocolate() {
        return typeChocolate;
    }

    public void setTypeChocolate(TypeChocolate typeChocolate) {
        this.typeChocolate = typeChocolate;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass() || !super.equals(o)) return false;
        if (!super.equals(o)) return false;
        ChocolateCandy that = (ChocolateCandy) o;
        return typeChocolate == that.typeChocolate && form == that.form;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + form.hashCode() + typeChocolate.hashCode();
    }

    @Override
    public String toString() {
        return new StringBuilder().append("ChocolateCandy{")
                .append(super.toString()).append(", typeChocolate=")
                .append(typeChocolate).append(", form=").append(form)
                .append('}').toString();
    }
}
