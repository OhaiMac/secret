package mac.secret;

import java.util.LinkedList;

public class RunSecret {
    
	public static Integer processArguments(String[] args) {
		if (args.length == 0) {
			System.out.println("No argument given");
			return null;
		}
		
		Integer number = null;
		try {
			number = Integer.parseInt(args[0]);
			if (number <= 0) {
				System.out.println("Your argument cannot be negative");
				return null;
			}
		} catch (Exception exception) {
			System.out.println("Your argument must be a positive number");
			return null;
		}
		
		return number;
	}
	
	public static void main(String[] args) {
		Integer number = processArguments(args);
		if (number == null) {
			return;
		}
		
		Secret secret = new AdditiveSecret();
		PrimeGenerator primeGenerator = new PrimeGenerator(number);
		LinkedList<Integer> primes = primeGenerator.generatePrimes();
		
		for (Integer x : primes) {
			for (Integer y : primes) {
				if (secret.secret(x + y) != secret.secret(x) + secret.secret(y)) {
					System.out.println("Secret is non-additive");
					return;
				}
			}
		}
		
		System.out.println("Secret is additive");
	}

}
