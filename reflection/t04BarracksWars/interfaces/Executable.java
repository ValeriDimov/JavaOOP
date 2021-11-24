package reflection.t03T04BarracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ExecutionControl.NotImplementedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
