package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import org.junit.jupiter.api.Test;

public class LexemeParserTest {
    AbstractTextComponent abstractTextComponent = new TextComponent(TextComponentType.SENTENCE);
    LexemeParser lexemeParser = new LexemeParser();

    @Test
    public void LexemeParserParse(){
        String sentence = "Lorem ipsum deus vult!";
        int expectedSize = sentence.split(" ").length;
        lexemeParser.parse(abstractTextComponent, sentence);
        int size = abstractTextComponent.getSize();

        assert size == expectedSize : "expected to be " + expectedSize + " but was: " + size;
    }
}
