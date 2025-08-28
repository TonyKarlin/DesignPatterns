public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.writeToFile("First log message");
        logger.writeToFile("Second log message");

        logger.setFilename("test.txt");
    }
}
