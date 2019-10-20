package com.eappcat.base.oauth2.starter;

import com.eappcat.base.oauth2.starter.codegen.CodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CodeGeneratorTests {
    @Autowired
    private CodeGenerator codeGenerator;

    @Test
    void generateCodes() {
        codeGenerator.generate();
    }

}
