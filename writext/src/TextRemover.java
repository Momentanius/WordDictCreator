
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TextRemover{ 

    public TextRemover() throws IOException {
        ArrayList<String> listaDeCaminhos = new ArrayList<String>();
        listarArquivos("C:/Users/Pichau/Desktop/PDFs", listaDeCaminhos);
        
        for(int i = 0; i < listaDeCaminhos.size(); i++){
            String a = listaDeCaminhos.get(i);
            System.out.println("Caminho:" + a);
        }
        escreverTxtGrandao(listaDeCaminhos);
        
    }
        
        
    public void listarArquivos(String caminho, ArrayList<String> array){
        
        
        File pasta = new File(caminho);
        File[] listaDeArquivos = pasta.listFiles();
        
        for(File arquivo: listaDeArquivos){
            if (arquivo.isFile()){
                //System.out.println(arquivo.getName());
                array.add(arquivo.getAbsolutePath());
            }else if(arquivo.isDirectory()){
                listarArquivos(arquivo.getAbsolutePath(), array);
            }
        }        

    }
    
    public void lerArquivo(ArrayList<String> listaDeCaminhos){
        
        
        ArrayList<FileReader> arrayDeTextos = new ArrayList<FileReader>();
        
        for(String caminho : listaDeCaminhos){
           try{
           FileReader in = new FileReader(caminho);
           arrayDeTextos.add(in);
           }catch(IOException exc){
               exc.printStackTrace();
           }
        }
        
        for (FileReader in : arrayDeTextos){
            BufferedReader reader = new BufferedReader(in);
            String linha; 
            HashSet<String> set = new HashSet<String>();
            File arquivoFinal = new File("C:/Users/Pichau/Desktop/PDFs/worddict.txt");
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoFinal, true));
                writer.append("\n");
                while((linha = reader.readLine()) != null){
                  String[] palavraNova = linha.split(" ");
                  for(int i = 0; i < palavraNova.length; i++){
                      String string = palavraNova[i];
                      set.add(string);
                  }
                }
                for(String string : set){
                    writer.write(string + "\n");
                }
                
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
                
            } 
        }

    
    
     public void escreverTxtGrandao(ArrayList<String> listaDeCaminhos) throws IOException{
        
        
        ArrayList<FileReader> arrayDeTextos = new ArrayList<FileReader>();
        ArrayList<String> arrayDeStrings = new ArrayList<String>();
        
        for(String caminho : listaDeCaminhos){
           try{
           FileReader in = new FileReader(caminho);
           arrayDeTextos.add(in);
           }catch(IOException exc){
               exc.printStackTrace();
           }
        }
        File arquivoFinal = new File("C:/Users/Pichau/Desktop/textao.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoFinal, true));
        for (FileReader in : arrayDeTextos){
            BufferedReader reader = new BufferedReader(in);
            String linha; 
            
            try {
                
                while((linha = reader.readLine()) != null){
                    arrayDeStrings.add(linha);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
                
            } 
        
        
         try {
             for(String string: arrayDeStrings){
                    writer.write(string);
                    writer.write("\n");
                }
             
         } catch (Exception e) {
         }
               
        
        
        }

    
    
    
    
    
    
    
    
    
    
    
        
        
    }
   