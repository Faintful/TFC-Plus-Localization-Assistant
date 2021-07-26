package com.github.faintful.localizer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Localization inputFile = new Localization(new Prompter(System.out::println, scanner::nextLine));
        System.out.println(inputFile.getInput());
    }
}
