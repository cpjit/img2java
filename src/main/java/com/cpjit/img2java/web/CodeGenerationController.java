package com.cpjit.img2java.web;

import com.cpjit.img2java.autoconfigure.CodeGenerateProperties;
import com.cpjit.img2java.codegen.CodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author yonghuan
 */
@RequestMapping("codegen")
@RestController
public class CodeGenerationController {

    @Autowired
    private CodeGenerator codeGenerator;
    @Autowired
    private CodeGenerateProperties codeGenerateProperties;

    @GetMapping
    public void generate() throws IOException {
        codeGenerator.generate(codeGenerateProperties.getSourceDirectory().getFile().toPath(),
                codeGenerateProperties.getTargetDirectory().getFile().toPath());
    }

}
