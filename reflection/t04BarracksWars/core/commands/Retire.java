package reflection.t03T04BarracksWars.core.commands;

import reflection.t03T04BarracksWars.interfaces.Repository;
import reflection.t03T04BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Retire extends Command {


    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = this.data[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
