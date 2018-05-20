import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.LogIn;
import auxiliar.VG;

public class main
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		LogIn l = new LogIn();
		l.setVisible(true);

	}

}
