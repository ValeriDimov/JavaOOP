package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission {


    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        List<String> stateExhibits = new ArrayList<>(state.getStateExhibits());
        List<Explorer> explorersList = new ArrayList<>(explorers);

        for (Explorer explorer : explorersList) {

           while (explorer.canSearch() && stateExhibits.iterator().hasNext()) {
               explorer.search();
               String currentExhibit = stateExhibits.iterator().next();
               explorer.getSuitcase().getExhibits().add(currentExhibit);
               stateExhibits.remove(currentExhibit);
           }
        }
    }
}
