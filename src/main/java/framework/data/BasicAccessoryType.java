package framework.data;

import java.util.TreeMap;

public enum BasicAccessoryType implements AccessoryType {
    CARD_DECK("CARD_DECK"),
    DICE("DICE");

    private final String accessoryTypeName;
    private static TreeMap<String, AccessoryType> map = new TreeMap<>();

    BasicAccessoryType(String accessoryTypeName) {
        this.accessoryTypeName = accessoryTypeName;
    }

    @Override
    public String getAccessoryTypeName() {
        return accessoryTypeName;
    }

    static {
        for (AccessoryType type : values()) {
            map.put(type.getAccessoryTypeName(), type);
        }
    }

    public static AccessoryType accessoryTypeFor(String accessoryTypeName) {
        return map.get(accessoryTypeName);
    }

    public static boolean addNewAccessoryType(AccessoryType accessoryType) {
        if (map.containsKey(accessoryType.getAccessoryTypeName())) {
            return false;
        } else {
            map.put(accessoryType.getAccessoryTypeName(), accessoryType);
            return true;
        }
    }
}