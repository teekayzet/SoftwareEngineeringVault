package atmachine;

import java.util.Scanner;

public class Repeat {

    private static final Scanner input = new Scanner(System.in);

    public static void persuade() {
        try (Scanner scanner = new Scanner(System.in)) {
        boolean isValidAnswer = false;
        do {
            System.out.println("WOULD YOU LIKE TO PERFORM ANOTHER TRANSACTION? \n1. YES\n2. NO");
            String ans = input.nextLine();
            
            switch (ans) {
                case "1":
                    Home.home();
                    isValidAnswer = true;
                    break;
                case "2":
                    System.out.println("THANKS FOR BANKING WITH US!");
                    isValidAnswer = true;
                    break;
                default:
                    System.out.println("PLEASE ENTER A VALID ANSWER '1' FOR YES OR '2' FOR NO");
                    break;
            }
        } while (!isValidAnswer);
    }
}
}