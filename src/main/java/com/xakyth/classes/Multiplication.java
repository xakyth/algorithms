package com.xakyth.classes;

import java.math.BigInteger;

public class Multiplication {

    public static String simpleIntMult(String a, String b) {
        String[] summands = new String[b.length()];
        int carry = 0;

        for (int i = b.length() - 1, k = 0; i >= 0; i--, k++) {
            StringBuilder summand = new StringBuilder();
            for (int j = 0; j < k; j++) {
                summand.append('0');
            }
            carry = 0;    
            for (int j = a.length() - 1; j >= 0; j--) {
                int temp = (b.charAt(i) - '0') * (a.charAt(j) - '0') + carry;
                summand.append(temp % 10);
                carry = temp / 10;
            }
            if (carry > 0) {
                summand.append(carry);
            }
            summands[k] = summand.toString();
        }

        StringBuilder result = new StringBuilder();

        int n = summands[summands.length - 1].length();
        carry = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < summands.length; j++) {
                if (summands[j].length() > i) {
                    sum += (summands[j].charAt(i) - '0');
                }
            }
            sum += carry;
            result.append(sum % 10);
            carry = sum / 10;      
        }
        while (carry > 0) {
            result.append(carry % 10);
            carry /= 10;
        }

        return result.reverse().toString();
    } 


    public static String intRecMult(String x, String y) {
        //check if x.length() and y.length() are both power of 2,
        //pad x and y with zeros to left until length isn't power of 2
        //and make their length equal
        int maxLength = Math.max(x.length(), y.length());
        int desiredLength = Integer.highestOneBit(maxLength) * 2;

        x = String.format("%" + desiredLength + "s", x).replace(' ', '0');
        y = String.format("%" + desiredLength + "s", y).replace(' ', '0');
     
        class impl {
            String _intRecMult(String x, String y) {
                int n = x.length();
                //base case
                if (n == 1) 
                    return String.valueOf(Integer.parseInt(x) * Integer.parseInt(y));
                String ac = _intRecMult(x.substring(0, n/2), y.substring(0, n/2));
                String ad = _intRecMult(x.substring(0, n/2), y.substring(n/2));
                String bc = _intRecMult(x.substring(n/2), y.substring(0, n/2));
                String bd = _intRecMult(x.substring(n/2), y.substring(n/2));
                //10^n(ac)
                ac += String.format("%" + n + "s", "").replace(' ', '0');
                //10^(n/2) * (ad + bc)
                String adbc = String.valueOf((new BigInteger(ad)).add(new BigInteger(bc)));
                adbc += String.format("%" + n/2 + "s", "").replace(' ', '0');
                //10^n(ac) + 10^(n/2)(ad + bc) + bd
                return String.valueOf((new BigInteger(ac).add(new BigInteger(adbc)).add(new BigInteger(bd))));
            }
        }

        return new impl()._intRecMult(x, y).replaceAll("^0+(?!$)", "");
    }

}
