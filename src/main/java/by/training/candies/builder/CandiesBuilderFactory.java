package by.training.candies.builder;


import by.training.candies.exception.CustomException;

public enum CandiesBuilderFactory {
    ;

    private enum TypeParser {
        SAX, STAX, DOM
    }

    CandiesBuilderFactory() {
    }

    public static AbstractBuilderCandies createCandiesBuilder(String typeParser) throws CustomException, EnumConstantNotPresentException {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        return switch (type) {
            case DOM -> new CandiesDomBuilder();
            case STAX -> new CandiesStaxBuilder();
            case SAX -> new CandiesSaxBuilder();
            default -> throw new EnumConstantNotPresentException(type.getDeclaringClass(), type.name());
        };
    }
}
