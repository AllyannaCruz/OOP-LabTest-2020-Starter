package ie.tudublin;

import java.util.Arrays;
import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	ArrayList<Task> tasks = new ArrayList<Task>();
	
	float border;
	float left;

	float w;
	float h; 

	float[] taskNum = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};


	public void settings()
	{
		size(800, 600);

		border = width * 0.1f;
		left = width * 0.05f;

		w = width * 0.3f;
		h = height * 0.1f;

		
		
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
		for(TableRow row:table.rows())
		{
			Task t = new Task(row);
			tasks.add(t);
		}

	}

	public void printTasks()
	{
		for(Task t:tasks)
		{
			System.out.println(t);
		}
	}

	public void displayTasks()
	{
		for(int i = 0 ; i < tasks.size() ; i++)
		{
			Task t = tasks.get(i);

			float y = map(i, 0, tasks.size(), border, height - border);

			//fill(0);
			//rect(left, y, w, h);
			fill(255);
			textAlign(LEFT, CENTER);
			textLeading(10);
			text(t.getTaskname(), left + 10, y + (h/2));
			/*
			textAlign(TOP, CENTER);
			text(nf(t.getStarttime(), 0, 0), border + y - h/10, w - (h*10/3) );
			textAlign(TOP, CENTER);
			text(nf(t.getEndtime(), 0, 0), border + y - (h/10) + 20 , w - (h*10/3) );
			*/
			
			
		}

		/*
		for(int j = 1 ; j <= 30; j ++)
		{

			float y = map(j, 0, tasks.size(), border, height - border);
			float x =  border + y - (h/10);
			
			textAlign(TOP, LEFT);
			textLeading(10);
			text(j, border + y - (h/10), w - (h*10/3) );
			
		}
		*/

		for(int j = 1 ; j <= taskNum.length; j ++)
		{

			float x = map(j, 0, taskNum.length, border, width - border);
			float y = map(j, 0, taskNum.length, border, height - border );
			
			
			textAlign(RIGHT, TOP);
			textLeading(10);
			text(j, border + x  , w - (h*10/3) );

			//vertical lines
			stroke(255);
			line(y,border,y ,width-border);
			println(y);
			
		}

	}
		
	
	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		loadTasks();
		printTasks();
	}
	
	public void draw()
	{			
		background(0);

		displayTasks();
	}
} //end class
