package eu.codeacademy.eshop.api.controller;

import eu.codeacademy.eshop.api.dto.FileResponse;
import eu.codeacademy.eshop.api.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@Api(tags = "File Management")
public class FileController {

    private static final String FILE_ROOT_PATH = "/file";
    private static final String FILE_UPLOAD_PATH = FILE_ROOT_PATH + "/upload";
    private static final String FILE_DOWNLOAD_PATH = FILE_ROOT_PATH + "/download";

    private final FileService fileService;

    @ApiOperation(value = "Save image", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Kai sekmingai sukuriamas image"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    @PostMapping(FILE_UPLOAD_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public FileResponse saveFile(@RequestParam MultipartFile file) {
        return fileService.saveFile(file);
    }

    @ApiOperation(value = "Get image by name", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Kai sekmingai grazinamas image"),
            @ApiResponse(code = 403, message = "Neturit permisionu gauti atsakymas"),
            @ApiResponse(code = 401, message = "Prisijunkite jei norit gauti atsakyma")
    })
    @GetMapping(FILE_DOWNLOAD_PATH)
    public ResponseEntity<Resource> getFileByFileName(@RequestParam String fileName) {
        return ResponseEntity.ok()
                .headers(getContentDispositionHttpHeader(fileName))
                .contentType(fileService.getFileMediaTypeByFileName(fileName))
                .body(fileService.getFile(fileName));
    }

    private HttpHeaders getContentDispositionHttpHeader(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

        return headers;
    }
}
