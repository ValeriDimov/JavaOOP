package glacialExpedition.models.states;

import glacialExpedition.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StateImpl implements State {
    private String name;
    private Collection<String> stateExhibits;

    public StateImpl(String name) {
        setName(name);
        stateExhibits = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.STATE_NAME_NULL_OR_EMPTY);
        }

        this.name = name;
    }

    @Override
    public Collection<String> getStateExhibits() {
        return new ArrayList<>(stateExhibits);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
