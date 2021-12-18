package catHouse;

import catHouse.core.Controller;
import catHouse.core.ControllerImpl;
import catHouse.core.Engine;
import catHouse.core.EngineImpl;

public class Main {
    public static void main(String[] args) {

        Controller controller = new ControllerImpl();

        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
