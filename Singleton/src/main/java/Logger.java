import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logger {
    private static Logger instance;
    private File file;
    private FileWriter writer;

    private Logger() {
        this.file = new File("log.txt");
        initializeWriter();
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFilename(String filename) {
        if (!this.file.getName().equals(filename)) {
            close();
            if (file.length() > 0) {
                File newFile = new File(filename);
                rewriteFile(newFile);
                if (this.file.delete()) System.out.println("Deleted the file: " + this.file.getName());
                this.file = newFile;

            } else this.file = new File(filename);
            initializeWriter();
        } else System.out.println("Filename is the same as the current one.");
    }

    public void writeToFile(String message) {
        try (FileWriter writer = new FileWriter(file.getName(), true)) {
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rewriteFile(File newFile) {
        if (file != null && file.length() > 0) {
            try (Scanner reader = new Scanner(file);
                 FileWriter tempWriter = new FileWriter(newFile)) {
                while (reader.hasNextLine()) {
                    String data = reader.nextLine();
                    tempWriter.write(data + "\n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void initializeWriter() {
        try {
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            if (writer != null) writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
