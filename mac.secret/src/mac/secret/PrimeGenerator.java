package mac.secret;

import java.util.LinkedList;

public class PrimeGenerator {
	
	private Integer number = null;
	
	public PrimeGenerator(Integer number) {
		this.number = number;
	}

    public LinkedList<Integer> generatePrimes() {
        if (this.number != null && this.number < 2) {
            return new LinkedList<Integer>();
        }

        LinkedList<Integer> numbers = new LinkedList<Integer>();
        LinkedList<Integer> primes = new LinkedList<Integer>();
 
        for (int i = 2; i <= this.number; i++) {
            numbers.add(i);
        }
 
        while (numbers.size() > 0) {
            int nextPrime = numbers.remove();
            for (int i = nextPrime * nextPrime; i <= this.number; i+=nextPrime) {
                numbers.removeFirstOccurrence(i);
            }
            primes.add(nextPrime);
        }
        return primes;
    }

}
