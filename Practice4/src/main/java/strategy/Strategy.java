package strategy;

import file.FileManager;
import strategy.algorithms.*;

import java.util.*;

public class Strategy<T extends Comparable>{
    private ArrayList<Sort> sortContainer;
    private Sort sortStrategy;
    private T[] Array;
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

    public void testAlgorithms(T []Array, String src){
        this.Array = Array;
        for(Sort sort : sortContainer){
            setSortStrategy(sort).sort().writeResults(sort.toString(), src);
            this.Array = Array;
        }
    }

    public Strategy sort(){
        sortStrategy.sort(Array);
        return this;
    }

    public Strategy setSortStrategy(Sort sortStrategy) {
        this.sortStrategy = sortStrategy;
        return this;
    }

    private void writeResults(String sortName, String src){
        StringBuilder builder = new StringBuilder();
        builder.append(sortName);
        Arrays.asList(Array)
                .forEach(element -> {
                    builder.append(element).append(" ");
                });
        builder.append(":");
        content += builder.toString();
        FileManager.writeFile(src, content);
    }

    public List<Map.Entry<String, Double>> getResults(String src){
        String content = FileManager.readFile(src);
        List<String> parts = Arrays.asList(content.split("\\:"));
        ArrayList<String> results = new ArrayList<>();
        for(int index = 0; index < parts.size(); index++){
            if(index % 2 == 0){
                results.add(parts.get(index));
            }
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(sortResults(results).entrySet());
        return list;
    }

    private HashMap<String, Double> sortResults(ArrayList<String> results){
        HashMap<String, Double> times = new HashMap<>();
        for (int index = 0; index < results.size() - 1; index++) {
            String []parts = results.get(index).split("\\|");
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
