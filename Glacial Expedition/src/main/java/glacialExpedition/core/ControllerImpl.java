package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private int exploredStates;
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer = null;

        switch (type) {

            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;

            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;

            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        state.getStateExhibits().add(Arrays.toString(exhibits));

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {

        Explorer explorer = this.explorerRepository.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }

        explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        List<Explorer> topExplorers = explorerRepository.getCollection()
                .stream()
                .filter(e -> e.getEnergy() > 50)
                .collect(Collectors.toList());

        if (topExplorers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }

        State state = stateRepository.byName(stateName);

        Mission mission = new MissionImpl();
        mission.explore(state, topExplorers);
        exploredStates++;

        long retiredExplorers = topExplorers.stream().filter(e -> e.getEnergy() == 0).count();

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);

    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, this.exploredStates));
        result.append(System.lineSeparator());
        result.append(ConstantMessages.FINAL_EXPLORER_INFO);

        List<Explorer> explorers = new ArrayList<>(explorerRepository.getCollection());
        for (Explorer explorer : explorers) {
            result.append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()));
            result.append(System.lineSeparator());
            result.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()));
            result.append(System.lineSeparator());
            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }
        }
        return result.toString();

    }
}
