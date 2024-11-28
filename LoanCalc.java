// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		for(int i=0;i<n;i++)
		{
			loan=(loan-payment)*((rate/100.0)+1.0);
		}
		return loan;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter=0;
		double middle=loan/n;
		while(endBalance(loan, rate, n,middle)>=epsilon)
		{
			middle=middle+epsilon;	
			iterationCounter++;
		}
		return middle;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		double low=(loan/n);
		double high=loan;
		double middle=(high+low)/2.0;
		iterationCounter=0;
		while((high-low)>epsilon)
		{
			//System.out.println(endBalance(loan, rate, n, middle));
			if(endBalance(loan, rate, n, middle)<epsilon)
			{
				high=middle;
			}
			else
			{
				low=middle;
			}
			//System.out.println(" the high is "+high+" the low is "+low+" the middle is "+middle);
			iterationCounter++;
			middle=(low+high)/2.0;
		}
		//System.out.println("the end middle is "+middle);
		return middle;
    }
}
