package com.mjc.stage2.parser;

import org.junit.jupiter.api.Test;

public class ChainParserBuilderTest {

    @Test
    public void ChainParserBuilderBuildReturnsChainedParsers() {
        ChainParserBuilder builder = new ChainParserBuilder();

        builder.setParser(new LexemeParser());
        builder.setParser(new WordParser());

        AbstractTextParser result = builder.build();
        assert  result.nextParser.getClass() == WordParser.class : "Expected another AbstractTextParserClass";
    }
}
