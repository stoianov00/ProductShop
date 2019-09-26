package springproject.productshop.util;

import java.io.IOException;

public interface FileUtil {
    String fileContent(String path) throws IOException;

    void exportJsonFile(String path, String json) throws IOException;
}
