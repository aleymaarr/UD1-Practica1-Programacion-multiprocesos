package net.salesianos.launcher;

import java.io.IOException;

public class ProcessLauncher {

    public static Process initContadorVocalProcess(String vocal, String line) {
        ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "/Users/alejandro/IdeaProjects/UD1-Practica1-Programacion-multiproceso/src/net/salesianos/processes/VocalCounter.java", vocal, line
        );



        Process javaProcess = null;

        try {
            javaProcess = processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaProcess;
    }
}
