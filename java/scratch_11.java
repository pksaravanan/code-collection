
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

interface PerformOperation {
	boolean check(int a);
}

class MyMath {
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	public PerformOperation isOdd() {
		return (number) -> number % 2 == 1;
	}

	public PerformOperation isPrime() {

		return (number) -> range(2, (int) Math.sqrt(number + 1))
				.noneMatch(i -> number % i == 0);

//        return (number) -> {
//
//            if (number < 2)
//                return true;
//            if (number % 2 == 0)
//                return false;
//            for (int i = 3; i < number; i++) {
//                if (number % i == 0) {
//                    return false;
//                }
//            }
//
//            return true;
//        };

	}

	public PerformOperation isPalindrome() {
		return (number) -> {
			String value = String.valueOf(number);
			return value.equals(new StringBuffer(value).reverse().toString());
		};
	}
}

class Scratch {

	public static void main(String[] args) throws IOException {
		MyMath ob = new MyMath();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		PerformOperation op;
		boolean ret = false;
		String ans = null;
		while (T-- > 0) {
			String s = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(s);
			int ch = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (ch == 1) {
				op = ob.isOdd();
				ret = ob.checker(op, num);
				ans = (ret) ? "ODD" : "EVEN";
			} else if (ch == 2) {
				op = ob.isPrime();
				ret = ob.checker(op, num);
				ans = (ret) ? "PRIME" : "COMPOSITE";
			} else if (ch == 3) {
				op = ob.isPalindrome();
				ret = ob.checker(op, num);
				ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

			}
			System.out.println(ans);
		}
	}
}
