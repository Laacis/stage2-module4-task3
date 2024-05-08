package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import org.junit.jupiter.api.Test;

public class WordParserTest {
    AbstractTextComponent  abstractTextComponent = new TextComponent(TextComponentType.WORD);
    WordParser wordParser = new WordParser();

    @Test
    public void WordParserParse() {
        String testString = "test";
        int testStringLength = testString.length();
        wordParser.parse(abstractTextComponent, testString);
        int result = abstractTextComponent.getSize();

        assert result == testStringLength : "Size expected to be " + testStringLength + " but was " + result ;
    }
}
