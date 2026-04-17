package com;

import java.util.Scanner;

import com.memento.History;
import com.memento.IMemento;
import com.memento.TextEditor;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        History history = new History();
        int option = 0;

        while (option != 5) {
            System.out.println("\n--- TEXT EDITOR MENU ---");
            System.out.println("1. Write/Modify text");
            System.out.println("2. Save checkpoint");
            System.out.println("3. Undo last change");
            System.out.println("4. View current text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid number.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Enter the new text: ");
                    String text = scanner.nextLine();
                    editor.write(text);
                    break;

                case 2:
                    history.saveState(editor.save());
                    System.out.println("Checkpoint saved successfully.");
                    break;

                case 3:
                    IMemento memento = history.undo();
                    if (memento != null) {
                        editor.restore(memento);
                        System.out.println("State restored to the previous checkpoint.");
                    } else {
                        System.out.println("No history found to undo.");
                    }
                    break;

                case 4:
                    editor.showContent();
                    break;

                case 5:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }
}