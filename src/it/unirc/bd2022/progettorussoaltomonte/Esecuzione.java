package it.unirc.bd2022.progettorussoaltomonte;

import java.sql.Timestamp;
import java.util.Date;


import it.unirc.bd2022.progettorussoaltomonte.dao.Camera;
import it.unirc.bd2022.progettorussoaltomonte.dao.CameraDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.Cliente;
import it.unirc.bd2022.progettorussoaltomonte.dao.ClienteDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.Evento;
import it.unirc.bd2022.progettorussoaltomonte.dao.EventoDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.HaPartecipato;
import it.unirc.bd2022.progettorussoaltomonte.dao.HaPartecipatoDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.HaSoggiornatoDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.Partecipa;
import it.unirc.bd2022.progettorussoaltomonte.dao.PartecipaDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.RecensioneDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.Servizio;
import it.unirc.bd2022.progettorussoaltomonte.dao.ServizioDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.Usufruisce;
import it.unirc.bd2022.progettorussoaltomonte.dao.UsufruisceDAO;

public class Esecuzione {
 public static void main(String[] args) {
//	Camera camera=new Camera();
////	camera.setIdCamera(4);
//	camera.setNumeroCamera(20);
////	camera.setCodicePiano("A");
//	camera.setTipologia(3);
//	camera.setDisponibilità(true);
//    camera.setOptional("tv,frigo,idromassaggio");
	
//	CameraDAO cameraDAO= new CameraDAO();
//	cameraDAO.insert(camera);
//	cameraDAO.delete(camera);
//	cameraDAO.aggiorna(camera);
//	System.out.println(cameraDAO.getAll());
	
//	System.out.println(cameraDAO.get(camera));
	 
	    Cliente cliente=new Cliente();
//		cliente.setIdCliente(4);
//		cliente.setCodiceFiscale("RSSDNC98TVHDIS");
	    cliente.setCognome("Russo");
		cliente.setNome("Domenica");
//		cliente.setDataNascita(new Date());
//		cliente.setNumeroTelefono("09810010");
//		cliente.setSesso("F");
//		cliente.setTipo(true);
//		cliente.setCamera(1);
//		
//	   ClienteDAO clienteDAO=new ClienteDAO();
//////	   clienteDAO.insert(cliente);
//	  System.out.println(clienteDAO.get(cliente));
//		Partecipa partecipa =new Partecipa();
//	    partecipa.setEvento(2);
//	    PartecipaDAO partecipaDAO=new PartecipaDAO();
//	    partecipaDAO.delete(partecipa);
//		Evento evento=new Evento();
//		evento.setIdEvento(2);
//		evento.setNome("Party");
//		evento.setTipo("intrattenimeto");
//		Timestamp dataInizio= new Timestamp(2022-1900,12-1,15,15,30,0,0);
//		
//		evento.setDataInizio(dataInizio);
//		
//		evento.setDataFine(new Timestamp(2022-1900,12-1,15, 20,30,00,00));
//		evento.setDipendenteManeger(2);
		
		EventoDAO eventoDAO=new EventoDAO();
//		eventoDAO.getAll();
//		eventoDAO.delete(evento);
//		eventoDAO.insert(evento);
////		
//		eventoDAO.aggiorna(evento);
//		
//		System.out.println(eventoDAO.get(evento));
//		HaSoggiornatoDAO ha=new HaSoggiornatoDAO();
		
		
//		Servizio servizio= new Servizio();
//		UsufruisceDAO usufruisceDAO=new UsufruisceDAO();
//		usufruisceDAO.ServizoUtilizzato();
//		
//		RecensioneDAO r=new RecensioneDAO();
//		r.mediaRecensioni();
		HaPartecipato hapartecipato= new HaPartecipato();
		hapartecipato.setEvento(3);
		HaPartecipatoDAO ha= new HaPartecipatoDAO();
		int personeEvento=ha.numPersone(hapartecipato);
		int totEvento=ha.getTotEventi();
		System.out.println((personeEvento*100)/totEvento + "%");
		} 
}
