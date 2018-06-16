package GUI;

import javax.swing.JLabel;
import javax.swing.JSlider;
import static java.lang.Math.toIntExact;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

public class Slider implements Runnable{
	
	private EmbeddedMediaPlayerComponent mediaPlayerComponent;
	private JLabel labelCurrent;
	private JLabel labelEnd;
	private JSlider slider;
	private long duration = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true) {
			//System.out.println(this.calculateTime(this.mediaPlayerComponent.getMediaPlayer().getTime()));
			if(duration == 0) {
				duration = this.mediaPlayerComponent.getMediaPlayer().getLength();
				slider.setMinimum(0);
				slider.setMaximum(toIntExact(duration));
			}
			labelCurrent.setText(this.calculateTime(this.mediaPlayerComponent.getMediaPlayer().getTime()));
			slider.setValue(toIntExact(this.mediaPlayerComponent.getMediaPlayer().getTime()));
			System.out.println(duration);
			//System.out.println(slider.getMaximum());
			labelEnd.setText(this.calculateTime(mediaPlayerComponent.getMediaPlayer().getLength()));
		}
	}
	
	public Slider(EmbeddedMediaPlayerComponent mpc, JLabel labelCurrent, JLabel labelEnd, JSlider slider){
		this.mediaPlayerComponent = mpc;
		this.labelCurrent = labelCurrent;
		this.labelEnd = labelEnd;
		this.slider = slider;
	}
	
	private String calculateTime(long milliseconds) {
		String currentPlayback = "";
		int seconds = (int) (milliseconds / 1000);
		if(seconds > 59) {
			seconds = seconds % 60;
		}
		int minutes = (int) (milliseconds / (1000 * 60));
		
		currentPlayback += Integer.toString(minutes) + ":" + Integer.toString(seconds);
		
		return currentPlayback;
	}
	

}
