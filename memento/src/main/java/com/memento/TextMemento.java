package com.memento;

public class TextMemento implements IMemento {
    private final String content;

    public TextMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
