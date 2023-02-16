package com.logcollege.utils;

import org.springframework.web.multipart.MultipartFile;

public interface FileHandling {
        public void  init();
        public boolean upload(MultipartFile file,String fileName);
        public void deleteUploadFile(String deleteFileName);
        public String fileNewName(String fileOldName);

}
