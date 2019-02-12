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
        ArrayList<String> results = new ArrayList<>();
        for(int index = 0; index < tokens.size(); index++){
            if(index % 2 == 0){
                results.add(tokens.get(index));
            }
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(getSortedResults(results).entrySet());
        StringBuilder result = new StringBuilder();
        for(Map.Entry<String, Double> entry : list){
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }

    private HashMap<String, Double> getSortedResults(ArrayList<String> sortResults){
        sortResults.remove(sortResults.size() - 1);
        HashMap<String, Double> sortData = new HashMap<>();
        for (int index = 0; index < sortResults.size(); index++) {
            String []tokens = sortResults.get(index).split("\\|");
            sortData.put(tokens[0], Double.valueOf(tokens[1]));
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(sortData.entrySet());
        list.sort(Map.Entry.comparingByValue());
        HashMap<String, Double> result = new LinkedHashMap<>();
        for (Map.Entry<String, Double> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
