public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.writeToFile("First log message");
        logger.setFilename("toimiiko.txt");
        logger.writeToFile("Second log message");
        logger.setFilename("toimii.txt");
        logger.writeToFile("Third log message");
        logger.close();
    }
}
