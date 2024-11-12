import java.util.*;
import java.io.*;
import java.lang.*;

import BookManager.Book;

public class Main{

    public static void main(String[] args) {
        String filePath = "V:\\Develop\\Develop IntelliJ IDEA\\Project_1\\src\\data\\input.txt";
        // Hãy thay đổi đường dẫn file trên tùy thuộc vào IDE hoặc text-editor đang sử dụng
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}