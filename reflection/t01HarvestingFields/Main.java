package reflection.t01HarvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] declaredFields = clazz.getDeclaredFields();

        while (!input.equals("HARVEST")) {
            switch (input) {
                case "public":
                    for (Field fieldPublic : declaredFields) {
                        if (Modifier.isPublic(fieldPublic.getModifiers())) {
                            printField(fieldPublic);
                        }
                    }
                    break;
                case "protected":
                    for (Field fieldProtected : declaredFields) {
                        if (Modifier.isProtected(fieldProtected.getModifiers())) {
                            printField(fieldProtected);
                        }
                    }
                    break;
                case "private":
                    for (Field fieldPrivate : declaredFields) {
                        if (Modifier.isPrivate(fieldPrivate.getModifiers())) {
                            printField(fieldPrivate);
                        }
                    }
                    break;
                case "all":
                    for (Field fieldProtected : declaredFields) {
                        printField(fieldProtected);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static void printField(Field field) {
        System.out.printf("%s %s %s%n",
                Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName());
    }
}
