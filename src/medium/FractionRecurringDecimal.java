package medium;

import java.util.HashMap;
import java.util.Map;

/*
    Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

    If the fractional part is repeating, enclose the repeating part in parentheses.
 */
public class FractionRecurringDecimal {

    public static void main(String... args) {

        FractionRecurringDecimal fractionRecurringDecimal = new FractionRecurringDecimal();
        System.out.println(fractionRecurringDecimal.fractionToDecimal(2, 3));
    }

    public String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        sb.append(numerator > 0 ^ denominator > 0 ? "-" : "");
        long x = Math.abs((long) numerator);
        long y = Math.abs((long) denominator);
        sb.append(x / y);
        if ((x %= y) == 0) return sb.toString();
        Map<Long, Integer> t = new HashMap();
        t.put(x, sb.append(".").length());

        while (x != 0) {

            sb.append((x *= 10) / y);
            Integer z = t.get(x %= y);
            if (z != null) return sb.insert(z, "(").append(")").toString();
            t.put(x, sb.length());
        }

        return sb.toString();
    }

}
