package lessons_challenges;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateManipulation {

    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    private static long lifeSpanMS(String birthDateStr) throws ParseException {
        Date birthDate = formatter.parse(birthDateStr);

        return System.currentTimeMillis() - birthDate.getTime();
    }

    private static Date paymentDeadline(String purchaseDateStr) throws ParseException {
            Date purchaseDate = formatter.parse(purchaseDateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(purchaseDate);
            calendar.add(Calendar.DATE, 10);

            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                calendar.add(Calendar.DATE, 2);
            } else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                calendar.add(Calendar.DATE, 1);
            }

            return calendar.getTime();
    }

    public static void main(String[] args) throws ParseException {
        String userInput;
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Enter your birth date (dd/mm/yyyy): ");
        userInput = inputScanner.next();

        System.out.println("You lived: " + lifeSpanMS(userInput) + " miliseconds so far");


        System.out.println("Enter the purchase date (dd/mm/yyyy): ");
        userInput = inputScanner.next();

        System.out.println("You have until [" + paymentDeadline(userInput) + "] to pay.");
    }
}
