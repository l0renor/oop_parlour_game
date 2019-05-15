package bunny_hop;

import framework.logic.AccessoryType;
import framework.logic.BasicAccessoryType;

public enum BunnyGameAccessoryType implements AccessoryType {
    Bunny("Bunny"),
    Field("Field"),
    Carrot("Carrot");

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
