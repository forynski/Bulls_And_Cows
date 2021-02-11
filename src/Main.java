package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Please, enter the secret code's length:");
        Scanner scanner = new Scanner(System.in);
        int sc = scanner.nextInt();
        if (sc > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        }

        String secretCode = generateSecretCode(sc);
        calculateCowsAndBulls(secretCode, sc);

    }

    static String generateSecretCode(int sc) {

        long pseudoRandomNumber = System.nanoTime();
        String s2 = Long.toString(pseudoRandomNumber);

        char[] chars = s2.toCharArray();
        Set<Character> characterSet = new LinkedHashSet<>();
        for (char c : chars) {
            characterSet.add(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character character : characterSet) {
            sb.append(character);
        }

        return sb.substring(0, sc);
    }

    private static void calculateCowsAndBulls(String secretCode, int sc) {

        System.out.println("Okay, let's start a game!");

        Scanner scanner = new Scanner(System.in);
        scanner.hasNextLine();


        int cows = 0;
        int bulls = 0;

        do {
            String input = scanner.nextLine();


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

    }


}
