import net.salesianos.launcher.ProcessLauncher;
import net.salesianos.utils.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> lines = Utils.getAllLines("/Users/alejandro/IdeaProjects/UD1-Practica1-Programacion-multiproceso/src/loremipsum.txt");
        ArrayList<Process> allProcesses = new ArrayList<>();
        String[] vocales = new String[] { "a", "e", "i", "o", "u" };
        HashMap<String, Integer> vocalCounts = new HashMap<>();

        for (String vocal : vocales) {
            vocalCounts.put(vocal, 0);
        }

        for (String line : lines) {
            for (String vocal : vocales) {
                Process javaProcess = ProcessLauncher.initContadorVocalProcess(vocal, line);
                allProcesses.add(javaProcess);
            }
        }


        for (Process process : allProcesses) {
            try {
                process.waitFor();
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String output = reader.readLine();

                if (output != null) {
                    String[] parts = output.split(",");
                    if (parts.length >= 2) {
                        String vocal = parts[0];
                        int count = Integer.parseInt(parts[1]);
                        vocalCounts.put(vocal, vocalCounts.get(vocal) + count);
                    } else {
                        System.out.println("Formato de salida inesperado: " + output);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int totalCount = 0;
        for (String vocal : vocales) {
            int count = vocalCounts.get(vocal);
            System.out.println("Total de " + vocal + ": " + count);
            totalCount += count;
        }
        System.out.println("Total de vocales: " + totalCount);
    }

    }
}
