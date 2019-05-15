package framework.logic;

import java.util.TreeMap;

public enum BasicAccessoryType implements AccessoryType {
    CARD_DECK("CARD_DECK"),
    DICE("DICE");

    private final String accessoryTypeName;
    private static TreeMap<String, AccessoryType> map = new TreeMap<String, AccessoryType>();

    BasicAccessoryType(String accessoryTypeName) {
        this.accessoryTypeName = accessoryTypeName;
    }

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

    public static void addNewAccessoryType(AccessoryType accessoryType) {
        if (!map.containsKey(accessoryType.getAccessoryTypeName())) {
            map.put(accessoryType.getAccessoryTypeName(), accessoryType);
        }
    }

}
