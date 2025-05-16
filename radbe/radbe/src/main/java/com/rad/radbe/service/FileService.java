package com.rad.radbe.service;

import com.rad.radbe.entity.FileEntity;
import com.rad.radbe.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

   public void saveFile(String fileName, String filePath){
       FileEntity fileEntity = new FileEntity();
       fileEntity.setFileName(fileName);
       fileEntity.setFilePath(filePath);
        fileRepository.save(fileEntity);
    }
}
