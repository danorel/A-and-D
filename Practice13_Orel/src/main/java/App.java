public class App {
    public static void main(String[] args) {
        TaskContainer container = new TaskContainer();
        System.out.println(container.factorial(5));
        System.out.println(container.bunnyEars(2));
        System.out.println(container.triangle(2));
        System.out.println(container.digitsSummary(126));
        System.out.println(container.countSevenDigits(123));
        System.out.println(container.countEightDigits(88888));
        System.out.println(container.power(3,3));
        System.out.println(container.getXAmount("xxhixx"));
        System.out.println(container.getHiFrequency("xhixhix"));
        System.out.println(container.substituteXtoY("yyhxyi"));
        System.out.println(container.substitutePI("xpix"));
        System.out.println(container.extractAllX("xx"));
        System.out.println(container.isSixExists(new int[]{5, 3, 1, 0, 6}, 2));
        System.out.println(container.getElevenAmount(new int[]{1, 2, 11}, 0));
        System.out.println(container.isUniqueSequence(new int[]{1, 2, 20}, 0));
        System.out.println(container.borderWithStars("hello"));
    }
}
