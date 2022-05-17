package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import modelos.EmailSender;

/**
 * Autor:LBVP
 */
public class CompareFiles {

   
  public static  void LeerFichero(File Ffichero1,File Ffichero2, String email, String sitioweb){
  EmailSender emailS = new EmailSender();
   try {
       String NumLineaDist="";
       /*Si existe el fichero*/
       if(Ffichero1.exists() && Ffichero2.exists()){
           /*Abre un flujo de lectura a el fichero1*/
           BufferedReader Flee1= new BufferedReader(new FileReader(Ffichero1));
           /*Abre un flujo de lectura a el fichero2*/
           BufferedReader Flee2= new BufferedReader(new FileReader(Ffichero2));           
           String Slinea1="",Slinea2="";
           System.out.println("**********Comparando Fichero***********");
           int contador1=0,contador2=0,contador=0;
           /*Lee el fichero line a linea hasta llegar a la ultima*/
           while(Slinea1!=null || Slinea2!=null){
               Slinea1=Flee1.readLine();
               Slinea2=Flee2.readLine();
               /*Si alguno de los dos Fichero no se a acabado de leer*/
               if(Slinea1!=null){
                   contador1++;
               }
               if(Slinea2!=null){
                   contador2++;
               }
               contador++;               
               //si no es la ultima lectura para algun archivo para evitar excepcion por null
               if(Slinea1!=null && Slinea2!=null) { 
                   //Si no son iguales las lineas
                     if(!Slinea1.trim().toUpperCase().equals(Slinea2.trim().toUpperCase())){
                          NumLineaDist+=","+contador;
                          emailS.emailScrapping(email, sitioweb);
                       }   
               }else{
                    //si no es la ultima entrada al while donde ambos son null
                   if(!(Slinea1==null && Slinea2==null)) { 
                        NumLineaDist+=","+contador;
                   }
               }
           }
          
           System.out.println("*********Fin Comparacion Fichero**********");
           System.out.println(Ffichero1.getName()+"Tiene "+contador1+" Lineas");
           System.out.println(Ffichero2.getName()+"Tiene "+contador2+" Lineas");
           System.out.println("Las Lineas Distintas son "+NumLineaDist);
           /*Cierra el flujo*/
           Flee1.close();
           Flee1.close();
         }else{
           System.out.println("Alguno De Los Ficheros No Existe");
         }
   } catch (Exception ex) {
       /*Captura un posible error y le imprime en pantalla*/ 
        System.out.println(ex.getMessage());
   }
 }
}