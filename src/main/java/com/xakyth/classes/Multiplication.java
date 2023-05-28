package com.xakyth.classes;

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
     
        //removing zeros from left from the result
        String result = _intRecMult(x, y).toString().replaceAll("^0*", "");
        if (result.length() == 0) {
            return "0";
        } else {
            return result;
        }
    }

    private static StringBuilder _intRecMult(String x, String y) {
        int n = x.length();
        if (n == 1) {
            return new StringBuilder(String.valueOf((x.charAt(0) - '0') * (y.charAt(0) - '0')));
        }
        
        StringBuilder ac = _intRecMult(x.substring(0, n/2), y.substring(0, n/2));
        StringBuilder ad = _intRecMult(x.substring(0, n/2), y.substring(n/2));
        StringBuilder bc = _intRecMult(x.substring(n/2), y.substring(0, n/2));
        StringBuilder bd = _intRecMult(x.substring(n/2), y.substring(n/2));

        //10^n(ac)        
        ac.append(String.format("%" + n + "s", "").replace(' ', '0'));
        
        //10^(n/2) * (ad + bc)
        StringBuilder adbc = new StringBuilder(String.format("%" + n/2 + "s", "").replace(' ', '0'));

        int carry = 0;
        for (int i = ad.length() - 1, j = bc.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int temp = 0;
            if (i >= 0 && j >= 0) {
                temp = (ad.charAt(i) - '0') + (bc.charAt(j) - '0') + carry;
            } else if (i >= 0) {
                temp = (ad.charAt(i) - '0') + carry;
            } else {
                temp = (bc.charAt(j) - '0') + carry;
            }
            carry = temp / 10;
            adbc.append(temp % 10);
        }
        if (carry > 0) {
            adbc.append(carry);
        }

        StringBuilder result = new StringBuilder();
        //10^n(ac) + 10^(n/2)(ad + bc) + bd
        carry = 0;
        for (int i = ac.length() - 1, j = 0, k = bd.length() - 1; i >= 0; i--, j++, k--) {
            int temp = 0;
            if (k >= 0) {
                temp = (ac.charAt(i) - '0') + (adbc.charAt(j) - '0') + (bd.charAt(k) - '0') + carry;
            } else if (j < adbc.length()) {
                temp = (ac.charAt(i) - '0') + (adbc.charAt(j) - '0') + carry;
            } else {
                temp = (ac.charAt(i) - '0') + carry;
            }
            result.append(temp % 10);
            carry = temp / 10;
        }
        if (carry > 0) {
            result.append(carry);
        }

        result.reverse();
        return result;
    }

}
