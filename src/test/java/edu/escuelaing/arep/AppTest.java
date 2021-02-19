package edu.escuelaing.arep;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws IOException 
     */
    @Test
    public void shouldRunCos() throws IOException
    {
    	URL url = new URL("http://young-dawn-26500.herokuapp.com/fachada?val=2.5&trifunction=cos");
        URLConnection urlConnection = url.openConnection();
        BufferedReader read = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine = read.readLine();
        assertTrue(inputLine.equals("{\"resultado\":-0.8011436155469337}"));
        read.close();   
    }
    @Test
    public void shouldRunSin() throws IOException
    {
    	URL url = new URL("http://young-dawn-26500.herokuapp.com/fachada?val=2.5&trifunction=sin");
        URLConnection urlConnection = url.openConnection();
        BufferedReader read = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine = read.readLine();
        assertTrue(inputLine.equals("{\"resultado\":0.5984721441039564}"));
        read.close();   
    }
    @Test
    public void shouldRunTan() throws IOException
    {
    	URL url = new URL("http://young-dawn-26500.herokuapp.com/fachada?val=2.5&trifunction=tan");
        URLConnection urlConnection = url.openConnection();
        BufferedReader read = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine = read.readLine();
        assertTrue(inputLine.equals("{\"resultado\":-0.7470222972386603}"));
        read.close();
    }
}
