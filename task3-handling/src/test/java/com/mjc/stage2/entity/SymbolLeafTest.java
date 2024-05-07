package com.mjc.stage2.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SymbolLeafTest {
    char  character;
    SymbolLeaf leaf;
    @BeforeEach
    public void setup() {
        character = 'c';
        leaf = new SymbolLeaf(character, TextComponentType.SYMBOL);
    }
    @Test
    public void SymbolLeafOperationReturnsString() {
        assert leaf.operation().equals(String.valueOf(character)) : "operation() value expected to be: '" + character + "' but was: '" + leaf.operation() + "'";
    }

    @Test
    public void SymbolLeafAddMethodThrowsException() {
        try {
            leaf.add(new SymbolLeaf('k', TextComponentType.SYMBOL));
            assert false : "Expected UnsupportedOperationException not thrown";
        }catch (UnsupportedOperationException e){
            e.getMessage();
        }
    }

    @Test
    public void SymbolLeafRemoveMethodThrowsException() {
        SymbolLeaf leaf1 = new SymbolLeaf('k', TextComponentType.SYMBOL);

        try {
            leaf.remove(leaf1);
            assert false : "Expected UnsupportedOperationException not thrown";
        }catch (UnsupportedOperationException e){
            e.getMessage();
        }
    }
    @Test
    public void SymbolLeafGetSizeMethodThrowsException() {
        try {
            leaf.getSize();
            assert false : "Expected UnsupportedOperationException not thrown";
        }catch (UnsupportedOperationException e){
            e.getMessage();
        }
    }
}
