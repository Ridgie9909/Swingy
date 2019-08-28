package project.swingy.reader;

import java.io.*;
import java.util.Scanner;

public class reader {
    public reader(){

    }

    public static File file = null;
    public static FileWriter filewriter;

    public static String hscanner(){
        Scanner in = new Scanner(System.in);
        System.out.println("Please select either GUI or Console.");
        String UIT = in.nextLine();

        return (UIT.toLowerCase());
    }

    public static void closer(){
        try{
            if (filewriter != null){
                filewriter.close();
        }
    }
    catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void fscanner(String line){
    try {
        file = new File("savefile.txt");
        filewriter = new FileWriter(file, true);
        filewriter.append(line);
        filewriter.append(",\n");
        filewriter.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
}

