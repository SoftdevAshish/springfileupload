package com.logcollege.utils;

import jakarta.servlet.annotation.MultipartConfig;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

@Service
@MultipartConfig
public class FileHandlingImpl implements FileHandling {
    String path = "/uploads";
    Resource rc = new ClassPathResource(path);

    File staticDirectory = new File(getClass().getResource("/").getHost());
    Path staticPath = Path.of(staticDirectory.getAbsolutePath() + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static"+File.separator+"uploads"+File.separator);
    File checkDir = new File(staticPath.toString());
    @Override
    public void init() {



    }

    @Override
    public boolean upload(MultipartFile file, String fileName) {
        boolean up = false;
       try {
            if (!checkDir.exists()) {
                Files.createDirectories(checkDir.toPath());
            }
           Files.copy(file.getInputStream(),staticPath.resolve(fileName));
                up=true;


        } catch (Exception e) {
            e.printStackTrace();
        }

        return up;
    }

    @Override
    public void deleteUploadFile(String deleteFileName) {

        try {
            Path deletePath= Path.of(staticPath+File.separator + deleteFileName);
            Files.delete(deletePath);
        } catch (IOException e) {
           e.printStackTrace();
        }
    }


    @Override
    public String fileNewName(String fileOldNames) {
        String fileOldName = fileOldNames;
        String ext = FilenameUtils.getExtension(fileOldName);
        Random r = new Random();
        int random = r.nextInt(9999);
        Instant now = Instant.now();
        ZonedDateTime d = now.atZone(ZoneId.systemDefault());
        String fileNewName = "SpringBoot" + random + "Y" + d.getYear() + "M" + d.getMonthValue() + "D" + d.getDayOfMonth() + d.getDayOfWeek() + "H" + d.getHour() + "M" + d.getMinute() + "S" + d.getSecond() + "." + ext;

        return fileNewName;
    }
}
