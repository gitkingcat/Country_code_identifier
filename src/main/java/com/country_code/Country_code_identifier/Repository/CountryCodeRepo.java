package com.country_code.Country_code_identifier.Repository;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountryCodeRepo {
    public static Map<String,String> hashMap;
    private final static String WIKI_PAGE_HTML = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";
    private static String REGEX = "(?:\\/\\/)?[\\w/\\-?=%.]+\\.[\\w/\\-&?=%.]+";

    public static void initialize(){
        hashMap=new HashMap<>();
        try {
            Document doc = Jsoup.connect(WIKI_PAGE_HTML).get();
            Element element = doc.select("table").get(1);
            Elements rows = element.select("tr");
            for (Element elementTmp : rows){
                String tmp = elementTmp.text().replaceFirst(REGEX,"");
                String countryName = parseName(tmp);
                String result="";
                if (parseCode(tmp).contains(",")){
                    for (String s : elementTmp.text().split(",")){
                        result = parseCode(s);
                    }
                }else {
                    result = parseCode(tmp);
                }
                hashMap.put(result,countryName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String parseCode(String str) {
        str = StringUtils.substringAfter(str," +");
        str = StringUtils.substringBefore(str," UTC");
        if (str!=null) {
            str = str.replace("[notes 1]", "");
            str = str.replace(" ", "");
            str = str.replace("+", "");
            return str;
        }else {
            return "This is not country code";
        }
    }

    private static String parseName(String str) {
        str = StringUtils.substringBefore(str," +");
        return str;
    }

}

