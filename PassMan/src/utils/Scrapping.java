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
	
    public void scrap ( String email, String url) {
    	int numero = 0;
    	FileWriter fw;
    	File fileAntiguo = null;
    	File fileActual = null;
    	while (true) {
    		 if (getStatusConnectionCode(url) == 200) {
    				
    	            // Obtengo el HTML de la web en un objeto Document
    	            Document document = getHtmlDocument(url);
    	            //System.out.println(document);
    				
    	            // Busco todas las entradas que estan dentro de: 
    	            //Elements entradas = document.select("table#ctl00_Contenido_tblÍndice > tbody > tr[align=\"right\"]");
    				
    	            try {
    					fw = new FileWriter("C:\\txt\\webScrapping+ '" + numero + "'.txt",true);
    					
    					fw.write(document.toString());
    					//bw.write("\n\n");
    					numero++;
    					fileActual = new File("C:\\txt\\webScrapping+ '" + numero + "'.txt");
    					fw.close();
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
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
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    		 }
    	}
    		
    	}
        // Compruebo si me da un 200 al hacer la petición
       
    		
    
 public static int getStatusConnectionCode(String url) {
		
        Response response = null;
		
        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
        }
        return response.statusCode();
    }
 
 
    public static Document getHtmlDocument(String url) {

        Document doc = null;

        try {
            doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }
    
}
