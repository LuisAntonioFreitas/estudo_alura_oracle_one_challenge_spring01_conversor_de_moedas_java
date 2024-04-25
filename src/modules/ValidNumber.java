package modules;

import java.util.Scanner;

public class ValidNumber {

    public int getValidInteger(Scanner scanner, Integer limit) {

        int number = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                String input = scanner.nextLine();

                if (input.trim().contains(String.valueOf(","))
                        || input.trim().contains(String.valueOf("."))) {
                    input = input.trim().replace(".", "").replace(",","");
                }

                number = Integer.valueOf(input);
                if (number > 0 && (limit == null || number <= limit)) {
                    isValid = true;
                } else {
                    System.out.println("Digite um número válido!");
                }
            } catch (Exception ignored) {
                System.out.println("Digite um número válido!");
            }
        }

        return number;
    }

    public double getValidDouble(Scanner scanner, Integer limit) {

        double number = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                String input = scanner.nextLine();

                if (input.trim().contains(String.valueOf(","))) {
                    input = input.trim().replace(".", "").replace(",",".");
                }

                number = Double.valueOf(input);
                if (number > 0 && (limit == null || number <= limit)) {
                    isValid = true;
                } else {
                    System.out.println("Digite um valor válido!");
                }
            } catch (Exception ignored) {
                System.out.println("Digite um valor válido!");
            }
        }

        return number;
    }

}