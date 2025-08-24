import Interfaces.Components;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

public class Organization extends Components {
    protected String name;
    protected double salary;
    private final List<Components> children = new ArrayList<>();

    public Organization(String name) {
        super(name);

    }

    public String getName() {
        return name;
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
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = builder.newDocument();
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
        System.out.println("Total amount of salaries: " + totalSalary);


        Node orgNode = document.createElement("organization");
        orgNode.appendChild(document.createTextNode(org.getName()));
        root.appendChild(orgNode);

        for (int i = 0; i < org.getChildCount(); i++) {
            Components department = org.getChild(i);
            Node departmentNode = orgNode.appendChild(document.createTextNode(department.getName()));
            for (int j = 1; j < department.getChildCount(); j++) {
                Components emp = department.getChild(j);
                Node empNode = document.createElement("employee");
                empNode.appendChild(document.createTextNode((emp.getName()) + " - " + emp.getSalary()));
                departmentNode.appendChild(empNode);
            }
            orgNode.appendChild(departmentNode);
        }
    }
}
