import java.util.Random;

public class RedBlackTreeTest {
    public int compares = 0;
    public int rotations = 0;
    public int height = 0;

    public RedBlackTreeTest testInsertAll(DataSet ds) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        for (int i = 0; i < ds.data.length; i++) {
            tree.insert(ds.data[i]);
        }

        compares = tree.getCompares();
        rotations = tree.getRotations();
        height = tree.getHeight();

        return this;
    }

    public RedBlackTreeTest testInsertAllAndRemoveAll(DataSet ds) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

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

    public RedBlackTreeTest testInsertAllAndRemoveHalf(DataSet ds) {
        RedBlackTree<Integer> tree = new RedBlackTree<>();

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

    public RedBlackTreeTest testInsertContainsTwoTimes(DataSet ds) {
        Random rnd = new Random();
        RedBlackTree<Integer> tree = new RedBlackTree<>();

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
