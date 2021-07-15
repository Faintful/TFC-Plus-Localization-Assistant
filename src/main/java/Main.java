import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Localization inputFile = new Localization(new Prompter(scanner::nextLine, System.out::println));
        System.out.println(inputFile.getInput());
    }
}
