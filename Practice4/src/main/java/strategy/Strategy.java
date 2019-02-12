package strategy;

import strategy.algorithms.*;

import java.util.*;

public class Strategy<T extends Comparable>{
    private ArrayList<Sort> sortContainer;
    private Sort sortStrategy;
    private String content = "";

    public Strategy(){
        sortContainer = new ArrayList<>();
        sortContainer.add(new BubbleSort());
        sortContainer.add(new CombSort());
        sortContainer.add(new HeapSort());
        sortContainer.add(new InsertionSort());
        sortContainer.add(new MergeSort());
        sortContainer.add(new QuickSort());
        sortContainer.add(new SelectionSort());
        sortContainer.add(new ShellSort());
    }

    public String getAlgorithmsRuntimeData(T []Array){
        StringBuilder result = new StringBuilder();
        for(Sort sort : sortContainer){
            result.append(setSortStrategy(sort).sort(Array).writeResults(Array, sort.toString()));
        }
        return result.toString();
    }

    public Strategy sort(T []Array){
        sortStrategy.sort(Array);
        return this;
    }

    public Strategy setSortStrategy(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
        return this;
    }

    private String writeResults(T []Array, String sortName){
        StringBuilder builder = new StringBuilder();
        builder.append(sortName);
        Arrays.asList(Array)
                .forEach(element -> {
                    builder.append(element).append(" ");
                });
        builder.append(":");
        content += builder.toString();
        return content;
    }

    public String getAlgorithmsRuntimeTable(T []Array){
        String content = getAlgorithmsRuntimeData(Array);
        List<String> tokens = Arrays.asList(content.split("\\:"));
        ArrayList<String> sortResults = new ArrayList<>();
        for(int index = 0; index < tokens.size(); index++){
            if(index % 2 == 0){
                sortResults.add(tokens.get(index));
            }
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(sortResults(sortResults).entrySet());
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Double> entry : list){
            result.append(entry.getKey() + ": " + entry.getValue()).append("\n");
        }
        return result.toString();
    }

    private HashMap<String, Double> sortResults(ArrayList<String> sortResults){
        HashMap<String, Double> times = new HashMap<>();
        for (int index = 0; index < sortResults.size() - 1; index++) {
            String []parts = sortResults.get(index).split("\\|");
            times.put(parts[0], Double.valueOf(parts[1]));
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(times.entrySet());
        list.sort(Map.Entry.comparingByValue());
        Map<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return (HashMap<String, Double>) result;
    }
}
