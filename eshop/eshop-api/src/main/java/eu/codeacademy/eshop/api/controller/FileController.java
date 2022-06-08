package eu.codeacademy.eshop.api.controller;

import eu.codeacademy.eshop.api.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping("/api/file/upload")
    public void saveFile(@RequestParam MultipartFile file) {
        fileService.saveFile(file);
    }

    @GetMapping("/api/file/download")
    public Resource getFileByFileName(@RequestParam String fileName) {
        return fileService.getFile(fileName);
    }
}
