package interfacesAndAbstraction.t02MultipleImplementation;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Method[] methods;
        methods = Identifiable.class.getDeclaredMethods();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String id = scanner.nextLine();
        String birthDate = scanner.nextLine();
        Identifiable identifiable = new Citizen(name, age, id, birthDate);
        Birthable birthable = new Citizen(name, age, id, birthDate);
        System.out.println(methods.length);
        System.out.println(methods[0].getReturnType().getSimpleName());
        System.out.println(methods.length);
        System.out.println(methods[0].getReturnType().getSimpleName());
    }
}

