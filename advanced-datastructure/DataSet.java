import java.util.Random;

public class DataSet {
    public String name;
    public int[] data;
    public Random rand;

    public DataSet(String name) {
        this.name = name;
        rand = new Random();

    }

    public void fillSortedDataSet(int length) {
        data = new int[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }
    }

    public void fillBackwardsDataSet(int length) {
        data = new int[length];
        for (int i = data.length - 1; i >= 0; i--) {
            data[data.length - i - 1] = i;
        }
    }

    public void fillRandomDataSet(int length) {
        data = new int[length];
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt();
        }
    }
}
