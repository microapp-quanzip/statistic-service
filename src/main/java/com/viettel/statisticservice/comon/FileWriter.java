package com.viettel.statisticservice.comon;

import com.viettel.statisticservice.service.dto.StatisticDTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;

public class FileWriter {
    public static void writeDataToFile(StatisticDTO statisticDTO) throws IOException {
        File folder = new File("./output");
        if (!folder.exists()) {
            folder.mkdir();
        }

        String statisticMessage = statisticDTO.toString();
        File dataFile = new File(folder,statisticDTO.getCreateBy() + "-" + System.currentTimeMillis() + ".txt");
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(dataFile);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(statisticMessage);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
