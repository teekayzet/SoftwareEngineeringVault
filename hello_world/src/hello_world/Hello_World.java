package hello_world;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Hello_World {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<String, String> greetings = new HashMap<>();
            greetings.put("US", "Hello");  // Greeting for United States
            greetings.put("GB", "Hello");  // Greeting for United Kingdom
            greetings.put("FR", "Bonjour");  // Greeting for France
            greetings.put("DE", "Guten Tag");  // Greeting for Germany
            greetings.put("JP", "こんにちは");  // Greeting for Japan
            greetings.put("ES", "Hola");  // Greeting for Spain
            greetings.put("IT", "Ciao");  // Greeting for Italy
            greetings.put("RU", "Привет");  // Greeting for Russia
            greetings.put("CN", "你好");  // Greeting for China
            greetings.put("KR", "안녕하세요");  // Greeting for South Korea
            greetings.put("BR", "Olá");  // Greeting for Brazil
            greetings.put("MX", "Hola");  // Greeting for Mexico
            greetings.put("AU", "Hello");  // Greeting for Australia
            greetings.put("CA", "Bonjour");  // Greeting for Canada
            greetings.put("NZ", "Kia ora");  // Greeting for New Zealand
            greetings.put("ZW", "Makadini");  // Greeting for Zimbabwe
            
            String continueChoice;
            do {
                // Prompting for name input
                System.out.print("Please enter your name: ");
                String name = scanner.nextLine();
                if (name.isEmpty()) {
                    System.out.print("Please enter your name: ");
                    name = scanner.nextLine();
                }

                String country = "";
                while (country.isEmpty()) {
                    // Prompting for country input
                    System.out.print("Please enter your country: ");
                    country = scanner.nextLine();
                    if (country.isEmpty()) {
                        System.out.println("Invalid country. Please enter your country.");
                    }
                }

                // Retrieve the greeting message based on the country
                String greeting = greetings.get(country);
                if (greeting == null) {
                    System.out.println("Invalid country!!!");
                    System.out.print("Please enter your country: ");
                    country = scanner.nextLine();
                    greeting = greetings.get(country);
                }

                // Display the personalized greeting
                System.out.println(greeting + ", " + name + "!");

                // Prompting for continue choice input
                System.out.println("Do you want to continue? (yes/no)");
                continueChoice = scanner.nextLine();
                if (!continueChoice.equals("yes") && !continueChoice.equals("no")) {
                    System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
                }
            } while (!continueChoice.equals("no"));
            
            // Exit msg
            System.out.println("Goodbye");
        }
    }
}
