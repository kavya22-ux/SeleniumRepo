package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 11;
		int flag = 0;
		int m = n/2;
		if(n == 0 || n == 1) {
			System.out.println("It is not prime number");
		}
		else {
		for(int i = 2; i <= m; i++) {
			if(n%i == 0) {
				System.out.println(n+" is not a prime number");
			    flag = 1;
			    break;
			}
		}
		if(flag == 0) {
			System.out.println(n+" is prime number");
		}
	}	

	}

}
