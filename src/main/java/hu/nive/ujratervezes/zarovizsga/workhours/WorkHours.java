package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
        Path path = Path.of(file);
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return selectMinWorkHours(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file!", e);
        }
    }

    private String selectMinWorkHours(BufferedReader reader) throws IOException {
        int min = Integer.MAX_VALUE;
        String line;
        StringBuilder minWork = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(",");
            int work = Integer.parseInt(temp[1]);
            if (work < min) {
                min = work;
                minWork = new StringBuilder();
                minWork.append(temp[0]).append(": ").append(temp[2]);
            }
        }
        return minWork.toString();
    }
}
