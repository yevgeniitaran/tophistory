package com.yeta.tophistory.parser;

public class ParserGenerator {

    public static final String PARSER_PACKAGE = "com.tophistory.parser.";

    public static AbstractParser newInstance(String parserName) {
        try {
            Class c = Class.forName(PARSER_PACKAGE + parserName);
            return (AbstractParser) c.newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

}
