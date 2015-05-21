package Librerias;



import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.ArrayListEmpFijo;
import Modulos.GestionaEmpleados.GestionEmpFijo.Modelo.Clases.EmpFijo;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.ArrayListEmpHoras;
import Modulos.GestionaEmpleados.GestionEmpHoras.Modelo.Clases.EmpHoras;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.ArrayListEmpTemp;
import Modulos.GestionaEmpleados.GestionEmpTemp.Modelo.Clases.EmpTemp;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.JDomReader;

public class json {


	public static void generajsonEF() {//Guarda Json de empleado fijo
		String PATH = null;
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("Empfijo", EmpFijo.class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH=PATH+ ".json";

				Gson gson1=new Gson();
				String json=gson1.toJson(ArrayListEmpFijo.efi);
				FileWriter fileXml=new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void generajsonEmpHoras() {//Guarda Json de Productos de sobremesa
		String PATH = null;
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("EmpHoras",EmpHoras .class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH=PATH+ ".json";

				Gson gson = new Gson();
				String json1 = gson.toJson(ArrayListEmpHoras.eHo);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json1.toString());
				fileXml.close();

				JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void generajsonEmpTemp() {//Guarda Json de Productos portatiles
		String PATH = null;
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("EmpTemp", EmpTemp.class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showSaveDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				PATH=PATH+ ".json";

				Gson gson = new Gson();
				String json1 = gson.toJson(ArrayListEmpTemp.eTe);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json1.toString());
				fileXml.close();

				JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al grabar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void generajsonocultoEF() {//Guarda Json de empleadosfijos de forma silenciosa
		String PATH = null;
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("EmpFijo", EmpFijo.class);


			PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionaEmpleados/GestionEmpFijo/Modelo/Archivos/empleadosfijos.json";


			Gson gson = new Gson();
			String json1 = gson.toJson(ArrayListEmpFijo.efi);
			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(json1.toString());
			fileXml.close();


		} catch (Exception e) {
		}

	}

	public static void generajsonocultoEmpHoras() {//Guarda Json de Productos de sobremesa de forma silenciosa
		String PATH = null;
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("EmpHoras", EmpHoras.class);


			PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionaEmpleados/GestionEmpHoras/Modelo/Archivos/empleadoshoras.json";
			//PATH=PATH+ ".json";

			Gson gson = new Gson();
			String json1 = gson.toJson(ArrayListEmpHoras.eHo);
			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(json1.toString());
			fileXml.close();


		} catch (Exception e) {
		}

	}

	public static void generajsonocultoEmpTemp() {//Guarda Json de Productos de sobremesa de forma silenciosa
		String PATH = null;
		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("EmpTemp", EmpTemp.class);


			PATH = new java.io.File(".").getCanonicalPath()+"/src/Modulos/GestionaEmpleados/GestionEmpTemp/Modelo/Archivos/empleadosTemp.json";
			//PATH=PATH+ ".json";

			Gson gson = new Gson();
			String json1 = gson.toJson(ArrayListEmpTemp.eTe);
			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(json1.toString());
			fileXml.close();


		} catch (Exception e) {
		}

	}

	public static ArrayList<EmpFijo> abrir_jsonEF(){//Abre Json de empleados fijos
		String PATH = null;
		EmpFijo e1=new EmpFijo("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("EmpFijo", EmpFijo.class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				ArrayListEmpFijo.efi.clear();
				JsonReader lector = new JsonReader(new FileReader(PATH));
				JsonParser parseador = new JsonParser();
				JsonElement raiz = parseador.parse(lector);

				Gson json = new Gson();
				JsonArray lista = raiz.getAsJsonArray();
				for (JsonElement elemento : lista) {
					e1 = json.fromJson(elemento, EmpFijo.class);
					ArrayListEmpFijo.efi.add(e1);
				}
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return ArrayListEmpFijo.efi;
	}

	public static ArrayList<EmpHoras> abrir_json(){//Abre Json de productos de sobremesa
		String PATH = null;
		EmpHoras e1=new EmpHoras("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("EmpHoras", EmpHoras.class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				ArrayListEmpHoras.eHo.clear();
				JsonReader lector = new JsonReader(new FileReader(PATH));
				JsonParser parseador = new JsonParser();
				JsonElement raiz = parseador.parse(lector);

				Gson json = new Gson();
				JsonArray lista = raiz.getAsJsonArray();
				for (JsonElement elemento : lista) {
					e1 = json.fromJson(elemento, EmpHoras.class);
					ArrayListEmpHoras.eHo.add(e1);
				}
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return ArrayListEmpHoras.eHo;
	}

	public static ArrayList<EmpTemp> abrir_jsonProPorta(){//Abre Json de productos de sobremesa
		String PATH = null;
		EmpTemp e1=new EmpTemp("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("EmpTemp", EmpTemp.class);

			JFileChooser fileChooser = new JFileChooser();
			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				ArraylistPP.porta.clear();
				JsonReader lector = new JsonReader(new FileReader(PATH));
				JsonParser parseador = new JsonParser();
				JsonElement raiz = parseador.parse(lector);

				Gson json = new Gson();
				JsonArray lista = raiz.getAsJsonArray();
				for (JsonElement elemento : lista) {
					e1 = json.fromJson(elemento, EmpTemp.class);
					ArrayListEmpTemp.eTe.add(e1);
				}
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el JSON", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return ArraylistPP.porta;
	}

	public static ArrayList<EmpFijo> abrir_jsonOcultoEF(){//Abre json de empleados fijos de forma silenciosa
		String PATH = null;
		EmpFijo e1=new EmpFijo("");

		try {
			PATH = new java.io.File(".").getCanonicalPath()+"/src/TPV/Modulos/GestionE/GestionEF/Modelo/Archivos/ef.json";

			ArrayListEmpFijo.efi.clear();
			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				e1 = json.fromJson(elemento, EmpFijo.class);
				ArrayListEmpFijo.efi.add(e1);
			}
		} catch (Exception e) {

		}
		return ArrayListEmpFijo.efi;
	}

	public static ArrayList<Productos_sobremesa> abrir_jsonOcultoProSobre(){//Abre json de productos de sobremesa de forma silenciosa
		String PATH = null;
		Productos_sobremesa e1=new Productos_sobremesa("");

		try {
			PATH = new java.io.File(".").getCanonicalPath()+"/src/TPV/Modulos/GestionProductos/GestionSobremesa/Modelo/Archivos/ps.json";

			ArraylistPS.sobre.clear();
			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				e1 = json.fromJson(elemento, Productos_sobremesa.class);
				ArraylistPS.sobre.add(e1);
			}
		} catch (Exception e) {

		}
		return ArraylistPS.sobre;
	}

	public static ArrayList<Productos_portatiles> abrir_jsonOcultoProPorta(){//Abre json de productos de sobremesa de forma silenciosa
		String PATH = null;
		Productos_portatiles e1=new Productos_portatiles("");

		try {
			PATH = new java.io.File(".").getCanonicalPath()+"/src/TPV/GestionProductos/GestionPortatiles/Modelo/Archivos/pp.json";

			ArraylistPP.porta.clear();
			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				e1 = json.fromJson(elemento, Productos_portatiles.class);
				ArraylistPP.porta.add(e1);
			}
		} catch (Exception e) {

		}
		return ArraylistPP.porta;
	}


}
