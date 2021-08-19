package com.github.faintful.localizer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Prompter prompter = new Prompter(System.out::println, scanner::nextLine);
        Localization inputFile = new Localization(prompter);
//        System.out.println(inputFile.getInput());

        inputFile.isValidPath(inputFile.getInput());
//        System.out.println(inputFile.getInvalidPathException().getMessage());
        //TODO: Prompter must use the toString() method of the path class to get the inputted string to use for error messages. Use index as well. Parse in the index of the above error messages.
        prompter.promptInvalidInput(inputFile);
    }
}
