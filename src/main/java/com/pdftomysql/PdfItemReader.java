package com.pdftomysql;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
@StepScope
public class PdfItemReader implements ItemReader<String> {

    private List<String> pdfData;
    private int nextDataIndex = 0;

    public PdfItemReader(@Value("#{jobParameters['pdfFilePath']}") String pdfFilePath) throws IOException {
        this.pdfData = extractPdfData(pdfFilePath);
    }

    @Override
    public String read() {
        if (nextDataIndex < pdfData.size()) {
            return pdfData.get(nextDataIndex++);
        } else {
            return null;
        }
    }

    private List<String> extractPdfData(String pdfFilePath) throws IOException {
        List<String> extractedData = new ArrayList<>();

        try (InputStream inputStream = new ClassPathResource(pdfFilePath).getInputStream();
             PDDocument document = PDDocument.load(inputStream)) {

            PDFTextStripper pdfTextStripper = new PDFTextStripper();
            String pdfText = pdfTextStripper.getText(document);

            // Split the extracted text into lines or process as needed
            String[] lines = pdfText.split("\\r?\\n");

            for (String line : lines) {
                // Add each line to the list of extracted data
                extractedData.add(line);
            }
        }

        return extractedData;
    }
}
