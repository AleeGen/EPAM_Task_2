package by.training.candies.builder;


public enum CandiesBuilderFactory {
    ;

    private enum TypeParser {
        SAX, STAX, DOM
    }

    private CandiesBuilderFactory() {
    }

    public static AbstractBuilderCandies createCandiesBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new CandiesDomBuilder();
            }
            case STAX -> {
                return new CandiesStaxBuilder();
            }
            case SAX -> {
                return new CandiesSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
