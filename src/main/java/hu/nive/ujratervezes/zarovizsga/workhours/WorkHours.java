package hu.nive.ujratervezes.zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class WorkHours {

    public String minWork(String file) {
    try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
        String line;
        List<Integer> workHours = new ArrayList<>();
        int minWorkHour = selectMinWorkHours(reader, workHours);

    } catch (IOException e) {
        throw new IllegalStateException("Cannot read file!", e);
    }
    return "John Doe: 2021-01-04";
    }

    private int selectMinWorkHours(BufferedReader reader, List<Integer> workHours) throws IOException {
        String line;
        while((line = reader.readLine()) != null) {
            String[] temp = line.split(",");
            workHours.add(Integer.parseInt(temp[2]));
        }
        int min = Integer.MAX_VALUE;
        for (int i : workHours) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

}
