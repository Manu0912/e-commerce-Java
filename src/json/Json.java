package json;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONObject;

public class Json {
	private final static String nombreArchivo = "json.json";

	public static void grabar(JSONArray lista) {
		try {
			FileWriter file = new FileWriter(nombreArchivo);
			file.write(lista.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void grabar(JSONObject objeto) {
		try {
			FileWriter file = new FileWriter(nombreArchivo);
			file.write(objeto.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String leer()
	{
		String con="";
		try {
			con= new String(Files.readAllBytes(Paths.get(nombreArchivo)));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}