package sortingClean;


import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;

// TODO: Add java classes (in separate files for annotations and aspects)
public class MainApp {
    private static WeldContainer container;
    public static void main(String[] args) {
        container = new Weld().initialize();
        // TODO: Change this line to initialize an injected sortingClean.AlgorithmRunner
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();

        algorithmRunner.runAlgorithms();
    }
    @Produces
    public @Named("Hc")  SortingAlgorithm<Integer> GetBubbleSort(){
        return container.select(BubbleSort.class).get();
    }

    @Produces
    public @Named("Lc")  SortingAlgorithm<Integer> GetQuickSort(){
        return container.select(QuickSort.class).get();
    }
}
