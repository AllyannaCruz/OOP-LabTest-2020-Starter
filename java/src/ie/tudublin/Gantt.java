package ie.tudublin;

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
			float u = map(i, 0, tasks.size(), border, height);

			fill(0);
			rect(left, y, w, h);
			fill(255);
			textAlign(LEFT, CENTER);
			text(t.getTaskname(), left + 10, y + (h/2));
			textAlign(TOP, CENTER);
			text(nf(t.getStarttime(), 0, 2), border + y - h/10, w - (h*10/3) );
			
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
