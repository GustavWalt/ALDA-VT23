// Gustav Walter guwa7932
import java.util.Arrays;

public class ISBN10 {

	private char[] isbn;

	public ISBN10(String isbn) {
		if (isbn.length() != 10)
			throw new IllegalArgumentException("Wrong length, must be 10");
		if (!checkDigit(isbn))
			throw new IllegalArgumentException("Not a valid isbn 10");
		this.isbn = isbn.toCharArray();
	}

	private boolean checkDigit(String isbn) {
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			sum += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
		}
		int checkDigit = (11 - (sum % 11)) % 11;

		return isbn.endsWith(checkDigit == 10 ? "X" : "" + checkDigit);
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ISBN10 isbn10 = (ISBN10) o;
        return Arrays.equals(isbn, isbn10.isbn);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(isbn);
    }

	@Override
	public String toString() {
		return new String(isbn);
	}
}
