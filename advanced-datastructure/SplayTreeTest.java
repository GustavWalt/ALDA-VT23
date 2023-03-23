import java.util.Random;

public class SplayTreeTest {

    public int compares = 0;
    public int rotations = 0;
    public int height = 0;

    public SplayTreeTest testInsertAll(DataSet ds) {
        SplayTree<Integer> tree = new SplayTree<>();

        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }

    public SplayTreeTest testInsertAllAndRemoveAll(DataSet ds) {
        SplayTree<Integer> tree = new SplayTree<>();

        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        for (int i = 0; i < ds.data.length; i++) {
            tree.remove(ds.data[i]);
        }

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }

    public SplayTreeTest testInsertAllAndRemoveHalf(DataSet ds) {
        SplayTree<Integer> tree = new SplayTree<>();

        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        for (int i = ds.data.length / 2; i < ds.data.length; i++) {
            tree.remove(ds.data[i]);
        }

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }

    public SplayTreeTest testInsertContainsTwoTimes(DataSet ds) {
        Random rnd = new Random();
        SplayTree<Integer> tree = new SplayTree<>();

        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        int randomIndex = rnd.nextInt(ds.data.length);

        tree.contains(ds.data[randomIndex]);
        tree.contains(ds.data[randomIndex]);

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }
}
