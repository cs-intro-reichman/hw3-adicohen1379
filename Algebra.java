// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    //System.out.println(plus(-1,1));   // 2 + 3
	    //System.out.println(minus(-13,-10));  // 7 - 2
   		//System.out.println(minus(100,50));  // 2 - 7
 		//System.out.println(times(-5,-3));  // 3 * 4
   		//System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		//System.out.println(pow(5,3));      // 5^3
   		//System.out.println(pow(3,5));      // 3^5
   		//System.out.println(div(-15,-3));   // 12 / 3    
   		//System.out.println(div(5,5));    // 5 / 5  
   		//System.out.println(div(25,7));   // 25 / 7
   		//System.out.println(mod(2,7));   // 25 % 7
   		//System.out.println(mod(120,6));  // 120 % 6    
   		//System.out.println(sqrt(0));
		System.out.println(sqrt(263169));
   		//System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2)
	{
		int retNum=0;
		if(x1>0&&x2>0)
		{
			for(int i=0;i<x1;i++)
			{
				x2++;
			}
			return x2;
		}
		if(x1<0&&x2<0)
		{
		for(int i=0;i>x1;i--)
			{
				x2--;
			}
			return x2;
		}

		if(x1<0&&x2>0)
		{
		for(int i=0;i<x2;i++)
			{
				x2--;
			}
			return x2;
		}

		if(x2<0&&x1>0)
		{
		for(int i=0;i<x1;i++)
			{
				x2++;
			}
			return x2;
		}
		if(x1==0)
		{
			retNum=x2;
		}
		if(x2==0)
		{
			retNum=x1;
		}
		return retNum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) 
	{
		int retnum=0;
		if((x1>=0&&x2>=0)||(x1<0&&x2>=0))
		{
			for(int i=0;i<x2;i++)
			{
				x1--;
			}
			retnum=x1;
		}
		else{
				for(int i=x2;i<0;i++)
				{
					x1++;
				}
				retnum=x1;
			}
		return retnum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int num=0;
		int temp=x1;
		int temp2=x2;
		if(x1>0&&x2>0)
		{
			for(int i=1;i<x2;i++)
			{
				x1=plus(temp,x1);
			}
			num=x1;
		}
		if(x1<0&&x2<0)
		{
			for(int i=-1;i>x2;i--)
			{
				x1=plus(temp,x1);
			}
			int counter=0;
			for(int j=0;j>x1;j--)
			{
				counter++;
			}
			num=counter;
		}
		if(x1>0&&x2<0)
		{
			for(int i=1;i<x1;i++)
			{
				x2=plus(temp2,x2);
			}
			num=x2;
		}
		if(x2>0&&x1<0)
		{
			for(int i=1;i<x2;i++)
			{
				x1=plus(temp,x1);
			}
			num=x1;
		}
		if(x2==0||x1==0)
		{
			num=0;
		}
		return num;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int temp=x;
		for(int i=1;i<n;i++)
		{
			x=times(temp, x);
		}
		if(n==0)
		{
			return 1;
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) 
	{
		int retnum=0;
		if(x1>=0)
		{
			if(x2>0)
			{
				while(x1>=x2)
				{
					x1=minus(x1, x2);
					retnum++;
				}
				return retnum;
			}
		
		else
		{
			x2=minus(0, x2);
			while(x1>=x2)
			{
				x1=minus(x1, x2);
				retnum--;
			}
			return retnum;
		}
	}
		else
		{
			x1=minus(0, x1);
			if(x2>0)
			{
				while(x1>=2)
				{
					x1=minus(x1, x2);
					retnum--;
				}
				return retnum;
			}
			else{
				x2=minus(0, x2);
				while(x1>=x2)
				{
					x1=minus(x1, x2);
					retnum++;
				}
				return retnum;
			}
		}
		
	}
	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int counter=1;
		int multi=x2;
		if(x1>x2)
	{
		while((plus(x2,multi))<x1)
		{
			counter++;
			x2=plus(x2,multi);
		}
		if(plus(x2,multi)==x1)
		{
			counter++;
		}
	}
		if(x1==x2)
		{
			counter=1;
		}
		if(x1<x2)
		{
			return x1;
		}
		int cal=times(multi, counter);
		return minus(x1,cal );
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x)
	 {
		int y=1;
		int sqrt=0;
		boolean b=false;
		for(int i=0;i<x;i++)
		{
			if(pow(y,2)==x)
			{
				sqrt=y;
				b=true;
				return sqrt;
			}
			y++;
		}
			y=1;
			int counter=0;
			for(int i=0;i<x&&b==false;i++)
			{
				if(pow(y,2)<x)
				{
					counter++;
				}
				y++;
				if(pow(y,2)>x)
				{
					sqrt=counter;
					b=true;
				}
			}
			return sqrt;
	}	  	  
}
