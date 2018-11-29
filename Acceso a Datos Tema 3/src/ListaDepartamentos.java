import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Departamentos;
import primero.HibernateUtil;

public class ListaDepartamentos {

	public static void main(String[] args) {
		SessionFactory sesion = HibernateUtil.getSessionFactory();
		Session session = sesion.openSession();
	
					
		Query q = session.createQuery("from Departamentos");
		List <Departamentos> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		Iterator <Departamentos> iter = lista.iterator();
		System.out.printf("Número de registros: %d%n",lista.size());
		while (iter.hasNext())
		{
		   //extraer el objeto
			Departamentos   depar = (Departamentos) iter.next(); 
		   System.out.printf("%d, %s%n", depar.getDeptNo(), depar.getDnombre());		   
		}
		session.close();
		System.exit(0);
	}
}
