package auxiliar;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.Slider;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.TrackDescription;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
/**
 * CLase utilizada para almacenar metodos de envio  y recepcion de datos, asi como guardar la instancia del reproductor de musica
 */
public class Sender extends JFrame
{
    private final JFrame frame;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private final JButton pauseButton;
    private final JButton rewindButton;
    private final JButton skipButton;
    private String path;
    private JButton btnClose;
    private JButton btnPlay;
    private JLabel lblCurrent;
    private JLabel lblEnd;
    private Thread t;
    private Slider slider;
    private JSlider slider_1;
    
    public static void main(final String[] args)
    {
        new NativeDiscovery().discover();//Get VLC dll
        SwingUtilities.invokeLater(new Runnable()//Instancia la Clase y hace un Hilo
        {
            public void run()
            {
                new Sender("rtsp://192.168.1.6:8544/test");
            }
        });
    }

    
    public Sender(String path)
    {
        frame = new JFrame("Odyssey");
        frame.setBounds(100, 100, 906, 619);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter()
        {
            @SuppressWarnings("deprecation")
			@Override
            public void windowClosing(WindowEvent e)
            {
            	t.stop();
                mediaPlayerComponent.release();//mediaPlayerComponent close
            }
        });

        JPanel contentPane = new JPanel();
        BorderLayout bl_contentPane = new BorderLayout();
        bl_contentPane.setVgap(50);
        contentPane.setLayout(bl_contentPane);

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();//Intancia mediaPlayerComponent
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
        
        btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mediaPlayerComponent.getMediaPlayer().play();
        	}
        });
        
        slider_1 = new JSlider();
        /*
        slider_1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				mediaPlayerComponent.getMediaPlayer().setTime(slider_1.getValue());;
			}

        }); */
        
       
        controlsPane.add(slider_1);
        controlsPane.add(Box.createHorizontalStrut(25));
        
        lblCurrent = new JLabel("current");
        controlsPane.add(lblCurrent);
        controlsPane.add(Box.createHorizontalStrut(25));
        controlsPane.add(btnPlay);
        controlsPane.add(Box.createHorizontalStrut(25));
        pauseButton = new JButton("Pause");
        controlsPane.add(pauseButton);
        controlsPane.add(Box.createHorizontalStrut(25));
        rewindButton = new JButton("Rewind");
        controlsPane.add(rewindButton);
        controlsPane.add(Box.createHorizontalStrut(25));
        skipButton = new JButton("Skip");
        controlsPane.add(skipButton);
        controlsPane.add(Box.createHorizontalStrut(25));
        contentPane.add(controlsPane, BorderLayout.SOUTH);
        
        btnClose = new JButton("Stop");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		mediaPlayerComponent.getMediaPlayer().stop();
        	}
        });
        controlsPane.add(btnClose);
        controlsPane.add(Box.createHorizontalStrut(25));
        
        lblEnd = new JLabel("end");
        controlsPane.add(lblEnd);
        controlsPane.add(Box.createHorizontalStrut(25));

        pauseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mediaPlayerComponent.getMediaPlayer().pause();
            }
        });

        rewindButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mediaPlayerComponent.getMediaPlayer().skip(-10000);
            }
        });

        skipButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                mediaPlayerComponent.getMediaPlayer().skip(10000);
            }
        });

        frame.setContentPane(contentPane);
        frame.setVisible(true);

        //mediaPlayerComponent.getMediaPlayer().playMedia(path);
        
        mediaPlayerComponent.getMediaPlayer().prepareMedia(path);
        
        mediaPlayerComponent.getMediaPlayer().requestParseMedia();
        
        System.out.println(mediaPlayerComponent.getMediaPlayer().isMediaParsed());
        
        
        mediaPlayerComponent.getMediaPlayer().play();
        
       
        slider = new Slider(mediaPlayerComponent, lblCurrent, lblEnd, this.slider_1);
        
        t = new Thread(slider);
        
        t.start();
        
    }

     
}