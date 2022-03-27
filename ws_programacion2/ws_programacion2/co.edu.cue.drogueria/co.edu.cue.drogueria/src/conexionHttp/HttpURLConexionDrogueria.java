package conexionHttp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import co.edu.cue.drogueria.model.Cliente;


public class HttpURLConexionDrogueria {

	private final String USER_AGENT = "Mozilla/5.0";
	 
    public static void main(String[] args) throws Exception {
 
    	HttpURLConexionDrogueria http = new HttpURLConexionDrogueria();
 
        System.out.println("Testing 1 - Send Http GET request");
        http.sendGet();
 
//        System.out.println("\nTesting 2 - Send Http POST request");
//        http.sendPost();
// 
    }
    
    private void sendGet() throws Exception {
    	 
        String url = "http://localhost:8080/api/drogueria/clientes";
 
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
                 // El valor predeterminado es GET
        con.setRequestMethod("GET");
 
                 // Añadir encabezado de solicitud
//        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Content-Type", "application/json");
 
        Object obj1 =  con.getContent();
        
        System.out.println(obj1.toString());
        
        
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
 
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
//            System.out.println(response);
        }
        in.close();
 
                 // Imprime el resultado
        System.out.println(response.toString());
//        String cadena = response.toString();
////        cadena = cadena.replace("\"", "\\ \"");
//        
//        ArrayList< Cliente> listaClientes = new ArrayList<Cliente>();
//        
//        try {
//        	JSONArray jsonArray=JSONArray.fromObject(cadena);
//        	 Object o=jsonArray.get(0);
//             JSONObject jsonObject2=JSONObject.fromObject(o);
//             Cliente cliente=(Cliente)JSONObject.toBean(jsonObject2, Cliente.class);
////             System.out.println("stu:"+stu);
//             System.out.println("cliente:"+cliente);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//    }
 


}


//
////
////JSONObject jsonObject = new JSONObject(cadena);
////
//////System.out.println(response.toString());
////System.out.println(jsonObject);
//
//org.json.JSONArray jsonArray = new org.json.JSONArray(cadena);
//
//for (int i = 0; i < jsonArray.length(); i++) {
//	
////	System.out.println(jsonArray.get(i));
////	Object object = jsonArray.get(i);
//	org.json.JSONObject jsonObject = (JSONObject) jsonArray.get(i);
//	System.out.println(jsonObject);
//	
////	System.out.println(jsonObject.getInt("idCliente"));
//////	System.out.println(jsonObject.get("fechaNacimiento"));
////	System.out.println(jsonObject.getInt("peso"));
////	System.out.println(jsonObject.getString("cedula"));
////	Cliente cliente = (Cliente) JSONObject.toBean(jsonObject, Cliente.class);
////	
////	System.out.println(cliente.toString());
//	
//	
//	Cliente cliente = new Cliente();
//	
//	cliente.setNombre(jsonObject.getString("nombre"));
//	System.out.println(cliente.toString());
//	
//	
//	listaClientes.add(cliente);
//	
//	
//}
	 
	 
	 
}
