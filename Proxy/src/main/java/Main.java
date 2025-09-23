import AccessControl.AccessControlService;
import AccessControl.AccessDeniedException;
import AccessControl.User;
import Documents.Library;
import Documents.RealDocument;

public class Main {
    public static void main(String[] args) {
        User user = new User("Bob");
        User admin = new User("Admin");
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        RealDocument doc1 = new RealDocument("1", "2025-23-09", "Ei mitään kummallista");
        library.addDocument(doc1);

        library.createProtectedDocument("2", "2025-23-09", "Tosi salaista..");

        acs.grantAccess("Admin", "2");

        try {
            System.out.println("(User) content: " + library.getDocument("1").getContent(user.getUsername()));
            System.out.println("(Admin) content: " + library.getDocument("1").getContent(admin.getUsername()));
            System.out.println("(Admin) content: " + library.getDocument("2").getContent(admin.getUsername()));
            System.out.println("(User) content: " + library.getDocument("2").getContent(user.getUsername()));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }
    }
}
