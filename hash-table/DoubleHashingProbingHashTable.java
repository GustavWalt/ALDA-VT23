// Gustav Walter guwa7932
public class DoubleHashingProbingHashTable<T> extends ProbingHashTable<T> {

	@Override
	protected int findPos(T x) {
		int offset = smallerPrimeThanCapacity() - (x.hashCode() % smallerPrimeThanCapacity());
		int currentPos = myhash(x);
		while (continueProbing(currentPos, x)) {
			currentPos += offset;
			if (currentPos >= capacity())
				currentPos -= capacity();
		}
		return currentPos;
	}

	protected int smallerPrimeThanCapacity() {
		int n = capacity() - 2;
		while (!isPrime(n)) {
			n -= 2;
		}
		return n;
	}

}
