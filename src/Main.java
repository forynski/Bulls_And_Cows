package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        generateSecretCode();
//        calculateCowsAndBulls();

    }

    private static void calculateCowsAndBulls() {
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
        System.out.println("The secret code is " + secretCode);
    }

    static void generateSecretCode() {
        Scanner scanner = new Scanner(System.in);
        int sc = scanner.nextInt();
        if (sc > 10) {
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
        } else {

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

            System.out.println("The random secret number is " + sb.substring(0, sc));

        }
    }
}

