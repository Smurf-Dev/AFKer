package afk;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;

import afk.node.Task;
import afk.scripts.AFK1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Script.Manifest(name="Easy AFK", description="Keeps you logged in while you are doing other things.")
public class Main extends PollingScript<ClientContext> implements PaintListener{

	private List<Task> taskList = new ArrayList<Task>();
	private static Font font = new Font("Verdana", Font.PLAIN, 15);
	
    private long startTime = System.currentTimeMillis();
    private static final Color fontColor = Color.WHITE;
    
    private static int textAlignY = 14;
    
	@Override
    public void start() {
        taskList.addAll(Arrays.asList(new AFK1(ctx)));
    }

    @Override
    public void poll() {
    	for (Task task : taskList){
    		if (task.activate()){
    			task.execute();
    		}
    	}
    }
    
    public void repaint(final Graphics g) {
    	
    	long currentTime = System.currentTimeMillis();
    	    	
    	Point m = ctx.input.getLocation();
    	
        int mX = (int) m.getX();
        int mY = (int) m.getY();
        
        int startX = 7;
        int startY = 345;
        int endX = 505;
        int endY = 128;
        
        /// Mouse
        g.drawLine(mX - 600, mY + 600, mX - 600, mY + 600);
        g.drawLine(mX - 600, mY - 600, mX - 600, mY - 600);
    	
        /// Not Mouse
        g.setColor(Color.BLACK);
        g.drawRect(startX-1, startY-1, endX+1, endY+1);
    	g.setColor(Color.GRAY);
    	g.fillRect(startX, startY, endX, endY);
    	g.setColor(fontColor);
        g.setFont(font);
        g.drawString("Author: xXJAMYBOIXx", textAlignY, 465);
        g.drawString("Time Spent AFKing: " + (int)(currentTime-startTime)/3600000 + ":" + (int)((currentTime-startTime)-(((currentTime-startTime)/3600000)*3600000))/60000 + ":" + (int)((currentTime-startTime)-(((currentTime-startTime)/3600000)*3600000)-(((currentTime-startTime)-(((currentTime-startTime)/3600000)*3600000))/60000)*60000)/1000, textAlignY, 415);
        g.drawString("Status: " + AFK1.paintStatus, textAlignY, 365);
    }
}