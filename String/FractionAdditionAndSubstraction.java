package String;


/*
					Fraction Addition And Substraction - Leetcode 592 Medium

Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

 

Example 1:
Input: expression = "-1/2+1/2"
Output: "0/1"

Example 2:
Input: expression = "-1/2+1/2+1/3"
Output: "1/3"

Example 3:
Input: expression = "1/3-1/2"
Output: "-1/6"
 

Constraints:

=>The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
=>Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction                or the output is positive, then '+' will be omitted.
=>The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
=>The number of given fractions will be in the range [1, 10].
=>The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
*/


public class FractionAdditionAndSubstraction {

	public String fractionAddition(String exp) {

		int n = exp.length();
		int numerator = 0;
		int denominator = 1;
		int i = 0;

		while (i < n) {
			int curNumerator = 0;
			int curDenominator = 0;
			boolean isNegative = exp.charAt(i) == '-';

			if (exp.charAt(i) == '-' || exp.charAt(i) == '+')
				i++;

			while (i < n && Character.isDigit(exp.charAt(i))) {
				curNumerator = curNumerator * 10 + (exp.charAt(i) - '0');
				i++;
			}

			if (isNegative)
				curNumerator *= -1;
			i++;

			while (i < n && Character.isDigit(exp.charAt(i))) {
				curDenominator = curDenominator * 10 + (exp.charAt(i) - '0');
				i++;
			}

			numerator = numerator * curDenominator + curNumerator * denominator;
			denominator = denominator * curDenominator;

		}

		int gcd = Math.abs(gcd(numerator, denominator));
		numerator /= gcd;
		denominator /= gcd;

		return String.valueOf(numerator) + "/" + String.valueOf(denominator);
	}

	int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

}
