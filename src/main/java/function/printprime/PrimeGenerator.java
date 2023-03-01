package function.printprime;

class PrimeGenerator {

    private final int ordmax = 30;
    private int[] primes;
    private int numberOfPrimes;
    private int pagenumber;
    private int pageoffset;
    private int rowoffset;
    private int column;
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private int[] multiples;

    public int[] generatePrimes(int numberOfPrimes) {
        primes = new int[numberOfPrimes + 1];
        multiples = new int[ordmax + 1];
        candidate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;
        while (primeIndex < numberOfPrimes) {
            findNextPrime();
            primeIndex = primeIndex + 1;
            primes[primeIndex] = candidate;
        }
        return primes;
    }

    private void findNextPrime() {
        do {
            candidate = candidate + 2;
            if (candidate == square) {
                ord = ord + 1;
                square = primes[ord] * primes[ord];
                multiples[ord - 1] = candidate;
            }
            n = 2;
            possiblyPrime = true;
            while (n < ord && possiblyPrime) {
                while (multiples[n] < candidate)
                    multiples[n] = multiples[n] + primes[n] + primes[n];
                if (multiples[n] == candidate)
                    possiblyPrime = false;
                n = n + 1;
            }
        } while (!possiblyPrime);
    }

}