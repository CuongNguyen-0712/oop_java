import java.util.*;
import java.io.*;
import java.lang.*;

import BookManager.*;
import StoreManager.StoreManager;
import feature.checkAutoID;

public class Main{

    public static void main(String[] args) {
        StoreManager.readFile();
//        checkAutoID.createAutoID();
        StoreManager.startProgram();
    }
}