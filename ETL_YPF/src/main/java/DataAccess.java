import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.stefanini.etlypfcc.model.Dim_analista;
import com.stefanini.etlypfcc.model.Dim_fecha;
import com.stefanini.etlypfcc.model.Dim_grupo;
import com.stefanini.etlypfcc.model.Dim_tipo_ticket;
import com.stefanini.etlypfcc.model.Fact_ticket_abierto;

public class DataAccess {

	public DataAccess() {
		
	}
	private static SessionFactory sessionFactory;
	private static Session session;
	
	
	private static int getIdAnalista(String usuario) {
		int idAnalista = 0;
		try {
			session.beginTransaction();
			List<Dim_analista> listAnalista = session.createQuery("from Dim_analista a where a.usuario='"+usuario+"'").getResultList();
			if (listAnalista.size()==1) {
				idAnalista = listAnalista.get(0).getId();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return idAnalista;
	}
	
	private static int getIdGrupo(String grupo) {
		int idGrupo = -1;	
		try {
			session.beginTransaction();
			List<Dim_grupo> listGrupo = session.createQuery("from Dim_grupo a where a.grupo='" + grupo + "'").getResultList();
			if (listGrupo.size() == 1) {
				idGrupo = listGrupo.get(0).getId();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return idGrupo;
		
	}
	private static int getIdTipoTicket(String codigo) {
		int idTipo = -1;	
		try {
			session.beginTransaction();
			List<Dim_tipo_ticket> listTipo = session.createQuery("from Dim_tipo_ticket t where t.codigo_ticket='" + codigo + "'").getResultList();
			if (listTipo.size() == 1) {
				idTipo = listTipo.get(0).getId();
			}
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return idTipo;
		
	}
	private static int getIdFecha(String fecha) {
		SimpleDateFormat csvFormat = new SimpleDateFormat("dd/mm/yyyy");
		SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-mm-dd");
		String outDate = "";
		int idFecha = -1;	
		
		
	    if (fecha != null) {
	        try {
	            Date date = csvFormat.parse(fecha);
	            outDate = sqlFormat.format(date);
	            session.beginTransaction();
	            Query query = session.createQuery("from Dim_fecha f where f.dia='"+outDate+"'");            
	            List<Dim_fecha> listFecha = query.getResultList();
	            if (listFecha.size()==1) {
	            	idFecha = listFecha.get(0).getId();
	    		}
	            session.getTransaction().commit();
	        } catch (ParseException ex){ 
	        	
	        }
	    }
	    return idFecha;
	}
	


	
	public static void saveTicketAbierto(String numeroTicket,String fecha, String hora, int idCriticidad, String tipoTicket, String analista, String grupo) {
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		session = sessionFactory.openSession();
		
		int idAnalista = getIdAnalista(analista);
		int idGrupo = getIdGrupo(grupo);
		int idFecha = getIdFecha(fecha);
		int idTipoTicket = getIdTipoTicket(tipoTicket);
		
		try {
			session.beginTransaction();
			Fact_ticket_abierto ticket = new Fact_ticket_abierto(numeroTicket,idFecha,hora, idCriticidad, idTipoTicket,idAnalista,idGrupo);
			
			System.out.println(ticket.toString()); //TODO: borrar
			session.save(ticket);
			
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	


	}

}
