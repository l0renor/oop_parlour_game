package framework.data;

import framework.data.accessories.Accessory;
import framework.logic.AccessoryType;
import framework.logic.BasicAccessoryType;

public class TestAccessory extends Accessory {
   public TestAccessory(int sizeX, int sizeY, int posX, int posY, int layer, String pathToImage){
        super(sizeX,sizeY,posX, posY,layer, pathToImage);
        BasicAccessoryType.addNewAccessoryType(() -> "TestAccessory");
    }

    @Override
    public AccessoryType getAccessoryType() {
        return BasicAccessoryType.accessoryTypeFor("TestAccessory");
    }
}
