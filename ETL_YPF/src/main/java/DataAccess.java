import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import cubo.Dim_analista;
import cubo.Dim_fecha;
import cubo.Dim_grupo;

public class DataAccess {

	public DataAccess() {
		// TODO Auto-generated constructor stub
	}
	private static SessionFactory sessionFactory;
	private static Session session;
	
	
	private static int getIdAnalista(String usuario) {
		int idAnalista = 0;
		session.beginTransaction();
		List<Dim_analista> listAnalista = session.createQuery("from Dim_analista a where a.usuario='"+usuario+"'").getResultList();
		if (listAnalista.size()==1) {
			idAnalista = listAnalista.get(0).getId();
		}
		session.getTransaction().commit();
		return idAnalista;
	}
	
	private static int getIdGrupo(String grupo) {
		int idGrupo = -1;	
		session.beginTransaction();
		List<Dim_grupo> listGrupo = session.createQuery("from Dim_grupo a where a.grupo='"+grupo+"'").getResultList();
		if (listGrupo.size()==1) {
			idGrupo = listGrupo.get(0).getId();
		}
		session.getTransaction().commit();
		return idGrupo;
		
	}
	private static void getIdFecha(String fecha) {
		int idFecha = -1;	
		session.beginTransaction();
		List<Dim_fecha> listFecha = session.createQuery("from Dim_fecha").getResultList();
		
		for(Dim_fecha oFecha:listFecha) {
			System.out.println(oFecha.getDia());
		}
		
//		if (listFecha.size()==1) {
//			idFecha = listFecha.get(0).getId();
//		}
		session.getTransaction().commit();
//		return idFecha;
		
	}


	
	public static void saveTicketAbierto(String numero_ticket,String fecha, String hora, int id_criticidad, int id_tipo_ticket, String analista, String grupo) {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		
		int idAnalista = getIdAnalista(analista);
		int idGrupo = getIdGrupo(grupo);
		getIdFecha("asd");

		
		
		session.close();
		System.out.println(idGrupo+" "+idAnalista);
		
		
	
		 
//		 Dim_grupo grupo = new Dim_grupo(4,3,"elnombredelgrupo","ladescripcion");
//		 session.save(grupo);
//		 session.getTransaction().commit();
//		 System.out.println(criteria.toString());
		 
		

	}

}
