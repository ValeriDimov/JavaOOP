package reflection.t03T04BarracksWars.core.commands;

import reflection.t03T04BarracksWars.interfaces.Repository;
import reflection.t03T04BarracksWars.interfaces.UnitFactory;

public class Fight extends Command {


    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}

