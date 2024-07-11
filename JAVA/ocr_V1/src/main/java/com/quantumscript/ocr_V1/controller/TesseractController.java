package com.quantumscript.ocr_V1.controller;

import com.quantumscript.ocr_V1.service.TesseractService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TesseractController {

    @Autowired
    private TesseractService tesseractService;
    
    @PostMapping("/ocr")
    public String reconocerTexto(@RequestParam MultipartFile imagen) throws IOException {
        return tesseractService.reconocerTexto(imagen.getInputStream());
    }

}
