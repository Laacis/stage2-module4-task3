package com.mjc.stage2.entity;

public class SymbolLeaf extends AbstractTextComponent{

    private final char value;

    public SymbolLeaf(char c) {
        super(TextComponentType.SYMBOL);
        this.value = c;
    }

    @Override
    public String operation() {
        return String.valueOf(value);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }
}
