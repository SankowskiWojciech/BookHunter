package com.github.sankowskiwojciech.bookhunter;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;

public class Base64Encoder {
    @Test
    public void shouldReturn64() throws IOException {
        File file = new File("eric.jpg");
        System.out.println(new String(Base64.getEncoder().encode(Files.readAllBytes(file.toPath())), StandardCharsets.UTF_8));
    }
}
