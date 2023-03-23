// Gustav Walter guwa7932
public class LinearProbingHashTable<T> extends ProbingHashTable<T> {
	
	@Override
	protected int findPos(T x) {
		int offset = 1;
		int currentPos = myhash(x);
		while (continueProbing(currentPos, x)) {
			currentPos += offset;
			if (currentPos >= capacity())
				currentPos -= capacity();
		}
		return currentPos;
	}
}
