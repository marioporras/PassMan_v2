package utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void scrap ( String email, String url, String titulo) {
    	//Aquí colocas tu objeto tipo Date
    	Date myDate = new Date();

    	//Aquí obtienes el formato que deseas
    	String fecha = new SimpleDateFormat("dd-MM-yyyy").format(myDate);
    	int numero=0;
    	FileWriter fw;
    	File fileAntiguo = null;
    	File fileActual = null;
    	
    		 if (getStatusConnectionCode(url) == 200 ) {
    				
    	            // Obtengo el HTML de la web en un objeto Document
    	            Document document = getHtmlDocument(url);
    				
    	            try {
    					fw = new FileWriter("C:\\txt\\webScrapping\\"+titulo + fecha + ".txt",true);
    					
    					fw.write(document.toString());
    					numero++;
    					fileActual = new File("C:\\txt\\webScrapping\\" +titulo + fecha + ".txt");
    					fw.close();
    					File directorio = new File("C:\\txt\\webScrapping");
    					fileAntiguo = CompareFiles.buscar(titulo , directorio );
    					
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    	            
    	            try {
    					
    					if(fileAntiguo != null) {
    						CompareFiles.LeerFichero(fileAntiguo, fileActual, email, url);
        					System.out.println("Se han comparado los ficheros");

    					}else {
    						System.out.println("No hay donde comparar");
    						fileAntiguo = fileActual;
    					}
    					fileAntiguo = fileActual;
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    		 }
    	
    		
    	}

    
 public static int getStatusConnectionCode(String url) {
		
        Response response = null;
		
        try {
            response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
        } catch (IOException ex) {
            System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
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
            System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
        }

        return doc;

    }
    
}
