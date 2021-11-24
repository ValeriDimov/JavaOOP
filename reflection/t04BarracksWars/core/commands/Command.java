package reflection.t03T04BarracksWars.core.commands;

import reflection.t03T04BarracksWars.interfaces.Executable;
import reflection.t03T04BarracksWars.interfaces.Repository;
import reflection.t03T04BarracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

    protected String[] data;
    protected Repository repository;
    protected UnitFactory unitFactory;

    public Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public Repository getRepository() {
        return repository;
    }

    public void setRepository(Repository repository) {
        this.repository = repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }

    public void setUnitFactory(UnitFactory unitFactory) {
        this.unitFactory = unitFactory;
    }
}