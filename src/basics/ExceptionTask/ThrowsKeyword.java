package model;

import java.io.File;
import java.io.IOException;

public class ThrowsKeyword {

    public void readFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (file.canRead()){
            System.out.println("can read the file ");
        }else {
            throw new IOException("can not read the file");
        }
    }
}
