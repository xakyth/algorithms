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

    

}
