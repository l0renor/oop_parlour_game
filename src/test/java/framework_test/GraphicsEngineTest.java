package framework_test;

import framework.graphics.GraphicsEngine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GraphicsEngineTest {
    @Test
    void singletonTest(){
        GraphicsEngine graphicsEngineOne = GraphicsEngine.getInstance();
        GraphicsEngine graphicsEngineTwo = GraphicsEngine.getInstance();
        assertEquals(graphicsEngineOne,graphicsEngineTwo);

    }
}
