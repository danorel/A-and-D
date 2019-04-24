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
        System.out.println(container.countXChars("xxhixx"));
        System.out.println(container.countHiSubstrings("xhixhix"));
    }
}
