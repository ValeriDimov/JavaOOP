package reflection.t03T04BarracksWars.core.factories;

import reflection.t03T04BarracksWars.interfaces.Unit;
import reflection.t03T04BarracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"reflection.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Unit unit = null;
		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
			unit = (Unit) constructor.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return unit;
	}
}
