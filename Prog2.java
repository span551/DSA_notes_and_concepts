// recursive function to determine the nth fibo term
// Efficient solution bcoz redundant recursive calls are avoided by storing the results of previously
// called functions and those values are derived using a process called as memoization
import java.util.Scanner;
import java.util.Arrays;

class Prog2
{
	public static void main(String args[ ])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the nth term :- ");
		int n = sc.nextInt();
		int no = fibo(n);
		System.out.print("Fibo term at position " + n + " is " + no);
	}

	static int fibo(int n)
	{
		int memo[ ] = new int[n+1];
		Arrays.fill(memo,-1);
		int no = fibon(n,memo);  // calling recursive fn  fibon()
		return no;
	}

	// recursive function		
	static int fibon(int n,int memo[ ])
	{
		if (n <= 1)
			return n;

		if (memo[n] != -1)
			return memo[n];

		memo[n] = fibon(n-1,memo) + fibon(n-2,memo);

		return memo[n];
	}
}


		