package AccessControl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final HashMap<String, Set<String>> accessMap = new HashMap<>();

    private AccessControlService() {
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void grantAccess(String user, String documentId) {
        accessMap.computeIfAbsent(documentId, k -> new HashSet<>()).add(user);
    }

    public boolean hasAccess(String user, String documentId) {
        return accessMap.getOrDefault(documentId, new HashSet<>()).contains(user);
    }

    public HashMap<String, Set<String>> getAccessMap() {
        return accessMap;
    }
}

