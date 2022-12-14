package it.unirc.bd2022.progettorussoaltomonte.gui.cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import it.unirc.bd2022.progettorussoaltomonte.dao.Camera;
import it.unirc.bd2022.progettorussoaltomonte.dao.CameraDAO;
import it.unirc.bd2022.progettorussoaltomonte.dao.Cliente;
import it.unirc.bd2022.progettorussoaltomonte.dao.ClienteDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class NuovoCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodiceFiscale;
	private JTextField textFieldCognome;
	private JTextField textFieldNome;
	private JDateChooser dateChooser;
	private JTextField textFieldNumeroDitelefono;
	private JComboBox<String> comboBoxSesso;
	private JComboBox<Integer> comboBoxCamera;
	private JTextField textFieldComune;
	private JTextField textFieldVia;
	private JTextField textFieldProvincia;
	private JTextField textFieldNumeroCivico;
	private JTextField textFieldCap;
	private JTextField textFieldTipo;
	private JTextField textFieldStatusRimborso;
	private Cliente cliente;
	

	/**
	 * Create the dialog.
	 */
	public NuovoCliente() {
		setTitle("Nuovo Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(NuovoCliente.class.getResource("/it/unirc/bd2022/progettorussoaltomonte/img/photo_5821382305334279250_x.jpg")));
		setBounds(100, 100, 642, 323);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Codice Fiscale\r\n");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome.setBounds(10, 26, 86, 14);
		contentPanel.add(lblNome);
		
		textCodiceFiscale = new JTextField();
		textCodiceFiscale.setBounds(106, 24, 122, 20);
		contentPanel.add(textCodiceFiscale);
		textCodiceFiscale.setColumns(10);
		
		JLabel lblCognome = new JLabel("Cognome");
		lblCognome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCognome.setBounds(238, 26, 73, 14);
		contentPanel.add(lblCognome);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setBounds(294, 24, 113, 20);
		contentPanel.add(textFieldCognome);
		textFieldCognome.setColumns(10);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome_1.setBounds(419, 26, 46, 14);
		contentPanel.add(lblNome_1);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(465, 24, 151, 20);
		contentPanel.add(textFieldNome);
		
		JLabel lblDatanascita = new JLabel("Data di nascita");
		lblDatanascita.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatanascita.setBounds(10, 51, 86, 30);
		contentPanel.add(lblDatanascita);
		
		
	    dateChooser = new JDateChooser();
		dateChooser.setBounds(116, 55, 291, 26);
		contentPanel.add(dateChooser);
		
		JLabel lblNome_1_1 = new JLabel("Numero di telefono\r\n");
		lblNome_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNome_1_1.setBounds(419, 59, 110, 14);
		contentPanel.add(lblNome_1_1);
		
		textFieldNumeroDitelefono = new JTextField();
		textFieldNumeroDitelefono.setColumns(10);
		textFieldNumeroDitelefono.setBounds(530, 57, 86, 20);
		contentPanel.add(textFieldNumeroDitelefono);
		
		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSesso.setBounds(10, 86, 86, 30);
		contentPanel.add(lblSesso);
		
		comboBoxSesso = new JComboBox<String>();
		comboBoxSesso.setModel(new DefaultComboBoxModel<String>(
				new String[] { "|-------|", "M", "F", "Altro" }));
		comboBoxSesso.setBounds(49, 86, 86, 26);
		contentPanel.add(comboBoxSesso);
		
		JLabel lblComune = new JLabel("Comune");
		lblComune.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComune.setBounds(142, 86, 86, 30);
		contentPanel.add(lblComune);
		
		textFieldComune = new JTextField();
		textFieldComune.setColumns(10);
		textFieldComune.setBounds(201, 92, 86, 20);
		contentPanel.add(textFieldComune);
		
		JLabel lblVia = new JLabel("Via");
		lblVia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblVia.setBounds(299, 86, 46, 30);
		contentPanel.add(lblVia);
		
		textFieldVia = new JTextField();
		textFieldVia.setColumns(10);
		textFieldVia.setBounds(328, 92, 86, 20);
		contentPanel.add(textFieldVia);
		
		textFieldProvincia = new JTextField();
		textFieldProvincia.setColumns(10);
		textFieldProvincia.setBounds(75, 133, 126, 20);
		contentPanel.add(textFieldProvincia);
		
		textFieldNumeroCivico = new JTextField();
		textFieldNumeroCivico.setColumns(10);
		textFieldNumeroCivico.setBounds(516, 92, 100, 20);
		contentPanel.add(textFieldNumeroCivico);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProvincia.setBounds(10, 127, 86, 30);
		contentPanel.add(lblProvincia);
		
		JDateChooser dateChooserDataPrenotazione = new JDateChooser();
		dateChooserDataPrenotazione.setBounds(131, 172, 215, 26);
		contentPanel.add(dateChooserDataPrenotazione);
		
		JLabel lblDataDiPrenotazione = new JLabel("Data di prenotazione");
		lblDataDiPrenotazione.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataDiPrenotazione.setBounds(10, 168, 125, 30);
		contentPanel.add(lblDataDiPrenotazione);
		
		JLabel lblNumeroCivico = new JLabel("Numero civico\r\n");
		lblNumeroCivico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumeroCivico.setBounds(419, 84, 96, 30);
		contentPanel.add(lblNumeroCivico);
		
		JLabel lblCap = new JLabel("CAP");
		lblCap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCap.setBounds(211, 127, 46, 30);
		contentPanel.add(lblCap);
		
		textFieldCap = new JTextField();
		textFieldCap.setColumns(10);
		textFieldCap.setBounds(242, 133, 151, 20);
		contentPanel.add(textFieldCap);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTipo.setBounds(419, 127, 46, 30);
		contentPanel.add(lblTipo);
		
		textFieldTipo = new JTextField();
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(471, 133, 145, 20);
		contentPanel.add(textFieldTipo);
		
		JLabel lblDataDisdetta = new JLabel("Data disdetta");
		lblDataDisdetta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDataDisdetta.setBounds(356, 172, 125, 30);
		contentPanel.add(lblDataDisdetta);
		
		JDateChooser dateChooserDataDisdetta = new JDateChooser();
		dateChooserDataDisdetta.setBounds(449, 172, 167, 26);
		contentPanel.add(dateChooserDataDisdetta);
		
		textFieldStatusRimborso = new JTextField();
		textFieldStatusRimborso.setColumns(10);
		textFieldStatusRimborso.setBounds(116, 205, 215, 20);
		contentPanel.add(textFieldStatusRimborso);
		
		JLabel lblStatusRimborso = new JLabel("Status Rimborso");
		lblStatusRimborso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatusRimborso.setBounds(10, 199, 125, 30);
		contentPanel.add(lblStatusRimborso);
		
		JLabel lblCamera = new JLabel("Camera");
		lblCamera.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCamera.setBounds(356, 202, 125, 30);
		contentPanel.add(lblCamera);
		
		JButton btnNewButtonSalva = new JButton("Salva");
		btnNewButtonSalva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvaCliente();
			}
		});
		btnNewButtonSalva.setBounds(376, 240, 167, 23);
		contentPanel.add(btnNewButtonSalva);
		
	    comboBoxCamera = new JComboBox<Integer>();
		comboBoxCamera.setBounds(419, 205, 86, 26);
		contentPanel.add(comboBoxCamera);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
		if (this.cliente != null) {
			textCodiceFiscale.setText(cliente.getCodiceFiscale());
			textFieldNome.setText(cliente.getNome());
			textFieldCognome.setText(cliente.getCognome());
			dateChooser.setDate(cliente.getDataNascita());
			textFieldNumeroDitelefono.setText(cliente.getNumeroTelefono());
			comboBoxSesso.setSelectedItem(cliente.getSesso());
			textFieldComune.setText(cliente.getComune());
			textFieldVia.setText(cliente.getVia());
			textFieldComune.setText(cliente.getComune());
			textFieldNumeroCivico.setText(cliente.getNumeroCivico() + "");
			textFieldProvincia.setText(cliente.getProvincia());
			textFieldCap.setText(cliente.getCap()+ "");
			textFieldTipo.setText(cliente.isTipo()+"");
			dateChooserDataPrenotazione.setDate(cliente.getDataPrenotazione());
			dateChooserDataDisdetta.setDate(cliente.getDataDisdetta());
			textFieldStatusRimborso.setText(cliente.getStatusRimborso()+"");
			comboBoxCamera.setSelectedItem(getCameraItem(cliente.getCamera()));
			
		}

		caricaCamere();

	}
	private void salvaCliente() {
		Cliente cliente = new Cliente();

		String codFiscaleStr = textCodiceFiscale.getText();
		if (codFiscaleStr.length() == 0) {
			JOptionPane.showMessageDialog(null, "Codice fiscale non inserito");
			return;
		} else if (codFiscaleStr.length() == 16)
			cliente.setCodiceFiscale(codFiscaleStr);
		else {
			JOptionPane.showMessageDialog(null, "Il codice fiscale deve avere 16 caratteri");
			return;
		}

		String nomeStr = textFieldNome.getText();
		if (nomeStr.length() == 0) {
			JOptionPane.showMessageDialog(null, "Nome non inserito");
			return;
		}
		cliente.setNome(nomeStr);

		String cognomeStr = textFieldCognome.getText();
		if (cognomeStr.length() == 0) {
			JOptionPane.showMessageDialog(null, "Cognome non inserito");
			return;
		}
		cliente.setCognome(cognomeStr);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dataStr = sdf.format(dateChooser.getDate());
		System.out.println(dataStr);
		Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cliente.setDataNascita(data);
		
		String numeroDiTelefono = textFieldNumeroDitelefono.getText();
			cliente.setNumeroTelefono(numeroDiTelefono);

		String sesso = (String) comboBoxSesso.getSelectedItem();
		if (sesso.equals("|-------|"))
			cliente.setSesso(null);
		else
			cliente.setSesso(sesso);
		
		String comune = textFieldComune.getText();
		if(numeroDiTelefono.equals("")){
			cliente.setComune(null);
		} else {
			cliente.setComune(comune);
		}
		

		String viaStr = textFieldVia.getText();
		if (viaStr.equals(""))
			cliente.setVia(null);
		else
			cliente.setVia(viaStr);

		String numCivicoStr = textFieldNumeroCivico.getText();
		if (numCivicoStr.length() == 0) {
			cliente.setNumeroCivico(null);
		}
		cliente.setNumeroCivico(numCivicoStr);

		String capStr = textFieldCap.getText();
		Integer cap;
		if (capStr.length() == 0)
			cliente.setCap(null);
		else {
			try {
				cap = Integer.parseInt(capStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Formato del CAP non valido");
				return;
			}
			cliente.setCap(cap);
		}
		String provStr = textFieldProvincia.getText();
		if (provStr.length() == 2 || provStr.length() == 0)
			cliente.setProvincia(provStr);
		else {
			JOptionPane.showMessageDialog(null, "La provincia è formata da due soli caratteri");
			return;
		}
		
		String tipoStr = textFieldTipo.getText();
		boolean tip;
			try {
				tip = Boolean.parseBoolean(tipoStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "tipo non valido");
				return;
			}
			cliente.setTipo(tip);
			
			SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd");
			String dataPre = si.format(dateChooser.getDate());
			System.out.println(dataPre);
			Date dat = null;
			if(dataPre==null) {
				cliente.setDataPrenotazione(null);
			}else {
			try {
				dat = new SimpleDateFormat("yyyy-MM-dd").parse(dataPre);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			cliente.setDataPrenotazione(dat);
	}

			SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
			String dataDis = s.format(dateChooser.getDate());
			System.out.println(dataPre);
			Date da = null;
			if(dataDis==null) {
				cliente.setDataDisdetta(null);
			}else {
			try {
				da = new SimpleDateFormat("yyyy-MM-dd").parse(dataDis);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			cliente.setDataDisdetta(da);
			}
	        String statusrimboro = textFieldStatusRimborso.getText();
			Integer status;
			if (statusrimboro.length() == 0)
				cliente.setStatusRimborso(null);
			else {
				try {
					status = Integer.parseInt(statusrimboro);
				} catch (NumberFormatException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Formato dello stato non valido");
					return;
				}
				cliente.setStatusRimborso(status);
			}
			cliente.setCamera((Integer) comboBoxCamera.getSelectedItem());
			
			
			

		ClienteDAO  clienteDAO = new ClienteDAO();
		if (this.cliente == null) {
			int input1 = JOptionPane.showConfirmDialog(null, "Sicuro di voler salvare il seguente cliente?",
					"Conferma salvataggio", JOptionPane.YES_NO_OPTION);
			if (input1 != 0)
				return;
			if ( clienteDAO.insert(cliente)) {
				JOptionPane.showMessageDialog(null, "Salvataggio avvenuto con successo");
				dispose();
			} else
				JOptionPane.showMessageDialog(null, "Si è verificato un errore ...");
		} 
}
	
//carica Camera
	private void caricaCamere() {
		CameraDAO cameraDAO = new CameraDAO();
		Vector<Camera> allcamera = cameraDAO.getAll();
		for (Camera x : allcamera) {
			comboBoxCamera.addItem(x.getIdCamera());
		}
	}
	// restituisce una camera conoscendo la sua primary key
		private Camera getCameraItem(Integer key) {
			CameraDAO cameraDAO = new CameraDAO();
			return cameraDAO.get(key);
		}
	}