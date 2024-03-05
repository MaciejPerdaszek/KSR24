package org.example;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class ArticleReader {
    List<Article> articles = new ArrayList<>();

    public void readArticle() {
        String articlePathCore = "src/main/resources/articles/reut2";
        try {
            for (int i = 0; i <= 21; i++) {
                String articlePath = (i < 10) ? articlePathCore + "-00" + i + ".sgm" : articlePathCore + "-0" + i + ".sgm";
                File file = new File(articlePath);
                if (!file.exists()) {
                    throw new IOException("File not found");
                }
                //System.out.println(file.getAbsolutePath());
                Document doc = Jsoup.parse(file, "UTF-8");

                for(Element element : doc.select("REUTERS")) {
                    String title = element.select("TITLE").text();
                    String body = element.select("TEXT").text();
                    Article article = new Article(title, body);
                    articles.add(article);
                }
            }
            System.out.println("Articles read: " + articles.getFirst().getTitle() + " " + articles.getFirst().getWordCount() + " " + articles.getFirst().getWordsOfArticle());
        } catch (IOException e) {
            System.out.println("Error reading article: " + e.getMessage());
        }
    }

}
