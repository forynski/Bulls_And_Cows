package bullscows;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input the length of the secret code:");
        Scanner scanner = new Scanner(System.in);
        int sc = scanner.nextInt();
        if (sc > 36) {
            System.out.println("Error: can't generate a secret number with a length of 36 because there aren't enough unique symbols.");
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

        String allChars = "0123456789abcdefghijklmnopqrstuvwxyz";
//        shuffle(allChars);
        allChars = allChars.substring(0, Integer.parseInt(charLength));

        List<String> symbols = Arrays.asList(allChars.split(""));
        Collections.shuffle(symbols);
        StringBuilder builder = new StringBuilder();
        for (String symbol : symbols) {
            builder.append(symbol);
        }
//        builder.toString();

        String chars = builder.substring(0, Integer.parseInt(charLength));


//        Random random = new Random();

//        int randomNumber = Math.abs(random.nextInt());
//        String s2 = Integer.toString(randomNumber);

//        char[] chars = s2.toCharArray();
//        Set<Character> characterSet = new LinkedHashSet<>();
//        for (char c : chars) {
//            characterSet.add(c);
//        }



        StringBuilder sb = new StringBuilder(sc);
        for (int i = 0; i < sc; i++)
            sb.append(chars.charAt(i));

//        shuffle(sb);

//        String secret = sb.toString().replaceAll("[a-z0-9]+$", "*");
// TODO: secret code as asterisks
        
//        System.out.println("The secret is prepared: " + secret + " (0-9, a-f).");

//        return shuffle(sb);
        return sb.toString();
//        return sb.substring(0, sc);
    }

    private static void shuffle(String allChars) {
        char[] characters = allChars.toCharArray();
        for (int i = 0; i < characters.length; i++) {
            int randomIndex = (int) (Math.random() * characters.length);
            char temp = characters[i];
            characters[i] = characters[randomIndex];
            characters[randomIndex] = temp;

        }
//        return new String(characters);
    }


    private static void calculateCowsAndBulls(String secretCode, int sc) {

        System.out.println("Okay, let's start a game!");

        Scanner scanner = new Scanner(System.in);
        scanner.hasNextLine();

        int bulls;
        int cows;

        do {
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
    }

}


