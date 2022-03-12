package by.training.candies;

import by.training.candies.entity.*;
import by.training.candies.parameters.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        String name1 = "candiGlazed_1";
        Production production1 = Production.getTypeProduction("Kommunarka");
        Set<Ingredients> ingredients1 = new HashSet<>();
        ingredients1.add(Ingredients.SUGAR);
        ingredients1.add(Ingredients.FRUCTOSE);
        ingredients1.add(Ingredients.MILK);
        Value value1 = new Value(1, 2, 3, 4);
        LocalDate dateStart1 = LocalDate.of(2022,3,12);
        LocalDate dateFinish1 = LocalDate.of(0,6,0);
        TypeGlazed glazed = TypeGlazed.CARAMEL;
        Filling filling = Filling.getFilling("Souffle");

        GlazedCandy candyGlazed = new GlazedCandy(0, name1, production1, ingredients1, value1, dateStart1, dateFinish1, glazed, filling);
        System.out.println(candyGlazed);

        String name2 = "candiChocolate_1";
        Production production2 = Production.getTypeProduction("Vesta");
        Set<Ingredients> ingredients2 = new HashSet<>();
        ingredients2.add(Ingredients.BUTTER);
        ingredients2.add(Ingredients.FLOUR);
        ingredients2.add(Ingredients.MILK);
        Value value2 = new Value(5, 6, 7, 8);
        LocalDate dateStart2 = LocalDate.of(2021,12,30);
        LocalDate dateFinish2 = LocalDate.of(0,7,0);
        TypeChocolate typeChocolate = TypeChocolate.getType("White");
        Form form = Form.getForm("Free");

        ChocolateCandy candyChocolate = new ChocolateCandy(1, name2, production2, ingredients2, value2, dateStart2, dateFinish2, typeChocolate, form);
        System.out.println(candyChocolate);



    }
}
