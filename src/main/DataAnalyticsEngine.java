package main;

import main.infrastructure.lhc.detector.Detector;
import main.infrastructure.lhc.detector.IDetector;
import main.infrastructure.lhc.experiment.IBlock;
import main.infrastructure.lhc.experiment.IExperiment;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DataAnalyticsEngine {
    public static void main(String[] args) {
        IDetector detector = new Detector();

        uniqueBlocksWithPound(detector.getExperimentList());
        uniqueBlocksEndingWithZ(detector.getExperimentList());
        uniqueBlocksStartWithAContains9EndsWithZ(detector.getExperimentList());
        uniqueBlocksWithCharsAB(detector.getExperimentList());
        uniqueBlocksGroupsWithAbcAndOther(detector.getExperimentList());
    }

    /*
    [01] Zählen der eindeutigen Blöcke mit mindestens einem Zeichen # an einer beliebigen Stelle.
     */
    public static void uniqueBlocksWithPound(List<IExperiment> experimentList) {
        System.out.println("[01] Zählen der eindeutigen Blöcke mit mindestens einem Zeichen # an einer beliebigen Stelle.");

        Predicate<IBlock> blockContainsPound = block -> block.getStructure().contains("#");

        System.out.println(experimentList.stream()
                .mapToInt(experiment -> (int) experiment.getBlocks().stream()
                        .filter(blockContainsPound)
                        .distinct()
                        .count())
                .sum());

        System.out.println("");
    }

    /*
    [02] Selektion der eindeutigen Blöcke welche mit dem Zeichen z enden.
     */
    public static void uniqueBlocksEndingWithZ(List<IExperiment> experimentList) {
        System.out.println("[02] Selektion der eindeutigen Blöcke welche mit dem Zeichen z enden.");

        Predicate<IBlock> blockEndsWithZ = block -> block.getStructure().endsWith("z");

        experimentList.stream()
                .map(experiment -> experiment.getBlocks().stream()
                        .filter(blockEndsWithZ)
                        .map(e -> e.getStructure())
                        .distinct()
                        .collect(Collectors.joining("  ")))
                .forEach(System.out::println);

        System.out.println("");
    }

    /*
    [03] Aufsteigende Sortierung der eindeutigen Blöcke, welche mit dem Zeichen a beginnen,
         die Ziffer 9 an einer beliebigen Stelle enthalten und mit dem Zeichen z enden.
     */
    public static void uniqueBlocksStartWithAContains9EndsWithZ(List<IExperiment> experimentList) {
        System.out.println("[03] Aufsteigende Sortierung der eindeutigen Blöcke, welche mit dem Zeichen a beginnen, " +
            "die Ziffer 9 an einer beliebigen Stelle enthalten und mit dem Zeichen z enden.");

        Predicate<IBlock> blockStartsWithA = block -> block.getStructure().startsWith("a");
        Predicate<IBlock> blockContains9 = block -> block.getStructure().contains("9");
        Predicate<IBlock> blockEndsWithZ = block -> block.getStructure().endsWith("z");

        Comparator<String> stringComparator = (String str1, String str2) -> str1.compareTo(str2);

        experimentList.stream()
                .map(experiment -> experiment.getBlocks().stream()
                        .filter(blockStartsWithA)
                        .filter(blockContains9)
                        .filter(blockEndsWithZ)
                        .map(e -> e.getStructure())
                        .distinct()
                        .sorted()
                        .collect(Collectors.joining("  ")))
                .forEach(System.out::println);

        System.out.println("");
    }

    /*
    [04] Gruppierung der eindeutigen Blöcke, welche die Zeichenfolge 'ab' an einer beliebigen Stelle enthalten.
     */
    public static void uniqueBlocksWithCharsAB(List<IExperiment> experimentList) {
        System.out.println("[04] Gruppierung der eindeutigen Blöcke, welche die Zeichenfolge 'ab' an einer " +
            "beliebigen Stelle enthalten.");

        Predicate<IBlock> blockContainsAB = block -> block.getStructure().contains("ab");

        experimentList.forEach(exp -> exp.getBlocks().stream()
                        .filter(blockContainsAB)
                        .map(e -> e.getStructure())
                        .distinct()
                        .collect(Collectors.groupingBy(b -> b.charAt(0)))
                    .forEach((k, v) -> System.out.println(k + ":" + v)));
        System.out.println("");
    }

    /*
    [05] Partionierung der eindeutigen Blöcke in zwei Gruppen [i] (true) Block started mit a,b,c
         und [ii] (false) alle anderen.
    */
    public static void uniqueBlocksGroupsWithAbcAndOther(List<IExperiment> experimentList) {
        System.out.println("[05] Partionierung der eindeutigen Blöcke in zwei Gruppen [i] (true) Block started mit" +
                " a,b,c und [ii] (false) alle anderen.");

        Predicate<String> blockContainsAorBorC = struct -> struct.matches(".*(a|b|c).*");

        experimentList.forEach(experiment -> experiment.getBlocks().stream()
                .map(e -> e.getStructure())
                .distinct()
                .collect(Collectors.partitioningBy(blockContainsAorBorC))
                .forEach((k, v) -> System.out.println(k + " : " + v.size() + " " + v.subList(0, 99) + ", ...")));
        System.out.println("");
    }
}
