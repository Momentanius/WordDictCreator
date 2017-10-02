
import java.io.File;
import java.io.IOException;


public class Main {

   
    public static void main(String[] args) {
       
        
        /*File file = new File("C:/Users/Pichau/Documents/Overwatch/ScreenShots/Overwatch/asd.txt");
        String parent = file.getParentFile().getName();
        System.out.println("parent:" + parent);*/
        
        System.out.println("Começou!");
        try{
            TextRemover textRemover = new TextRemover();
        }catch(IOException exception){
            exception.printStackTrace();
            System.out.println(exception.toString());
        }
        
        
  
    }
    
}
