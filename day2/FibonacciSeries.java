package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 10;
		int num1 = 0,num2 = 1;
		for(int i = 0; i < num; i++) {
			System.out.println("The Fibonacci series: "+num1);
			int num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
		}

	}

}
