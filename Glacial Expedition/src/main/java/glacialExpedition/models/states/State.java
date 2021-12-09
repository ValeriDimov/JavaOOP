package glacialExpedition.models.states;

import java.util.Collection;

public interface State {
    Collection<String> getStateExhibits();

    String getName();
}
