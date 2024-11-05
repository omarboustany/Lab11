import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    private static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = SafeInput.getRegExString(console, "Choose an option: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(console);
                    break;
                case "D":
                    deleteItem(console);
                    break;
                case "I":
                    insertItem(console);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(console, "Are you sure you want to quit?")) {
                        System.out.println("Exiting the program.");
                    } else {
                        choice = ""; // Reset choice to keep loop going
                    }
                    break;
            }
        } while (!choice.equals("Q"));
    }

    private static void displayMenu() {
        System.out.println("\nCurrent List:");
        printList();
        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
    }

    private static void addItem(Scanner console) {
        System.out.print("Enter item to add: ");
        String item = console.nextLine();
        myArrList.add(item);
        System.out.println("Item added.");
    }

    private static void deleteItem(Scanner console) {
        if (myArrList.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        printList();
        int index = SafeInput.getRangedInt(console, "Enter the item number to delete: ", 1, myArrList.size()) - 1;
        System.out.println("Deleted: " + myArrList.remove(index));
    }

    private static void insertItem(Scanner console) {
        System.out.print("Enter item to insert: ");
        String item = console.nextLine();

        int index = SafeInput.getRangedInt(console, "Enter the position to insert (1 to " + (myArrList.size() + 1) + "): ", 1, myArrList.size() + 1) - 1;
        myArrList.add(index, item);
        System.out.println("Item inserted.");
    }

    private static void printList() {
        if (myArrList.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.println((i + 1) + ". " + myArrList.get(i));
            }
        }
    }
}
