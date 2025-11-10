/**
 * Currency conversion demo
 * Shows both ways= USD->EUR and EUR->USD.
 * 
 */
public class CurrencyDemo {
    public static void main(String[] args) {
        double usd = 100.0;
        double eur = 100.0;

        double usdToEurRate = 0.92; // example USD->EUR
        double eurToUsdRate = 1.09; // example EUR->USD

        System.out.println("Currency Conversion (both ways)");
        System.out.println("-------------------------------");
        System.out.println(usd + " USD = " + usdToEur(usd, usdToEurRate) + " EUR  (rate " + usdToEurRate + ")");
        System.out.println(eur + " EUR = " + eurToUsd(eur, eurToUsdRate) + " USD  (rate " + eurToUsdRate + ")");
    }

    private static double usdToEur(double amount, double rate) {
        return amount * rate;
    }

    private static double eurToUsd(double amount, double rate) {
        return amount * rate;
    }
}
