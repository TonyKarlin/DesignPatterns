import Interfaces.Components;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.util.ArrayList;
import java.util.List;

public class Organization extends Components {
    protected double salary;
    private final List<Components> children = new ArrayList<>();

    public Organization(String name) {
        super(name);

    }

    @Override
    public double getSalary() {
        for (Components child : children) {
            this.salary += child.getSalary();
        }
        return this.salary;
    }

    @Override
    public void add(Components component) {
        this.children.add(component);
    }

    @Override
    public void remove(Components component) {
        this.children.remove(component);
    }

    @Override
    public Components getChild(int index) {
        return this.children.get(index);
    }

    @Override
    public int getChildCount() {
        return children.size();
    }

    public static void main(String[] args) throws Exception {
        XMLBuilder builder = new XMLBuilder();
        Document document = builder.createDocument();

        Element root = document.createElement("root");
        document.appendChild(root);

        Components org = new Organization("Apple");
        Components dep1 = new Department("HR");
        Components dep2 = new Department("Sales");
        Components emp1 = new Employee("Alice", 50000);
        Components emp2 = new Employee("Bob", 48000);
        Components emp3 = new Employee("Carl", 89000);

        dep1.add(emp1);
        dep1.add(emp2);
        dep2.add(emp3);
        org.add(dep1);
        org.add(dep2);

        double totalSalary = org.getSalary();

        Node orgNode = builder.addElement("organization", null, root, document);

        builder.addElement("name", org.getName(), orgNode, document);
        builder.addElement("total_salary", (totalSalary + "€"), orgNode, document);

        for (int i = 0; i < org.getChildCount(); i++) {
            Components department = org.getChild(i);
            Node departmentNode = builder.addElement("department", null, orgNode, document);
            builder.addElement("name", department.getName(), departmentNode, document);
            for (int j = 0; j < department.getChildCount(); j++) {
                Components emp = department.getChild(j);
                Node empNode = builder.addElement("employee", null, departmentNode, document);
                builder.addElement("name", emp.getName(), empNode, document);
                builder.addElement("salary", emp.getSalary() + "€", empNode, document);
            }
        }

        String path = "C:\\Users\\tontt\\IdeaProjects\\DesignPatterns\\Composite\\src\\main\\java/output.xml";
        builder.writeToXML(path, document);
    }
}
