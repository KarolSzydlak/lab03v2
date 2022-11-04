package pl.edu.pwr.kszydlak.Method;

import pl.edu.pwr.kszydlak.Module.Client;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ClientMethod {
    public static void klientapp(String name) throws NoFile {
        ArrayList<Client> clients = new ArrayList<Client>();
        clients = Clientlist.clientlist();
        boolean exist=false;
        String clientname = null;
        int clientid=0;
        for(int i=0;i<clients.size();i++){
            clientname = clients.get(i).getName();
            clientid = clients.get(i).getId();
            if(Objects.equals(clientname, name)){
                clientid = clients.get(i).getId();
                exist = true;
                break;
            }
        }
        if(exist==false){
            Path path = Paths.get("src/main/resources/clients.txt");
            try {
                // PrintWriter printWriter = new PrintWriter(new FileOutputStream(path.toFile()),true);
                FileWriter fr = new FileWriter(path.toFile(),true);
                BufferedWriter br = new BufferedWriter(fr);
                PrintWriter pr = new PrintWriter(br);
                Scanner scan = new Scanner(System.in);
                System.out.println("Jesteś nowym klientem, podaj swoją nazwę:");
                clientname=scan.nextLine();
                clientid+=1;
                pr.printf("\n");
                pr.printf("%d; %s;",clientid,clientname);
                pr.close();
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new NoFile("Nie odnaleziono pliku");
            }
        }
        System.out.printf("Witaj kliencie %s",clientname);
        int action;
        do {
            Scanner act = new Scanner(System.in);
            System.out.println("Wybierz akcję: 0)Wyjdź\n1)Zgłoś reklamację");
            action = act.nextInt();
            act.nextLine();
            if(action==1){
            ReportComplaint.report_complaint(clientid,clientname);
            }
        }while(action!=0);
    }
}
