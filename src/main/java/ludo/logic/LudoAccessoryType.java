package ludo.logic;

import framework.data.AccessoryType;
import framework.logic.BasicAccessoryType;

public enum LudoAccessoryType implements AccessoryType {
    PAWN("PAWN");

    private String accessoryTypeName;

    LudoAccessoryType(String accessoryTypeName) {
        this.accessoryTypeName = accessoryTypeName;
        BasicAccessoryType.addNewAccessoryType(this);
    }

    @Override
    public String getAccessoryTypeName() {
        return accessoryTypeName;
    }
}
