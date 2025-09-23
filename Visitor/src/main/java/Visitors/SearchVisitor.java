package Visitors;


import Elements.*;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private final String searchName;
    private final List<File> matchingFiles = new ArrayList<>();

    public SearchVisitor(String searchName) {
        this.searchName = searchName;
    }

    public List<File> getMatchingFiles() {
        return matchingFiles;
    }

    public String getSearchName() {
        return searchName;
    }

    @Override
    public void visit(File file) {
        if (file.getName().contains(searchName)) matchingFiles.add(file);
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }
}
