package feature;

import BookManager.*;

public class checkAutoID {
    public static void createAutoID(){
        for(Book book : BookManager.getListOfBook()){
            String idString = book.getID().substring(1);
            int idNum = Integer.parseInt(idString);

            System.out.println(idNum);
        }

//        for(Book book : BookManager.getListOfBook()){
//            if(book instanceof LiteratureBook){
//
//            }
//        }
    }
}
