package pl.edu.pwr.kszydlak.Method;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Lapse {
    public void Lapse() throws NoFile {
        Path path = Paths.get("src/main/resources/clock.txt");
        int time;
        Scanner scan = null;
        try {
            scan = new Scanner(path.toFile());
        } catch (FileNotFoundException e) {
            throw new NoFile("Brak Pliku");
        }
        time = scan.nextInt();
        scan.nextLine();
        time+=1;
    }
}
