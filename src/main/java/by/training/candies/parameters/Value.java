package by.training.candies.parameters;

import java.util.Arrays;

public class Value {
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int energy;

    public Value() {
        proteins = 0;
        fats = 0;
        carbohydrates = 0;
        energy = 0;
    }

    public Value(int proteins, int fats, int carbohydrates, int energy) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
        this.energy = energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return proteins == value.proteins && fats == value.fats && carbohydrates == value.carbohydrates && energy == value.energy;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(new int[]{proteins, fats, carbohydrates, energy});
    }

    @Override
    public String toString() {
        return new StringBuilder().append("Value{")
                .append("proteins=").append(proteins)
                .append(", fats=").append(fats)
                .append(", carbohydrates=").append(carbohydrates)
                .append(", energy=").append(energy)
                .append('}').toString();
    }
}
