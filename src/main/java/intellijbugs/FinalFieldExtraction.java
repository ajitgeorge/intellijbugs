package intellijbugs;

public class FinalFieldExtraction {
    // extracting 'a' to field from the constructor below produces a final field, which is incorrect because 'a' isn't always initialized
    private final int a;

    private FinalFieldExtraction() {
        if (Math.random() < 0) {
            a = 5;
            System.out.println(a);
        }
    }

    // eliminate scope warning
    public static void main(String[] args) {
        new FinalFieldExtraction();
    }
}
