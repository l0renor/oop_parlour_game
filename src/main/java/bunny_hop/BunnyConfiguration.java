package bunny_hop;

import framework.configuration.Configuration;

public class BunnyConfiguration extends Configuration {
    public void configureBoard() {
        super.setBoard( new BunnyLayout().createLayout());
    }
}
