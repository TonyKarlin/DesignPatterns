import Elements.*;
import Visitors.SearchVisitor;
import Visitors.SizeCalculatorVisitor;

public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");

        File file1 = new File("file1.txt", 100);
        File file2 = new File("file2.txt", 200);
        File file3 = new File("file3.txt", 300);

        root.addElement(dir1);
        root.addElement(file1);
        dir1.addElement(dir2);
        dir1.addElement(file2);
        dir2.addElement(file3);

        SizeCalculatorVisitor sizeCalc = new SizeCalculatorVisitor();
        root.accept(sizeCalc);
        System.out.println("Total size: " + sizeCalc.getTotalSize() + " bytes");

        SearchVisitor search = new SearchVisitor(".txt");
        root.accept(search);
        System.out.println("Files found matching (" + search.getSearchName() + "): ");
        for (File f : search.getMatchingFiles()) {
            System.out.println("- " + f.getName());
        }
    }
}
