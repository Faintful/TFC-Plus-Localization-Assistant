import java.util.function.Consumer;
import java.util.function.Supplier;

public class Prompter {

    private final Supplier<String> reader;
    private final Consumer<String> writer;

    public Prompter(Supplier<String> reader, Consumer<String> writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String promptForInput() {
        writer.accept("Please enter an input");
        return reader.get();
    }
}
