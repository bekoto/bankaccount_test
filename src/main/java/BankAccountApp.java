import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankAccountApp<T> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Number> nombres = new ArrayList<Number>();
		List<Integer> entiers = new ArrayList<Integer>();
		String nom = "Brandon";
		char[] letters = nom.toCharArray();
		System.err.println(nom.chars().mapToObj(c -> (char) c).distinct().count());
		String[] noms = { "Brandon", "Ekoto", "Brandon" };
		System.err.println(Arrays.asList(noms).stream().distinct().collect(Collectors.toList()));
		System.err.println("Available p:");
		try {
			Random random = new Random(1234);
			System.err.println(random.nextInt());
			System.err.println(random.nextInt());
			System.err.println(random.nextInt());
			random = new Random();
			System.err.println(random.nextInt());
			System.err.println(random.nextInt());
			System.err.println(random.nextInt());
			Function<Integer, Void> func = v ->{
				
				return null;
				
			};
			
			
			URL url= new URL("https://jsonplaceholder.typicode.com/todos");
			URLConnection cnx = url.openConnection();
			BufferedInputStream bis = new BufferedInputStream(cnx.getInputStream());
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(cnx.getInputStream()));
			
		//	HttpURLConnection cnxHttp;
		
			byte[] buffer = new byte[1024];
			int read ;
			System.err.println(cnx.getContentType());
			while ( (read = bis.read(buffer)) != -1) {
				 String data = new String(buffer, 0, read);
	                System.out.println(data);
			}
			
			
			Process ps = Runtime.getRuntime().exec("ls ~/");

			BufferedReader in = new BufferedReader(new InputStreamReader(ps.getInputStream()));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println("rr:::"+str);
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// entiers = nombres;
		// nombres = entiers;

	}

}
