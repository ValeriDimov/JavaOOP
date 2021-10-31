package abstraction.t04TrafficLights;

import java.util.ArrayList;
import java.util.List;

public class TrafficLights {
    private Colors colors;

    public TrafficLights(Colors colors) {
        this.colors = colors;
    }

    public Colors getColors() {
        return colors;
    }

    public void changeColor(int numberOfChanges) {
        switch (this.colors.name()) {
            case "RED":
                this.colors = (Colors.GREEN);
                System.out.print(this.colors.name() + " ");
                break;
            case "GREEN":
                this.colors = Colors.YELLOW;
                System.out.print(this.colors.name() + " ");
                break;
            case "YELLOW":
                this.colors = (Colors.RED);
                System.out.print(this.colors.name() + " ");
                break;
        }
    }

}
