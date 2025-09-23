package Elements;

import Visitors.FileSystemVisitor;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
