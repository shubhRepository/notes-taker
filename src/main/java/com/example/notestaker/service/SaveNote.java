package com.example.notestaker.service;

import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class SaveNote {

    public static void save(String noteMarkdown) {
        String htmlContent = parseMarkdownToHTML(noteMarkdown);
        createAndSaveHTML(htmlContent);
    }

    private static String parseMarkdownToHTML(String noteMarkdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(noteMarkdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    private static void createAndSaveHTML(String htmlContent) {
        createAndSaveHTML(htmlContent, "/saved-notes");
    }

    private static void createAndSaveHTML(String htmlContent, String filePath) {

    }
}
