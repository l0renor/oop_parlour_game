package framework.configuration;

public class TestConfiguration extends Configuration {
    public void configureBoard() {
        board = new TestLayout().createLayout();
    }
}
