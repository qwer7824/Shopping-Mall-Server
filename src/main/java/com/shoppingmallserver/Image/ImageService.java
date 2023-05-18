package com.shoppingmallserver.Image;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final FileDataRepository fileDataRepository;


    // 파일 경로 지정, 윈도우인 경우, '\' 이스케이프 2개 필요!
    private final String FOLDER_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\img\\";


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        log.info("upload file: {}", file.getOriginalFilename());
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileDataEntity fileData = fileDataRepository.save(
                FileDataEntity.builder()
                        .name(file.getOriginalFilename())
                        .type(file.getContentType())
                        .filePath("img/" +file.getOriginalFilename())
                        .build()
        );

        // 파일 결로
        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully! filePath : " + filePath;
        }

        return null;
    }

}
