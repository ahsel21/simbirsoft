package com.ahsel.simbirsoft.parser;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
//class dowloads html page in package dowloads
public class DownloaderHtmlPage implements Downloader {
    public void downloadPage(String url) {
        try {

            Document doc = Jsoup.connect(url)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            File file = new File("downloads/downloadedHtml.html");
            FileUtils.writeStringToFile(file, doc.outerHtml());
        } catch (MalformedURLException e) {
            System.out.println("BAD LINK!");
        } catch (IOException e) {
            System.out.println("BAD SOMTHN!");
        }
    }
}
