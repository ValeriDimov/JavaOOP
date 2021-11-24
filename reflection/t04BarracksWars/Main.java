package reflection.t03T04BarracksWars;

import reflection.t03T04BarracksWars.interfaces.Repository;
import reflection.t03T04BarracksWars.interfaces.Runnable;
import reflection.t03T04BarracksWars.interfaces.UnitFactory;
import reflection.t03T04BarracksWars.core.Engine;
import reflection.t03T04BarracksWars.core.factories.UnitFactoryImpl;
import reflection.t03T04BarracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
