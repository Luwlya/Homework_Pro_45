package java_task.hw8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExchangeApp {
    public static void main(String[] args) {
        CurrencyExchange exchange = createExchange();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the currency to exchange:");
        String currency1 = scanner.next();
        if (!currency1.matches("[A-Z]{3}")) {
            System.out.println("Invalid currency");
            return;
        }
        System.out.println("Please enter the amount:");
        double amount = 0;
        try {
            amount = scanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid amount");
            return;
        }
        System.out.println("Please choose the currency to get:");
        String currency2 = scanner.next();
        if (!currency2.matches("[A-Z]{3}")) {
            System.out.println("Invalid currency");
            return;
        }
        Double exchangeRate = exchange.getExchangeRate(currency1, currency2);
        if (exchangeRate == null) {
            System.out.println("There is no exchange rate for this currency pair");
        } else {
            double result = exchangeRate * amount;
            System.out.println("You will get " + result);
        }
    }

    private static CurrencyExchange createExchange() {
        CurrencyExchange currencyExchange = new CurrencyExchange();
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("rates.txt"));
            fileReader.lines().forEach(line -> {
                String[] s = line.split(" ");
                currencyExchange.addExchangeRate(s[0], s[1], Double.parseDouble(s[2]));
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return currencyExchange;
    }
}


