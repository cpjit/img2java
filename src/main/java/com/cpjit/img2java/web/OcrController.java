package com.cpjit.img2java.web;

import com.cpjit.img2java.autoconfigure.OcrProperties;
import com.cpjit.img2java.ocr.OcrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 识别图片中的文字。
 *
 * @author yonghuan
 */
@RequestMapping("/ocr")
@RestController
public class OcrController {

    @Autowired
    private OcrService ocrService;
    @Autowired
    private OcrProperties ocrProperties;

    @GetMapping
    public void general() throws IOException {
        ocrService.general(ocrProperties.getSourceDirectory().getFile().toPath(), ocrProperties.getTargetDirectory().getFile().toPath());
    }

}
