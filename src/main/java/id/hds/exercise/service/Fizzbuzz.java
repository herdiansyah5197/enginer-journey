package id.hds.exercise.service;

public class Fizzbuzz {
	public static void main(String[] args) {
		fizzBuzz(100);
		
		
	}
	public static void fizzBuzz(int total) {
	for(int i =1;i <= total; i++) {
		if (i %3==0 && i %5==0) {
			System.out.println("fizz Buzz");
		}else if(i %3 == 0) {
			System.out.println("Fizz");
		}else if(i %5 ==0) {
			System.out.println("Buzz");
		}else {
		System.out.println(i);
		}
	}
	}
	
}
