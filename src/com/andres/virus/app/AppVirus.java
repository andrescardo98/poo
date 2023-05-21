package com.andres.virus.app;

import com.andres.virus.domain.*;

import java.util.Arrays;
import java.util.List;

public class AppVirus {
    public static void main(String[] args) {
        Document document1 = new PdfDocument("cv.pdf");
        PdfDocument document2 = new PdfDocument("carta_restaurante.pdf");
        Document document3 = new PdfDocument("page.webp");
        Document document4 = new WordDocument("final.docx");
        WordDocument document5 = new WordDocument("final\uD83E\uDDA0.docx");
        Video video = new Video("miprimeracomunion.mp4","3K");
        Image image = new Image("miconfirmacion.png",1024);

        List<Viruseable> files = Arrays.asList(document1,document2,document3,document4,document5,video,image);

        String result = Antivirus.scanVirus(files);
        System.out.println(result);
    }
}
