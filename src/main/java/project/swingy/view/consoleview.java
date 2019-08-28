package project.swingy.view;

import java.util.Scanner;

public class consoleview {
    public consoleview(){

    }
    public static void graphic(){
        System.out.println(" __          _                   \n" +
                "/ _\\_      _(_)_ __   __ _ _   _ \n" +
                "\\ \\\\ \\ /\\ / / | '_ \\ / _` | | | |\n" +
                "_\\ \\\\ V  V /| | | | | (_| | |_| |\n" +
                "\\__/ \\_/\\_/ |_|_| |_|\\__, |\\__, |\n" +
                "                     |___/ |___/ ");

    }
    public static void start(){
        System.out.println("game has started and now you may pick your type");
    }
    public static void type(){
        System.out.println("North" + "East" + " South" + "West");
    }
    public static void direct(){
        System.out.println("Navigate the map via the directional commands:");
        Scanner scan = new Scanner(System.in);
        String dirvar = scan.nextLine();
        if (dirvar.equals()){

        }
        System.out.println("     North"+ "\n       |" + "\n" + "West  -" + " -   East"+ "\n       |" + "\n" + "     South");

        System.out.println("please choose a direction to move in");
    }
    public static void stats(){
//        "###--Name--:";Heroname(){}
//        "###--Type--:";HeroType(){}
//        "###--HP----:";HP(){}
//        "###--XP----:";Xp(){}
//        "###--Level-:";Level(){}

    }
}
