package by.training.candies.builder;

import by.training.candies.entity.AbstractCandy;
import by.training.candies.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractBuilderCandies {
    protected Set<AbstractCandy> candies;

    AbstractBuilderCandies() {
        candies = new HashSet<>();
    }

    public Set<AbstractCandy> getCandies() {
        return candies;
    }

    public abstract void buildSetCandies(String filename);
}
