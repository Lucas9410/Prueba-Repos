package csvReader;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;



public class main {	
		
	public static final String SEPARADOR = ";";
		
	static String ruta = "C:\\Users\\Usuario\\Downloads\\";
	static String [] archivos = {"abiertos-im.csv","abiertos-q.csv"};

	public static void main(String[] args) {
	 
		ArrayList  <String[]> campos = new ArrayList<String[]>();

	
int a =0;
while(a<= archivos.length) 
{

	String rutatotal = ruta+archivos[a];
	System.out.println(rutatotal);

	 BufferedReader bufferLectura = null;
	 try 
	 {
		 
	 // Abrir el .csv en buffer de lectura
		bufferLectura = new BufferedReader(new FileReader(rutatotal));
	  
	  // Leer una linea del archivo
	  String linea = bufferLectura.readLine();
	  
	  while (linea != null) 
	  {
		  
	   // Sepapar la linea leída con el separador definido previamente
		 String[] arraylinea = linea.split(SEPARADOR);
	    campos.add(arraylinea) ; 
	   
		   
	   // Volver a leer otra línea del fichero
	   linea = bufferLectura.readLine();
	  }
	 } 
	 catch (IOException e) 
	 {
	  e.printStackTrace();
	 }
	 finally
	 {
	  // Cierro el buffer de lectura
	  if (bufferLectura != null) 
	  {
	   try 
	   {
	    bufferLectura.close();
	   } 
	   catch (IOException e) 
	   {
	    e.printStackTrace();
	   }
	  }
	 }
 
//----------- Saber el tipo Ticket -----------//
	 
	 int tticket, valorTicket = 0;
	 String texto = "q";
	 String buscar = rutatotal;
	
	 tticket = buscar.indexOf(texto);
	 
	 if (tticket >0) 
	 {
		 valorTicket = 1;
System.out.println(valorTicket);
	 }else 
	 {
		 valorTicket = 2;
System.out.println(valorTicket);
	 }

//----------- Recorrer Array -------------//
	 String[] listaCampos = null;
	 int i,j =0;


	 for(i=1; i< campos.size();i++) 
	  {
		 listaCampos = campos.get(i);
		
		 for ( j=0; j< listaCampos.length ;j++)
		 {
//---------- Listar los diferentes tipos de archivos-----------------//
			 switch (valorTicket)
			 {
			 case 1:
				 switch (j)
					{
						case 0:
							String idc = (String) Array.get(listaCampos, j);
							System.out.println(idc);
						break;
						case 1:
							String cod =  (String) Array.get(listaCampos, j);
							System.out.println(cod);
						break;
						case 2:
							String grupo = (String) Array.get(listaCampos, j);
							System.out.println(grupo);
						break;
						case 4:
							String ana = (String) Array.get(listaCampos, j);
							System.out.println(ana);
						break;
						case 6:	
							System.out.println("Tipo Ticket: q");
						break;
						case 7:
							String idf = (String) Array.get(listaCampos, j);
							idf = idf.replace('"', ' ');
							System.out.println(idf);
						break;
					}
				 break;
			
			 case 2:

				switch (j)
				{
					case 0:
						String idc = (String) Array.get(listaCampos, j);
						System.out.println(idc);
					break;
					case 1:
						String cod =  (String) Array.get(listaCampos, j);
						System.out.println(cod);
					break;
					case 2:
						String grupo = (String) Array.get(listaCampos, j);
						System.out.println(grupo);
					break;
					case 4:
						String ana = (String) Array.get(listaCampos, j);
						System.out.println(ana);
					break;
					case 6:
						System.out.println("Tipo Ticket: im");
					break;
					case 9:
						String idf = (String) Array.get(listaCampos, j);
						idf = idf.replace('"', ' ');
						//String[] fecha = idf.split(" ");
						System.out.println(idf);
					break;
				}
				break;
			 }
		}
	  }		 
a++;	
}

}
	}
	



