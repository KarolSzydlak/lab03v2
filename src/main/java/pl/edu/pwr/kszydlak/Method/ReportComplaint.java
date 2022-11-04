package pl.edu.pwr.kszydlak.Method;

import pl.edu.pwr.kszydlak.Module.Complaint;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ReportComplaint {
    //static ArrayList<Complaint> complaints = new ArrayList<Complaint>();
   // File plik = new File("complaints_list.txt");
   /* public static void report_complaint() throws FileNotFoundException {
        Complaint complaint = new Complaint();
        System.out.println("Zgłaszasz reklamację, podaj id klienta:");
        Scanner scan = new Scanner(System.in);
        complaint.setId(complaints.size());
        System.out.println("Podaj id produktu:");
        complaint.setItemid(scan.nextInt());
        scan.nextLine();
        System.out.println("Podaj opis produktu:");
        complaint.setDescription(scan.nextLine());
        complaint.setStatus("Złożona");
        scan.close();
        PrintWriter write = new PrintWriter("complaints_list.txt");
        write.printf("%d",complaint.getId());
        complaints.add(complaint);
    }*/
    static ArrayList<Complaint> complaints = new ArrayList<Complaint>();
    public static void report_complaint(int id, String name) throws NoFile {
        Path path = Paths.get("src/main/resources/ClientComplaints.txt");
        Complaint complaint = new Complaint();
        System.out.println("Zgłaszasz reklamację, proszę podać id produktu:");
        complaint.setId(id);
        complaint.setClientname(name);
        int complaintid = complaints.size()+1;
        complaint.setId(complaintid);
        Scanner scan = new Scanner(System.in);
        int itemid;
        itemid = scan.nextInt();
        scan.nextLine();
        complaint.setItemid(itemid);
        System.out.println("Proszę podać opis produktu:");
        String description;
        description = scan.nextLine();
        complaint.setDescription(description);
        complaints.add(complaint);
        FileWriter fr = null;
        try {
            fr = new FileWriter(path.toFile(),true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pr = new PrintWriter(br);
            pr.println();
            pr.printf("%d; %s; %d; %d; %s;", id,name,complaint.getId(),complaint.getItemid(),complaint.getDescription());
            pr.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            throw new NoFile("Brak pliku");
        }
    }
}
