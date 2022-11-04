package pl.edu.pwr.kszydlak.Method;

import pl.edu.pwr.kszydlak.Module.Client;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Clientlist {
    public static ArrayList<Client> clientlist() throws NoFile {
        ArrayList<Client> clientlist = new ArrayList<Client>();
        ArrayList<String> clientdata = new ArrayList<String>();
        Path path = Paths.get("src/main/resources/clients.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(path.toFile()))){
            String line;
            while((line = br.readLine())!=null){
                String[] pair = line.split(";");
                for(String e: pair){
                    clientdata.add(e.trim());
                }
            }
        } catch (IOException e) {
            throw new NoFile("Nie odnaleziono pliku danych klientów"+e);
        }
        Client client = new Client();
        for(int i=0;i<clientdata.size();i+=2){
            client.setId(Integer.parseInt(clientdata.get(i)));
            client.setName(clientdata.get(i+1));
            clientlist.add(client);
        }
        return clientlist;
    }
}
