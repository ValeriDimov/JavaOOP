package reflection.t03T04BarracksWars.core.commands;

import reflection.t03T04BarracksWars.interfaces.Repository;
import reflection.t03T04BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {


    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = this.data[1];
        Object unitToAdd = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
