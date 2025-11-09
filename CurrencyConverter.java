import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * A command-line application for currency conversion between USD and IDR.
 * <p>
 * This class provides methods to convert amounts from United States Dollar (USD)
 * to Indonesian Rupiah (IDR) and vice versa, using a fixed exchange rate.
 * It also includes a main method to demonstrate the functionality through a
 * console-based user interface.
 * </p>
 *
 * @author Gemini
 * @version 1.0
 */
public class CurrencyConverter {

    /**
     * The hardcoded exchange rate: 1 USD = 15,000 IDR.
     */
    private static final double EXCHANGE_RATE_USD_TO_IDR = 15000.0;

    /**
     * Converts an amount from United States Dollar (USD) to Indonesian Rupiah (IDR).
     *
     * @param amountInUSD The amount in USD to be converted.
     * @return The equivalent amount in IDR.
     */
    public static double usdToIdr(double amountInUSD) {
        return amountInUSD * EXCHANGE_RATE_USD_TO_IDR;
    }

    /**
     * Converts an amount from Indonesian Rupiah (IDR) to United States Dollar (USD).
     *
     * @param amountInIDR The amount in IDR to be converted.
     * @return The equivalent amount in USD.
     */
    public static double idrToUsd(double amountInIDR) {
        return amountInIDR / EXCHANGE_RATE_USD_TO_IDR;
    }

    /**
     * The main method to run the currency converter application.
     * <p>
     * It provides a console interface for the user to choose a conversion,
     * enter an amount, and see the result. The program continues to run until
     * the user chooses to exit.
     * </p>
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");

        System.out.println("Welcome to the Currency Converter!");

        while (true) {
            System.out.println();
            System.out.println("Please choose an option:");
            System.out.println("1. Convert USD to IDR");
            System.out.println("2. Convert IDR to USD");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            int choice = -1;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                scanner.next(); // consume invalid input
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                continue;
            }


            switch (choice) {
                case 1:
                    System.out.print("Enter amount in USD: ");
                    if (scanner.hasNextDouble()) {
                        double usd = scanner.nextDouble();
                        double idr = usdToIdr(usd);
                        System.out.println(df.format(usd) + " USD is equivalent to " + df.format(idr) + " IDR.");
                    } else {
                         scanner.next(); // consume invalid input
                         System.out.println("Invalid amount. Please enter a valid number.");
                    }
                    break;
                case 2:
                    System.out.print("Enter amount in IDR: ");
                     if (scanner.hasNextDouble()) {
                        double idr = scanner.nextDouble();
                        double usd = idrToUsd(idr);
                        System.out.println(df.format(idr) + " IDR is equivalent to " + df.format(usd) + " USD.");
                    } else {
                         scanner.next(); // consume invalid input
                         System.out.println("Invalid amount. Please enter a valid number.");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Currency Converter. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
}