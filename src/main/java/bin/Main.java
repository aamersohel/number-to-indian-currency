package bin;

import com.aamersohel.git.java.*;

public class Main {
    public static void main(String... args) throws CurrencyRangeException {
        for(long i=-10; i<900; i++) {
            System.out.println(i + " => " + IndianCurrency.toString(i));
        }
    }
}
