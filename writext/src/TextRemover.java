
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
        for(int i = 0; i < listaDeCaminhos.size(); i++){
            String a = listaDeCaminhos.get(i);
        }
        
        System.out.println("Tamanho da Lista de Caminhos: " + listaDeCaminhos.size());
        System.out.println("Tamanho da Lista de Diretórios:" + arrayDiretorios.size());
               
               
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
        File finalFile = new File("C:/Users/Pichau/Desktop/texto.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(finalFile, true));
        for (FileReader in : textArray){
            BufferedReader reader = new BufferedReader(in);
            String line;
            StringBuilder builder = new StringBuilder();
            try {
                while((line = reader.readLine()) != null){
                  builder.append(line);
                }
                stringArray.add(builder.toString());
            } catch (Exception ex) {
                ex.printStackTrace();
            }                
            }         
         try {
             int i = 0;
             System.out.println("StringArray: " + stringArray.size());
             System.out.println("diretorio:" + diretorio.size());
                    
             while(i < stringArray.size()){
                    String string = stringArray.get(i);
                    String dir = diretorio.get(i);
                    writer.write(dir + "\t" + string);
                    writer.write("\n");
                    i++;
             }
             
         } catch (Exception e) {
             e.printStackTrace();
             System.out.println("FUCK!");
         }
               
        
        
        }

    
    
    
    
    
    
    
    
    
    
    
        
        
    }
   