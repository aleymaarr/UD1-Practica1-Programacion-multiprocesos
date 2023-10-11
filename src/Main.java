import net.salesianos.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> lines = Utils.getAllLines("/Users/alejandro/IdeaProjects/UD1-Practica1-Programacion-multiproceso/src/loremipsum.txt");
        ArrayList<Process> allProcesses = new ArrayList<>();
        String[] vocales = new String[] { "a", "e", "i", "o", "u" };
        HashMap<String, Integer> vocalCounts = new HashMap<>();

    }
}
