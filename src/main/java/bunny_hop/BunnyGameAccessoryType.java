package bunny_hop;

import framework.logic.AccessoryType;
import framework.logic.BasicAccessoryType;

public enum BunnyGameAccessoryType implements AccessoryType {
    BUNNY("BUNNY"),
    FIELD("FIELD"),
    CARROT("CARROT");

    private String accessoryTypeName;

    BunnyGameAccessoryType(String accessoryTypeName) {
        this.accessoryTypeName = accessoryTypeName;
        BasicAccessoryType.addNewAccessoryType(this);
    }

    @Override
    public String getAccessoryTypeName() {
        return accessoryTypeName;
    }
}
