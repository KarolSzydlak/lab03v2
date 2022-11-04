package pl.edu.pwr.kszydlak.Method;

import java.io.File;

public class NoFile extends Exception{
    public NoFile(String err){
        super(err);
        File file = new File("clients.txt");
        //System.out.println("utw");
        //File file = new File("clients.txt");
    }
}
