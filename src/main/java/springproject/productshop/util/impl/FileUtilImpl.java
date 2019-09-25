package springproject.productshop.util.impl;

import springproject.productshop.util.FileUtil;

import java.io.*;

public class FileUtilImpl implements FileUtil {
    private static final String BASE_PATH = "/home/stoyanov/Desktop/ProductShop/src/main/resources/JSON/";

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

}
