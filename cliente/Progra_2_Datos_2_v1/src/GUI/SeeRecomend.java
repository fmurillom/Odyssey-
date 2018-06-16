package GUI;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import auxiliar.RecomReq;
import auxiliar.VG;
import auxiliar.XMLizer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import estructuras.Lista_Simple;

import java.awt.Color;
import java.io.IOException;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SeeRecomend extends JFrame{
	
	Lista_Simple<String> recom;
	JComboBox comboBox;
	
	public SeeRecomend() {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		setBounds(100, 100, 453, 303);
		
		JButton btnOk = new JButton("OK");
		
		comboBox = new JComboBox();
		
		RecomReq request = new RecomReq();
		request.setUsrName(VG.USER);
		
		XMLizer.marshallRecomReq(request);
		
		try {
			VG.sendFile(VG.PORT, "../RecomReq.xml", VG.HOST);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			VG.recieveFile();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			recom = XMLizer.getXML_recomRec("recieved", "Rec");
		} catch (SAXException | IOException | ParserConfigurationException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		for(int i = 0; i < recom.getCantidad_de_nodos(); i++) {
			comboBox.addItem(recom.get_dato_por_indice(i));
		}
		
		
		JLabel lblRecomendacion = new JLabel("Recomendacion");
		lblRecomendacion.setForeground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(160)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRecomendacion)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(28, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(85)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblRecomendacion)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(126)
							.addComponent(btnOk)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	

}
