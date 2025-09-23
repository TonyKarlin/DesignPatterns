package Documents;

import AccessControl.AccessControlService;
import AccessControl.AccessDeniedException;

public class DocumentProxy implements Document {
    private final RealDocument realDocument;
    private final AccessControlService accessControl;

    public DocumentProxy(RealDocument realDocument) {
        this.realDocument = realDocument;
        this.accessControl = AccessControlService.getInstance();
    }

    public RealDocument getContent() {
        return realDocument;
    }


    @Override
    public String getId() {
        return realDocument.getId();
    }

    @Override
    public String getCreationDate() {
        return realDocument.getCreationDate();
    }

    @Override
    public String getContent(String user) {
        if (!accessControl.hasAccess(user, realDocument.getId())) {
            throw new AccessDeniedException("Access denied for user: " + user);
        }
        return realDocument.getContent(user);
    }
}
