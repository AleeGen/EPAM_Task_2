package by.training.candies.builder;


public enum CandiesBuilderFactory {

        SAX, STAX, DOM;


    private CandiesBuilderFactory() {
    }

    public static AbstractBuilderCandies createCandiesBuilder(String typeParser) {
        CandiesBuilderFactory type = CandiesBuilderFactory.valueOf(typeParser.toUpperCase());
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
