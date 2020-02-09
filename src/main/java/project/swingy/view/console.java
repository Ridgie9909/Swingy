package project.swingy.view;

import project.swingy.view.consoleview;
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
        System.out.println("Type Begin to Start your adventure.");

        final String pdata = playscan.nextLine();
        // System.out.println(pdata);
//        readercon();
        try {
            if (pdata.equals("begin")) {
                System.out.println("Your console view is loading please wait...\n" + pdata) ;
                consoleview conv = consoleview();
                conv.start();
            } else {
                System.out.println(pdata +" isn't a valid input please try again.");
            }
            playscan.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static consoleview consoleview() {
        return null;
    }

}






