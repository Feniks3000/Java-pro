package lesson5_racing_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Track {
    private ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Track(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    @Override
    public String toString() {
        return String.format("{%s}", stages.stream().map(stage -> stage.description).collect(Collectors.joining(", ")));
    }
}