// recursive function to determine the nth fibo term
// Not an efficient solution bcoz each recursive call doubles the calls and also the calls are redundant
// i.e. performing the same task again and again. Test for no=45. Takes lot of time as
// the no of recursive functions explode
import java.util.Scanner;

class Prog1
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
		// base call
		if (n <= 1)
			return n;  // fibo(0)=0,fibo(1)=1

		return fibo(n-1) + fibo(n-2);
	}
}


		