
package com.quantumscript.ocr_V1.config;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TesseractConfig {
    
    @Bean
    Tesseract tesseract(){
        Tesseract tesseract=new Tesseract();
        //Archivos de entrenamiento
        tesseract.setDatapath("src/main/resources/tessdata");
        return tesseract;
    }
    
}
