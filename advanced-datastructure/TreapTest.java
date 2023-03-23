import java.util.Random;

public class TreapTest {
    public int compares = 0;
    public int rotations = 0;
    public int height = 0;

    public TreapTest testInsertAll(DataSet ds) {
        Treap<Integer> tree = new Treap<>();

        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }

    public TreapTest testInsertAllAndRemoveAll(DataSet ds) {
        Treap<Integer> tree = new Treap<>();

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

    public TreapTest testInsertAllAndRemoveHalf(DataSet ds) {
        Treap<Integer> tree = new Treap<>();

        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        // remove from tree
        for (int i = ds.data.length / 2; i < ds.data.length; i++) {
            tree.remove(ds.data[i]);
        }

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }

    public TreapTest testInsertContainsTwoTimes(DataSet ds) {
        Random rnd = new Random();
        Treap<Integer> tree = new Treap<>();

        // load into tree
        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        // get one random value from the tree
        int randomIndex = rnd.nextInt(ds.data.length);

        // contains

        tree.contains(ds.data[randomIndex]);
        tree.contains(ds.data[randomIndex]);

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }
}
