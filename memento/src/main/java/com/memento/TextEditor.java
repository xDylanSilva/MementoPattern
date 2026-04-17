package com.memento;

public class TextEditor {
    private String content = "";

    public void write(String newText) {

        this.content = newText;
    }

    public void showContent() {
        System.out.println("\n--- Current Editor Content ---");
        System.out.println(content);
        System.out.println("------------------------------");
    }

    public IMemento save() {
        return new TextMemento(content);
    }

    // Restaura el estado a partir de un memento
    public void restore(IMemento memento) {
        if (memento instanceof TextMemento) {
            this.content = ((TextMemento) memento).getContent();
        }
    }
}