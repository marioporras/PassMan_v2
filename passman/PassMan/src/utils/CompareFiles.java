package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import utils.EmailSender;

public class CompareFiles {

  /**
   * Compara dos ficheros linea a linea para ver si existen diferencias entre ellos
   * @param Ffichero1
   * @param Ffichero2
   * @param email
   * @param sitioweb
   */
  public static  void LeerFichero(File Ffichero1,File Ffichero2, String email, String sitioweb){
  EmailSender emailS = new EmailSender();
   try {
       String NumLineaDist="";
       if(Ffichero1.exists() && Ffichero2.exists()){
           BufferedReader Flee1= new BufferedReader(new FileReader(Ffichero1));
           BufferedReader Flee2= new BufferedReader(new FileReader(Ffichero2));           
           String Slinea1="",Slinea2="";
           System.out.println("**********Comparando Fichero***********");
           int contador1=0,contador2=0,contador=0;
           while(Slinea1!=null || Slinea2!=null){
               Slinea1=Flee1.readLine();
               Slinea2=Flee2.readLine();
               if(Slinea1!=null){
                   contador1++;
               }
               if(Slinea2!=null){
                   contador2++;
               }
               contador++;               
               if(Slinea1!=null && Slinea2!=null) { 
                     if(!Slinea1.trim().toUpperCase().equals(Slinea2.trim().toUpperCase())){
                          NumLineaDist+=","+contador;
                          emailS.emailScrapping(email, sitioweb);
                       }   
               }else{
                   if(!(Slinea1==null && Slinea2==null)) { 
                        NumLineaDist+=","+contador;
                   }
               }
           }

           Flee1.close();
           Flee1.close();
         }else{
           System.out.println("Alguno De Los Ficheros No Existe");
         }
   } catch (Exception ex) {
        System.out.println(ex.getMessage());
   }
 }
}