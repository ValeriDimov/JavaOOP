package barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Object unit);

	String getStatistics();

	void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
