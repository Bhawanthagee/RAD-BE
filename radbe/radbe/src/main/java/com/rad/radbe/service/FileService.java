package com.rad.radbe.service;

import com.rad.radbe.dto.DocSubmitTrack;
import com.rad.radbe.dto.DocVerificationDto;
import com.rad.radbe.entity.FileEntity;
import com.rad.radbe.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;

   public void saveFile(String fileName, String filePath){
       FileEntity fileEntity = new FileEntity();
       fileEntity.setFileName(fileName);
       fileEntity.setFilePath(filePath);
       fileEntity.setStatus("Pending");
        fileRepository.save(fileEntity);
    }

    public List<FileEntity> getAll() {
       return fileRepository.findAll();
    }

    public List<DocSubmitTrack> getAllDoc() {
        List<FileEntity> fileList = fileRepository.findAll();
        List<DocSubmitTrack> trackList = new ArrayList<>();

        for (FileEntity file : fileList) {
            DocSubmitTrack track = new DocSubmitTrack();

            track.setId(file.getId().toString());
            track.setTitle(file.getFileName());
            track.setSubmissionDate(LocalDate.now().toString());
            track.setApprovalDate(LocalDate.now().toString());
            track.setOfficer("Admin");
            track.setStatus(file.getStatus());
            track.setRemarks("Remarks");

            trackList.add(track);
        }

        return trackList;

    }

    public void verify(String status, Integer id) {
       fileRepository.verify(status,id);
    }

    public List<DocVerificationDto> getSubmitedRequest() {
        List<FileEntity> fileList = fileRepository.findAll();
        List<DocVerificationDto> trackList = new ArrayList<>();
        for (FileEntity file : fileList) {
            DocVerificationDto doc = new DocVerificationDto();
            doc.setId(file.getId().toString());
            doc.setName(file.getFileName());
            doc.setType("Passport");
            doc.setAiValid("Pending");
            doc.setAdminApproved(file.getStatus());
            trackList.add(doc);
        }
        return trackList;

    }
}
