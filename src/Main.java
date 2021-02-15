package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input the length of the secret code:");
        Scanner scanner = new Scanner(System.in);
        int sc = scanner.nextInt();
        if (sc > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
        } else if (!String.valueOf(sc).matches("[0-9a-z]+") || sc < 0) {
            System.out.println("Error: + \"" + sc + " \" isn't a valid number.");

        } else {

            String secretCode = generateSecretCode(sc);
            calculateCowsAndBulls(secretCode, sc);
        }
    }

    static String generateSecretCode(int sc) {

        System.out.println("Input the number of possible symbols in the code:");
        Scanner scanner = new Scanner(System.in);
        scanner.hasNextLine();
        String charLength = scanner.nextLine();

        if (Integer.parseInt(charLength) < sc) {
            System.out.println("Error: it's not possible to generate a code with a length of " + charLength +
                    " with " + sc + " unique symbols.");
        }

        String allChars = "0123456789abcdefghijklmnopqrstuvwxyz";

        int fullLengthNumber = Integer.parseInt(charLength);
        char charRange = allChars.charAt(fullLengthNumber - 1);

        allChars = allChars.substring(0, Integer.parseInt(charLength));

        List<String> symbols = Arrays.asList(allChars.split(""));
        Collections.shuffle(symbols);
        StringBuilder builder = new StringBuilder();
        for (String symbol : symbols) {
            builder.append(symbol);
        }

        String chars = builder.substring(0, Integer.parseInt(charLength));

        StringBuilder sb = new StringBuilder(sc);
        for (int i = 0; i < sc; i++) {
            sb.append(chars.charAt(i));
        }

        StringBuilder secretAsterisks = new StringBuilder();
        secretAsterisks.append("*".repeat(Math.max(0, sb.length())));

        if (fullLengthNumber <= 10) {
            System.out.println("The secret is prepared: " + secretAsterisks + " (0-" + charRange + ")");
        } else {
            System.out.println("The secret is prepared: " + secretAsterisks + " (0-9, " + "a-" + charRange + ")");
        }
        return sb.toString();
    }

    private static void calculateCowsAndBulls(String secretCode, int sc) {

        System.out.println("Okay, let's start a game!");

        int bulls;
        int cows;
        int turn = 1;

        do {
            System.out.println("Turn " + turn++);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            cows = 0;
            bulls = 0;

            for (int i = 0; i < sc; i++) {
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
            System.out.println("Grade " + result);
        } while (bulls != sc);

        System.out.println("Congratulations! You guessed the secret code.");
    }

}
