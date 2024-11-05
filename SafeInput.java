import java.util.Scanner;

public class SafeInput {
    public static String getRegExString(Scanner console, String prompt, String regEx) {
        String input;
        do {
            System.out.print(prompt);
            input = console.nextLine();
        } while (!input.matches(regEx));
        return input;
    }

    public static int getRangedInt(Scanner console, String prompt, int low, int high) {
        int input;
        do {
            System.out.print(prompt);
            input = console.nextInt();
        } while (input < low || input > high);
        return input;
    }

    public static boolean getYNConfirm(Scanner console, String prompt) {
        System.out.print(prompt + " (Y/N): ");
        String input = console.next().toUpperCase();
        return input.equals("Y");
    }
}
