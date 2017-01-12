package intellijbugs;

public class CanBeMadeLocal {
    private final String a;  // should warn that 'a' can be made local
    private final String b;  // does warn that 'b' can be made local

    private CanBeMadeLocal() {
        a = "a";
        b = "b";

        System.out.println(a);
        System.out.println(b);

        // With these lines, IntelliJ does not recognize that 'a' can be made local.
        // Behavior is same when using anonymous class instead of λ
        Runnable runnable = () -> System.out.println(a);
        runnable.run();
    }

    // eliminate scope warning
    public static void main(String[] args) {
        new CanBeMadeLocal();
    }
}
