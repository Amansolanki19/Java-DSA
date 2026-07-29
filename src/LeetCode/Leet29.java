package LeetCode;

public class Leet29 {
    public static void main(String...args){
        int divisor=10;
        int dividend=3;
        System.out.println(divide(divisor,dividend));
    }

    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean negative = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int quotient = 0;

        while (a >= b) {

            long temp = b;
            int multiple = 1;

            while ((temp << 1) <= a) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}
