import java.util.function.Function;

public class App {
    public static void main(String[] args) {        
        DataSet ds = new DataSet("DataSet B");
        ds.fillBackwardsDataSet(100);
        DataSet ds1 = new DataSet("DataSet S");
        ds1.fillSortedDataSet(100);
        DataSet ds2 = new DataSet("DataSet R");
        ds2.fillRandomDataSet(100);
        Function <DataSet, SplayTreeTest> splayTest = e -> new SplayTreeTest().testInsertAllAndRemoveAll(e);
        Function <DataSet, RedBlackTreeTest> redBlackTest = e -> new RedBlackTreeTest().testInsertAllAndRemoveAll(e);
        Function <DataSet, TreapTest> treapTest = e -> new TreapTest().testInsertAllAndRemoveAll(e);
        
        Table table = new Table(splayTest, redBlackTest, treapTest ,ds, ds1, ds2);
        System.out.println("\ntestInsertAllAndRemoveAll\n");
        table.printTableCompares();
        System.out.println("");
        table.printTableHeight();
        System.out.println("");
        table.printTableRotations();
        System.out.println("");

        splayTest = e -> new SplayTreeTest().testInsertAll(e);
        redBlackTest = e -> new RedBlackTreeTest().testInsertAll(e);
        treapTest = e -> new TreapTest().testInsertAll(e);

        table = new Table(splayTest, redBlackTest, treapTest ,ds, ds1, ds2);
        System.out.println("\ntestInsertAll\n");
        table.printTableCompares();
        System.out.println("");
        table.printTableHeight();
        System.out.println("");
        table.printTableRotations();
        System.out.println("");

        splayTest = e -> new SplayTreeTest().testInsertAllAndRemoveHalf(e);
        redBlackTest = e -> new RedBlackTreeTest().testInsertAllAndRemoveHalf(e);
        treapTest = e -> new TreapTest().testInsertAllAndRemoveHalf(e);

        table = new Table(splayTest, redBlackTest, treapTest ,ds, ds1, ds2);
        System.out.println("\ntestInsertAllAndRemoveHalf\n");
        table.printTableCompares();
        System.out.println("");
        table.printTableHeight();
        System.out.println("");
        table.printTableRotations();
        System.out.println("");

        splayTest = e -> new SplayTreeTest().testInsertContainsTwoTimes(e);
        redBlackTest = e -> new RedBlackTreeTest().testInsertContainsTwoTimes(e);
        treapTest = e -> new TreapTest().testInsertContainsTwoTimes(e);

        table = new Table(splayTest, redBlackTest, treapTest ,ds, ds1, ds2);
        System.out.println("\ntestInsertContainsTwoTimes\n");
        table.printTableCompares();
        System.out.println("");
        table.printTableHeight();
        System.out.println("");
        table.printTableRotations();
        System.out.println("");
    }
}
