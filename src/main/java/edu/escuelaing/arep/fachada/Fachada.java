package edu.escuelaing.arep.fachada;
import static spark.Spark.get;
import static spark.Spark.port;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Fachada {
	
	public static void main(String[] args) {
		port(getPort());
		get("/fachada", (req, res) ->{
			String number = req.queryParams("val");
			String triFuction = req.queryParams("trifunction");
			Double numberDouble = Double.parseDouble(number);
			Double respuesta = null;
			URL url = new URL("http://radiant-brook-00421.herokuapp.com/trigcalculator?val="+numberDouble+"&trifunction="+triFuction);
			URLConnection urlConnection = url.openConnection();
	        BufferedReader read = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	        String inputLine = read.readLine();
			return inputLine;
		});
	}
	
	/**
	 * @return retorna el el puerto desde el entorno del sistema operativo
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set (i.e. on localhost)
	}

}

