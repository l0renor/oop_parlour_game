package framework.configuration;

public class TestConfiguration extends Configuration {
    public void configureBoard() {
        super.setBoard( new TestLayout().createLayout());
    }
}
