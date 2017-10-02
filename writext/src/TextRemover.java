
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
        ArrayList<String> arrayDiretorios = new ArrayList<String>();
        listarArquivos("C:/Users/Pichau/Desktop/PDFs", listaDeCaminhos, arrayDiretorios);
        String diretorioNome;
        for(int i = 0; i < listaDeCaminhos.size(); i++){
            String a = listaDeCaminhos.get(i);
        }
        
        escreverTxtGrandao(listaDeCaminhos, arrayDiretorios);
        System.out.println("Terminou!");
        
    }
        
        
    public void listarArquivos(String caminho, ArrayList<String> array, ArrayList<String> arrayDiretorios){
        
        
        File pasta = new File(caminho);
        File[] listaDeArquivos = pasta.listFiles();
        String diretorio;
        for(File arquivo: listaDeArquivos){
            if (arquivo.isFile()){
                diretorio = arquivo.getParentFile().getName();
                array.add(arquivo.getAbsolutePath());
                arrayDiretorios.add(diretorio);
            }else if(arquivo.isDirectory()){
                listarArquivos(arquivo.getAbsolutePath(), array, arrayDiretorios);
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

    
    
     public void escreverTxtGrandao(ArrayList<String> pathlist, ArrayList<String> diretorio) throws IOException{
        
        
        ArrayList<FileReader> textArray = new ArrayList<FileReader>();
        ArrayList<String> stringArray = new ArrayList<String>();
        
        for(String path : pathlist){
           try{
           FileReader in = new FileReader(path);
           textArray.add(in);
           }catch(IOException exc){
               System.out.println("Caminho errado: " + path);
               exc.printStackTrace();
               System.out.println(path);
           }
        }
        File finalFile = new File("C:/Users/Pichau/Desktop/textao.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(finalFile, true));
        for (FileReader in : textArray){
            BufferedReader reader = new BufferedReader(in);
            String line;          
            try {
                while((line = reader.readLine()) != null){
                    stringArray.add(line);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
                
            } 
        
        
         try {
             for(int i = 0; i < stringArray.size(); i++){
                    String string = stringArray.get(i);
                    String dir = diretorio.get(i);
                    writer.write(dir + "\t" + string);
                    writer.write("\n");
                }
             
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("FUCK!");
         }
               
        
        
        }

    
    
    
    
    
    
    
    
    
    
    
        
        
    }
   