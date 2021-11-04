package abstraction.t04TrafficLights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] multipleTrafficLights = scanner.nextLine().split("\\s+");
        int numberOfChanges = Integer.parseInt(scanner.nextLine());
        List<TrafficLights> trafficLights = new ArrayList<>();

        TrafficLights light = null;
        for (String inputLight : multipleTrafficLights) {
            light = new TrafficLights(Colors.valueOf(inputLight));
            trafficLights.add(light);
        }
        for (int i = 0; i < numberOfChanges; i++) {
            for (TrafficLights trafficLight : trafficLights) {
                trafficLight.changeColor(numberOfChanges);
            }
            System.out.println();
        }

    }
}
