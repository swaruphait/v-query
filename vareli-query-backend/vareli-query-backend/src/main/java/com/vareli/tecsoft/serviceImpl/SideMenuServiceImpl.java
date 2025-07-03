package com.vareli.tecsoft.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vareli.tecsoft.model.SideMenuOption;
import com.vareli.tecsoft.repository.SideMenuRepository;
import com.vareli.tecsoft.response.ResponseHandler;
import com.vareli.tecsoft.service.SideMenuService;

@Service
public class SideMenuServiceImpl implements SideMenuService{

    @Value("${file.upload-dir}")
    private String UPLOAD_DIR;

    @Autowired
    private SideMenuRepository sideMenuRepository;

    @Override
    public ResponseEntity<?> addSideMenu(SideMenuOption sideMenuOption) {
           UUID uuid = UUID.randomUUID();
        String mulliganDir = UPLOAD_DIR + "/landing-page";
        File uploadDir = new File(mulliganDir);
        if (sideMenuOption.getUploadImage() != null) {
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            MultipartFile multipartFile = sideMenuOption.getUploadImage();
            String random = uuid.toString();
            String name = multipartFile.getOriginalFilename();

            String[] part = name.split("\\.");
            String extension = part[part.length - 1];

            String filename = random + "." + extension;

            if (multipartFile.isEmpty()) {
                return null;
            } else {
                String uploadFilePath = mulliganDir + "/" + filename;
                String realtivePath = "uploadfile/landing-page/" + filename;
                try {
                    byte[] bytes = multipartFile.getBytes();
                    Path path = Paths.get(uploadFilePath);
                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                sideMenuOption.setImage(realtivePath);
                sideMenuOption.setStatus(true);
            }
        }
        sideMenuRepository.save(sideMenuOption);
        return ResponseHandler.generateResponse("Successfully Saved Data!..", HttpStatus.OK, null);
    }

    @Override
    public ResponseEntity<?> findAll() {
        List<SideMenuOption> collect = sideMenuRepository.findAll().stream().filter(t -> t.isStatus()).collect(Collectors.toList());
        return ResponseHandler.generateResponse("Successfully Saved Data!..", HttpStatus.OK, collect);

    }

    @Override
    public ResponseEntity<?> findById(Integer id) {
      Optional<SideMenuOption> byId = sideMenuRepository.findById(id);
      if (byId.isPresent()) {
        return ResponseHandler.generateResponse("Successfully Saved Data!..", HttpStatus.OK, byId);
      } else {
        return ResponseHandler.generateResponse("Opps! no vails id given..", HttpStatus.BAD_REQUEST, null);
        
      }
    }
    
}
