package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
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

    @Test
    public void ChainParserBuilderBuildBuildAndParse() {
        ChainParserBuilder builder = new ChainParserBuilder();

        builder.setParser(new LexemeParser());
        builder.setParser(new WordParser());

        AbstractTextParser parser = builder.build();
        String testText = "Sometimes, it's useful to share arguments between different test classes.";
        AbstractTextComponent text = new TextComponent(TextComponentType.SENTENCE);

        parser.parse(text, testText);
        String result = text.operation();
        assert  result.matches(testText) : "result text is not as expected, result: '" + result + "' but was expected :" +testText;

    }
}
