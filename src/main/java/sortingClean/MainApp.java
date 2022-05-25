package sortingClean;


import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Random;

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

    @Produces
    public @Named("Rc")  SortingAlgorithm<Integer> GetRandomSort(){
        return makeRandomSortingAlgorithm();
    }

    @Produces
    public @Size int GetSize(){return 10000;}
    private static SortingAlgorithm<Integer> makeRandomSortingAlgorithm(){
        Random random = new Random(System.currentTimeMillis());
        SortingAlgorithm<Integer> sortAlg= null;
        switch (random.nextInt(4)){
            case 0: sortAlg = container.select(QuickSort.class).get();
                break;
            case 1: sortAlg = container.select(MergeSort.class).get();
                break;
            case 2: sortAlg = container.select(BubbleSort.class).get();
                break;
            case 3: sortAlg = container.select(InsertionSort.class).get();
        }
        return sortAlg;
    }
}
