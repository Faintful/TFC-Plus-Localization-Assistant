package com.github.faintful.localizer;

import java.nio.file.InvalidPathException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class InputPrompter {

    private final Consumer<String> writer;
    private final Supplier<String> reader;

    public InputPrompter(Consumer<String> writer, Supplier<String> reader) {
        this.writer = writer;
        this.reader = reader;
    }

    public String promptForInput() {
        writer.accept("Please enter an input:");
        return reader.get();
    }

    public void promptInvalidExtension() {

    }
}