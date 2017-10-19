
package textodelimitado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Product {
     String[] cod={"p1","p2","p3"};
      String[] desc ={"parafusos","cravos","tachas"};
      double[] prezo ={3,4,5};
       File fich = new File("/home/local/DANIELCASTELAO/mpastorperez/Escritorio/AD/textProduct.txt");

    public Product() {
    }

    public String[] getCod() {
        return cod;
    }

    public String[] getDesc() {
        return desc;
    }

    public double[] getPrezo() {
        return prezo;
    }

    public void setCod(String[] cod) {
        this.cod = cod;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    public void setPrezo(double[] prezo) {
        this.prezo = prezo;
    }
      
    public void escribirTexto(){
         FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(fich);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 3; i++)
                pw.println( cod[i]+"\t"+desc[i]+"\t"+prezo[i]);
    
              
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }     
   
     public void lerTexto() {
  File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         
         fr = new FileReader (fich);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
}
