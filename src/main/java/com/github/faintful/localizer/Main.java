package com.github.faintful.localizer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputPrompter inputPrompter = new InputPrompter(System.out::println, scanner::nextLine);
        Localization inputFile = new Localization(inputPrompter);
//        System.out.println(inputFile.getInput());

        inputFile.isValidPath(inputFile.getInput());
//        System.out.println(inputFile.getInvalidPathException().getMessage());
        //TODO: InputPrompter must use the toString() method of the path class to get the inputted string to use for error messages. Use index as well. Parse in the index of the above error messages.
//        inputPrompter.promptInvalidInput(inputFile);
    }
}
