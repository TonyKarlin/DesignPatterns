import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private final String path = "C:\\Users\\tonyk\\IdeaProjects\\DesignPatterns\\Singleton\\src\\main\\java";
    private File file;
    private final List<String> logs = new ArrayList<>();
    private FileWriter writer;

    private Logger() {
        this.file = new File(path, "log.txt");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFilename(String filename) {
        if (!this.file.getName().equals(filename)) {
            File newFile = new File(path, filename);
            close();
            boolean deleted = file.delete();
            if (!deleted) {
                System.err.println("Failed to delete file: " + file.getAbsolutePath());
            }
            this.file = newFile;
            if (!logs.isEmpty()) rewriteFile();
        } else System.out.println("Filename is the same as the current one.");
    }

    public void writeToFile(String message) {
        try {
            writer = new FileWriter(file.getName(), true);
            writer.write(message + "\n");
            if (!logs.contains(message)) {
                logs.add(message);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteFile() {
        try {
            writer = new FileWriter(file.getName(), true);
            for (String log : logs) {
                writer.write(log + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
