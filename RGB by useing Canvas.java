package Testing;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.GradientPaint;
import javax.swing.JFrame;

public class TestTwo extends Canvas {
	int r = 0;int g = 0;int b = 0;
	String des = "first";
	JFrame frame;
	Thread thread;
	double takeTime = 1000000000/120;
    double delta = 0;
	long lastTime = System.nanoTime();
    long currectTime;
    public static void main(String[] args)
    {
    	new TestTwo();
    }
    public TestTwo() {
    	StartThread();
    	Window();
    	frame.add(new CanvasOne());
    	frame.setVisible(true);
    	while(thread!=null) {
        currectTime = System.nanoTime();
        delta += (currectTime-lastTime)/takeTime;
        lastTime = currectTime;
       if(delta >= 1) {
    	delta--;
        }
    	}
    }
    public void StartThread() {
    	thread = new Thread();
    	thread.start();
    	System.out.println("Thread is Runnung");
    }
    public void Window() {
    	frame = new JFrame();
    	frame.setTitle("Window");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setBackground(Color.BLACK);
    	frame.setLocation(0,0);
    	frame.setSize(800,600);
    }
    class CanvasOne extends Canvas{
    	public CanvasOne(){
    		setSize(800,600);
    		setBackground(Color.WHITE);
    	}
    	public void paint(Graphics g) {
    		super.paint(g);
    		Graphics2D g2 = (Graphics2D)g;
    		for(int x = 0;x<255;x++) {
    			Color color = new Color(255-x,x,0);
    			g2.setColor(color);
    			g2.drawLine(x,0,x,600);
    		}
    		for(int x = 0;x<255;x++) {
    			Color color = new Color(0,255-x,x);
    			g2.setColor(color);
    			g2.drawLine(255+x,0,255+x,600);
    		}
    		for(int x = 0;x<255;x++) {
    			Color color = new Color(x,0,255-x);
    			g2.setColor(color);
    			g2.drawLine(255+255+x,0,255+255+x,600);
    		}
    		for(int x = 0;x<4;x++) {
    			g2.setColor(Color.BLACK);
    			g2.drawLine(x*255, 0, x*255, 600);
    		}
    	}
    }
}

