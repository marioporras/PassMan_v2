package utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrapping extends Thread {	
	
	/**
	 * Comprueba cambios en el codigo de la web
	 * @param email
	 * @param url
	 */
    public void scrap ( String email, String url) {
    	int numero = 0;
    	FileWriter fw;
    	File fileAntiguo = null;
    	File fileActual = null;
    	while (true) {
    		 if (getStatusConnectionCode(url) == 200) {
    				
    	            // Obtengo el HTML de la web en un objeto Document
    	            Document document = getHtmlDocument(url);
    				
    	            try {
    					fw = new FileWriter("C:\\txt\\webScrapping+ '" + numero + "'.txt",true);
    					
    					fw.write(document.toString());
    					numero++;
    					fileActual = new File("C:\\txt\\webScrapping+ '" + numero + "'.txt");
    					fw.close();
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    	            
    	            try {
    					
    					if(fileAntiguo != null) {
    						CompareFiles.LeerFichero(fileAntiguo, fileActual, email, url);
        					System.out.println("Se ha consultado la web, tienes nuevos datos");

    					}else {
    						System.out.println("No hay donde comparar");
    						fileAntiguo = fileActual;
    					}
    					fileAntiguo = fileActual;
    					Thread.sleep(10000);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
    		 }
    	}
    		
    	}

    
 public static int getStatusConnectionCode(String url) {
		
        Response response = null;
		
        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepci�n al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }
 
 /**
  * Obtiene el html de la web
  * @param url
  * @return
  */
    public static Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepci�n al obtener el HTML de la p�gina" + ex.getMessage());
        }

        return doc;

    }
    
}
