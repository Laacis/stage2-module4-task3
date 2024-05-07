package com.mjc.stage2.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TextComponentTest {
    SymbolLeaf leaf1;
    SymbolLeaf leaf2;
    SymbolLeaf leaf3;
    TextComponent textComponentWord1;
    TextComponent textComponentWord2;
    TextComponent textComponentSentence;

    @BeforeEach
    public void setup() {
        leaf1 = new SymbolLeaf('a', TextComponentType.SYMBOL);
        leaf2 = new SymbolLeaf('b', TextComponentType.SYMBOL);
        leaf3 = new SymbolLeaf('c', TextComponentType.SYMBOL);
        textComponentWord1 = new TextComponent(TextComponentType.WORD);
        textComponentWord2 = new TextComponent(TextComponentType.WORD);
        textComponentSentence = new TextComponent(TextComponentType.SENTENCE);

    }

    @Test
    public void TextComponentGetSizeReturnZeroWhenNoComponentsPresent() {
        assert textComponentWord1.getSize() == 0 : ".getSize() expected to be 0, but was: " + textComponentWord1.getSize();
    }

    @Test
    public void TextComponentAddMethodAddsLeafComponent() {
        textComponentWord1.add(leaf1);
        assert textComponentWord1.getSize() == 1 : ".getSize() expected to be 1, but was: " + textComponentWord1.getSize();
    }

    @Test
    public void TextComponentGetSizeReturnRightSize() {
        textComponentWord1.add(leaf1);
        long numberOfComponents = textComponentWord1.componentList.size();
        assert textComponentWord1.getSize() == numberOfComponents : ".getSize() expected to be " + numberOfComponents +", but was: " + textComponentWord1.getSize();
    }

    @Test
    public void TextComponentOperationReturnsWord() {
        StringBuilder builder = new StringBuilder();

        textComponentWord1.add(leaf1);
        textComponentWord1.add(leaf2);
        textComponentWord1.add(leaf3);
        String result = textComponentWord1.operation();
        builder.append(leaf1.operation());
        builder.append(leaf2.operation());
        builder.append(leaf3.operation());
        String stringFromBuilder = builder.toString();
        assert stringFromBuilder.equals(result) : "not matching " + result + " and " + stringFromBuilder;
    }

    @Test
    public void TextComponentOperationReturnsSentence() {
        StringBuilder builder = new StringBuilder();

        textComponentWord1.add(leaf1);
        textComponentWord1.add(leaf2);
        textComponentWord1.add(leaf3);
        textComponentSentence.add(textComponentWord1);
        textComponentWord2.add(leaf2);
        textComponentWord2.add(leaf1);
        textComponentWord2.add(leaf3);
        textComponentSentence.add(textComponentWord2);

        String OperationResult = textComponentSentence.operation();

        builder.append(textComponentWord1.operation());
        builder.append(" ");
        builder.append(textComponentWord2.operation());
        String stringFromBuilder = builder.toString();

        assert stringFromBuilder.equals(OperationResult) : "not matching '" + OperationResult + "' and '" + stringFromBuilder +"'";
    }
}
