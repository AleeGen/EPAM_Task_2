package by.training.candies.builder;

import by.training.candies.entity.AbstractCandy;
import by.training.candies.exception.CustomException;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBuilderCandies {
    protected Set<AbstractCandy> candies;

    protected AbstractBuilderCandies() {
        candies = new HashSet<>();
    }

    protected AbstractBuilderCandies(Set<AbstractCandy> candies) {
        this.candies = candies;
    }

    public Set<AbstractCandy> getCandies() {
        return candies;
    }

    public abstract void buildSetCandies(String filename) throws CustomException;
}
