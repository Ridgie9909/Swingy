package project.swingy.view;

import java.io.IOException;
import java.util.Scanner;

import java.lang.*;
//toLowerCase;

public class console {

    public static Scanner playscan = new Scanner(System.in);

    public console() {

    }

    public static void conreader() {
        System.out.println("Swingy console is now running");
        System.out.println("please feed some data");

        String pdata = playscan.nextLine();
        System.out.println(pdata);
//        readercon();
        try {
            if (pdata.equals("begin")) {
                System.out.println("Your console view is loading please wait...\n" + pdata);
            } else {
                System.out.println("This is the end of swingy and you have won the game by a great story that will be told for generations ");
            }
            playscan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}






