package com.memento;

import java.util.Stack;

/**
 * Rol: Caretaker
 * Responsable de guardar y proveer los mementos para la operación de deshacer.
 */
public class History {
    private final Stack<IMemento> history = new Stack<>();

    /**
     * @param memento El estado capturado por el TextEditor
     */
    public void saveState(IMemento memento) {
        if (memento != null) {
            history.push(memento);
        }
    }

    /**
     * Extrae el último estado guardado para la operación de deshacer [cite: 17, 45]
     * @return El memento anterior o null si el historial está vacío
     */
    public IMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}