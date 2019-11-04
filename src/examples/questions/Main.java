package examples.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();
        for (String arg : args) {
            if (str.indexOf(arg) < 1)
                str.append(arg + " ");
        }
        System.out.println(str.toString());
        Scanner sc = new Scanner(str.toString());
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                System.out.print(sc.nextInt() + "");
            } else {
                sc.next();
            }
        }

    }


}
