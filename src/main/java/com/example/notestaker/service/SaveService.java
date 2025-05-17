package com.example.notestaker.service;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.io.IOException;

@Service
public class SaveService {
    private static final FileService fileService = new FileService();
    public SaveService() {
    }

    public static void save(String noteMarkdown) {
        String htmlContent = parseMarkdownToHTML(noteMarkdown);
        try {
            createAndSaveHTML(htmlContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String parseMarkdownToHTML(String noteMarkdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(noteMarkdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    private static void createAndSaveHTML(String htmlContent) throws IOException {
        long currentTimeMillis = System.currentTimeMillis();
        Random random = new Random(currentTimeMillis);
        int randomNumber = random.nextInt();

        String fileName = randomNumber + ".txt";
        String content = htmlContent;

        fileService.writeToFile(fileName, content);
    }
}
