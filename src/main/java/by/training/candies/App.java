package by.training.candies;

import by.training.candies.builder.*;


public class App {
    public static final String pathXml = "C:\\Users\\user\\IdeaProjects\\SecondTaskEPAM\\src\\main\\resources\\candies.xml";
    public static final String pathXsd = "C:\\Users\\user\\IdeaProjects\\SecondTaskEPAM\\src\\main\\resources\\schema.xsd";

    public static void main(String[] args) { //// TODO: 16.03.2022 абсолютные ссылки исправить 


        String type = "stax";
        AbstractBuilderCandies builder = CandiesBuilderFactory.createCandiesBuilder(type);
        builder.buildSetCandies(pathXml);
        for (var i : builder.getCandies()) {
            System.out.println(i);
        }

        /*CandiesStaxBuilder staxBuilder = new CandiesStaxBuilder();
        staxBuilder.buildSetCandies(pathXml);
        for (var i:staxBuilder.getCandies()) {
            System.out.println(i);
        }

        System.out.println("-------------");
        CandiesDomBuilder domBuilder = new CandiesDomBuilder();
        domBuilder.buildSetCandies(pathXml);
        for (var i:domBuilder.getCandies()) {
            System.out.println(i);
        }
        System.out.println("-------------");
        CandiesSaxBuilder saxBuilder = new CandiesSaxBuilder();
        saxBuilder.buildSetCandies(pathXml);
        for (var i:saxBuilder.getCandies()){
            System.out.println(i);
        }

       boolean result = new Validation().valid(pathXsd, pathXml);
        System.out.println(result);*/
        }
    }
