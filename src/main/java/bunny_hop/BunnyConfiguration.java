package bunny_hop;

import framework.configuration.Configuration;

public class BunnyConfiguration extends Configuration {
    public void configure() {
        setStartBoard( new BunnyLayout().createLayout());
    }
}
