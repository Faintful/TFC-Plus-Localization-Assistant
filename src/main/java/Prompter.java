import java.util.function.Consumer;
import java.util.function.Supplier;

// General interface for prompters, open for implementation
public interface Prompter {
    public String read();
    public void write(String string);

    public default String promptForInput() {
        write("Please enter an input:");
        return read();
    }

    public static Prompter readOnly(String string) {
        return Pure(string);
    }

    public static class Pure implements Prompter {
        private final String value;

        public Pure(String value) {
            this.value = value;
        }

        @Override
        public String read() {
            return value;
        }

        @Override
        public void write(String string) {
            return;
        }
    }

    // Nice utility prompter, premade console
    // Might even be friendlier than reading normally with new Scanner
    // Usage: Prompter.CONSOLE.write("REEEEEEE")
    // This implements Prompter and provides the 2 methods
    // If Prompter wasn't an interface, it would create 3 new objects (Prompter, Consumer, Producer)
    // But since it's only implementing methods (not functions which are objects)
    // It's only creating 1 object :) 
    public static final CONSOLE = new Prompter {
        private Scanner scanner = new Scanner(System.in);

        @Override
        public String read() {
            return scanner.readLine();
        }

        @Override
        public void write(String string) {
            System.out.println(string);
        }
    }
    
    // Functional implementation of Prompter
    // Usage: new Prompter.Functional((str) -> ..., () -> ...)
    public static class Functional implements Prompter {
        // Those 2 fields are immutable,
        // there is no harm in making them public
        private final Consumer<String> writer;
        private final Supplier<String> reader;

        public Prompter(Consumer<String> writer, Supplier<String> reader) {
            this.reader = reader;
            this.writer = writer;
        }

        @Override
        public String read() {
            return reader.get();
        }

        @Override
        public void write(String string) {
            writer.accept(string);
        }
    }
}
