package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;

public class Share extends JDialog {
	private JTextField textFieldFriend;
	private JButton btnShare;
	private JLabel lblFrienUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			Share dialog = new Share();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Share()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(100, 100, 323, 90);
		
		textFieldFriend = new JTextField();
		textFieldFriend.setColumns(10);
		
		btnShare = new JButton("Share");
		btnShare.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nick = textFieldFriend.getText();
				System.out.println("Share");
				dispose();
			}
		});
		
		lblFrienUsername = new JLabel("Frien Username:");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFrienUsername)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldFriend, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnShare)
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldFriend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnShare)
						.addComponent(lblFrienUsername))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		
		lblFrienUsername.setForeground(Color.white);
	}
	public JButton getBtnShare() {
		return btnShare;
	}
	public JLabel getLblFrienUsername() {
		return lblFrienUsername;
	}
}
