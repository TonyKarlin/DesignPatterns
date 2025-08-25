import Interfaces.Components;
import org.w3c.dom.Node;

public class Main {
    public static void main(String[] args) throws Exception {
        // Class to remove bloated code from the main loop
        XMLBuilder builder = new XMLBuilder();
        builder.createDocument();   // Creates a document with a "root" element

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

        org.printSalary();

        // Adds an "organization" parent node to the XML tree.
        // If parent Node is null, the method uses "root" as the parent.
        Node orgNode = builder.addElement("organization", null, null);

        // Node to display the name of the organization.
        builder.addElement("name", org.getName(), orgNode);
        // Node to display total salary of the organization.
        builder.addElement("total_salary", (org.getSalary() + "€"), orgNode);

        // The nested for-loops run through the organization tree. Creating intermediate Nodes,
        // or leaf Nodes when reaching the last child. The inner loop adds "name" and "salary"
        // Nodes to the employees to display the relevant information.
        for (int i = 0; i < org.getChildCount(); i++) {
            Components department = org.getChild(i);
            Node departmentNode = builder.addElement("department", null, orgNode);
            builder.addElement("name", department.getName(), departmentNode);
            for (int j = 0; j < department.getChildCount(); j++) {
                Components emp = department.getChild(j);
                Node empNode = builder.addElement("employee", null, departmentNode);
                builder.addElement("name", emp.getName(), empNode);
                builder.addElement("salary", emp.getSalary() + "€", empNode);
            }
        }

        // Path to output XML file.
        String path = "C:\\Users\\tontt\\IdeaProjects\\DesignPatterns\\Composite\\src\\main\\java/output.xml";
        builder.writeToXML(path);
    }
}
