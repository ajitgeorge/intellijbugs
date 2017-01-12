package intellijbugs;

import java.util.function.Consumer;

public class CanBeMadeLocal {
    private final Consumer<String> a;  // should warn that 'a' can be made local
    private final Consumer<String> b;  // does warn that 'b' can be made local

    private CanBeMadeLocal() {
        a = t -> {};
        b = t -> {};

        a.accept(null);
        b.accept(null);

        // With these lines, IntelliJ does not recognize that 'a' can be made local.
        Runnable runnable = () -> a.accept("");
        runnable.run();
    }

    // eliminate scope warning
    public static void main(String[] args) {
        new CanBeMadeLocal();
    }
}
