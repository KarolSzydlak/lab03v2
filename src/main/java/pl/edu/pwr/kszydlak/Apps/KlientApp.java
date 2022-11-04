package pl.edu.pwr.kszydlak.Apps;

import pl.edu.pwr.kszydlak.Method.ClientMethod;
import pl.edu.pwr.kszydlak.Method.Clientlist;
import pl.edu.pwr.kszydlak.Method.NoFile;
import pl.edu.pwr.kszydlak.Module.Client;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class KlientApp {
    public static void main(String[] args) throws NoFile {
        Clientlist.clientlist();
        System.out.println("Podaj nazwę użytkownika:");
        Scanner n = new Scanner(System.in);
        String name = n.nextLine().trim();
        ClientMethod.klientapp(name);
    }
}
