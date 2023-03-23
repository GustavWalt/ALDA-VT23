// Gustav Walter guwa7932
import java.util.Arrays;

public class MyString {
	private char[] data;
	
	public MyString(String title) {
		data = title.toCharArray();
	}

	public Object length() {
		return data.length;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyString myString = (MyString) o;
        return Arrays.equals(data, myString.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

	@Override
	public String toString() {
		return new String(data);
	}
	
}
