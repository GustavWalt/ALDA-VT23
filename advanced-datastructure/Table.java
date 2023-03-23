import java.util.function.Function;

public class Table {
    private DataSet[] dataSet;
    private Function<DataSet, SplayTreeTest> splayTest;
    private Function<DataSet, RedBlackTreeTest> redBlackTest;
    private Function<DataSet, TreapTest> treapTest;
    
    public Table(Function splayTest, Function redBlackTest, Function treapTest, DataSet... dataSet) {
        this.dataSet = dataSet;
        this.splayTest = splayTest;
        this.redBlackTest = redBlackTest;
        this.treapTest = treapTest;
    }

    public void printTableCompares() {
        for (int x = 0; x < dataSet.length; x++) {

            String metric = "Compares";

            String yAxis = "Beskr. " + dataSet[x].name;
            String indentation = "";
            for (int i = 0; i < yAxis.length(); i++) {
                if (i < metric.length()) {
                    indentation += metric.charAt(i);
                } else {
                    indentation += " ";
                }
            }

            indentation += " ";
            int SPTRCompares = splayTest.apply(dataSet[x]).compares;
            int REBTCompares = redBlackTest.apply(dataSet[x]).compares;
            int TREPCompares = new SplayTreeTest().testInsertAllAndRemoveAll(dataSet[x]).compares;

            String xAxis = indentation;

            xAxis += "TDST  RÖST  TREA";
            if (x == 0)
                System.out.println(xAxis);

            System.out.println(yAxis + " " + SPTRCompares + " " + REBTCompares + " " + TREPCompares);
        }
    }

    public void printTableHeight() {
        for (int x = 0; x < dataSet.length; x++) {
            String metric = "Height";
            String yAxis = "Beskr. " + dataSet[x].name;
            String indentation = "";

            for (int i = 0; i < yAxis.length(); i++) {
                if (i < metric.length()) {
                    indentation += metric.charAt(i);
                } else {
                    indentation += " ";
                }
            }
            indentation += " ";
            int SPTRHeight = splayTest.apply(dataSet[x]).height;
            int REBTHeight = redBlackTest.apply(dataSet[x]).height;
            int TREPHeight = treapTest.apply(dataSet[x]).height;

            String xAxis = indentation;

            xAxis += "TDST  RÖST  TREA";
            if (x == 0)
                System.out.println(xAxis);

            System.out.println(yAxis + " " + SPTRHeight + " " + REBTHeight + " " + TREPHeight);
        }
    }

    public void printTableRotations() {
        for (int x = 0; x < dataSet.length; x++) {
            String metric = "Rotations";
            String yAxis = "Beskr. " + dataSet[x].name;
            String indentation = "";
            
            for (int i = 0; i < yAxis.length(); i++) {
                if (i < metric.length()) {
                    indentation += metric.charAt(i);
                } else {
                    indentation += " ";
                }

            }
            indentation += " ";
            int SPTRRotations = splayTest.apply(dataSet[x]).rotations;
            int REBTRotation = redBlackTest.apply(dataSet[x]).rotations;
            int TREPRotation = treapTest.apply(dataSet[x]).rotations;

            String xAxis = indentation;

            xAxis += "TDST  RÖST  TREA";
            if (x == 0)
                System.out.println(xAxis);

            System.out.println(yAxis + " " + SPTRRotations + " " + REBTRotation + " " + TREPRotation);
        }
    }
}
