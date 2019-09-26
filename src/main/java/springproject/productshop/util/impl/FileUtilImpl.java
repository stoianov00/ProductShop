package springproject.productshop.util.impl;

import springproject.productshop.util.FileUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtilImpl implements FileUtil {
    private static final String BASE_PATH = "/home/stoyanov/Desktop/ProductShop/src/main/resources/JSON/";
    private static final String BASE_JSON_EXPORT_PATH = "/home/stoyanov/Desktop/ProductShop/src/main/resources/JSON/export/";

    @Override
    public String fileContent(String path) throws IOException {
        File file = new File(BASE_PATH + path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public void exportJsonFile(String path, String json) throws IOException {
        Files.writeString(Paths.get(BASE_JSON_EXPORT_PATH + path), json);
    }

}
