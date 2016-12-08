package mac.secret.junit;

import static org.junit.Assert.assertFalse;

import java.util.LinkedList;

import org.junit.Test;

import mac.secret.NonAdditiveSecret;
import mac.secret.PrimeGenerator;
import mac.secret.Secret;

public class TestNonAdditive {

	private Secret secret = new NonAdditiveSecret();
    
	public Integer processNumber(String input) {
		Integer number = null;
		try {
			number = Integer.parseInt(input);
			if (number <= 0) {
				return null;
			}
		} catch (Exception exception) {
			return null;
		}
		
		return number;
	}
	
	public boolean testSecret(String input) {
		Integer number = processNumber(input);
		if (number == null) {
			return false;
		}
		PrimeGenerator primeGenerator = new PrimeGenerator(number);
		LinkedList<Integer> primes = primeGenerator.generatePrimes();
		
		boolean condition = false;
		for (Integer x : primes) {
			for (Integer y : primes) {
				condition = this.secret.secret(x + y) == this.secret.secret(x) + this.secret.secret(y);
			}
		}
		
		return condition;
	}
	
	@Test
	public void testPositive1() {
		assertFalse(testSecret("592"));
	}
	
	@Test
	public void testPositive2() {
		assertFalse(testSecret("2308"));
	}
	
	@Test
	public void testPositive3() {
		assertFalse(testSecret("8480"));
	}
	
	@Test
	public void testPositive4() {
		assertFalse(testSecret("46391"));
	}
	
	@Test
	public void testNegativeNumber() {
		assertFalse(testSecret("-2844"));
	}
	
	@Test
	public void testString() {
		assertFalse(testSecret("Invalid Input"));
	}

}
