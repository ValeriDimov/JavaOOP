package reflection.t02BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while (!input.equals("END")) {
            String[] commandsAndValues = input.split("_");
            String command = commandsAndValues[0];
            int value = Integer.parseInt(commandsAndValues[1]);

            Method method = clazz.getDeclaredMethod(command, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);
            System.out.println(innerValue.get(blackBoxInt));

            input = scanner.nextLine();
        }
    }
}
