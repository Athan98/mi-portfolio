package com.quantumscript.ocr_V1.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TesseractService {

    @Autowired
    private Tesseract tesseract;

    public String reconocerTexto(InputStream inputStream) throws IOException {
        BufferedImage imagen = ImageIO.read(inputStream);
        try {
           return tesseract.doOCR(imagen);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "Error";
    }
}
