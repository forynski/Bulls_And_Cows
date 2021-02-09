package bullscows;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final String secretCode = "9305";

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int cows = 0;
        int bulls = 0;

        for (int i = 0; i < 4; i++) {
            if (input.charAt(i) == secretCode.charAt(i)) {
                bulls++;
            } else if (secretCode.indexOf(input.charAt(i)) > -1) {
                cows++;
            }
        }
        if (bulls + cows == 0) {
            System.out.println("None");
        }
        String result;
        if (bulls > 0) {
            result = bulls + " bull(s).";
            if (cows > 0) {
                result += " and " + cows + " cow(s).";
            }
        } else {
            result = cows + " cow(s).";
        }
        System.out.println(result);
    }
}

