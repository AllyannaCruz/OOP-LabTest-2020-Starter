/*
	Student name: Allyanna Riyann Cruz
	Date: 22/04/2020
*/ 

package ie.tudublin;

import java.util.ArrayList;


import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import processing.core.PVector;

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
		//displays task names
		for(int i = 0 ; i < tasks.size() ; i++)
		{
			Task t = tasks.get(i);

			float y = map(i, 0, tasks.size(), border, height - border);


			fill(255);
			textAlign(LEFT, CENTER);
			textLeading(10);
			text(t.getTaskname(), left + 10, y + (h/2));
		}

		//displays number at the top
		for(int j = 1 ; j <= taskNum.length; j ++)
		{

			float x = map(j, 0, taskNum.length, border, width - border);
			float y = map(j, 0, taskNum.length, border, height - border );

			textAlign(RIGHT, TOP);
			textLeading(10);
			text(j, border + x  , w - (h*10/3) );

			//vertical lines 
			stroke(255);
			line(y+90,border,y+90 ,width-border);
			y = y + 10;
			
		}



	}


	public void drawTab() // draws the bars across and gives colour
	{
		noStroke();
		colorMode(HSB);
		for(int i = 0 ; i < tasks.size() ; i ++)
		{
			

			float y = map(i, 0, tasks.size(), border, height - border);
			
			
			tasks.get(i).render(width / 2, y);

			fill(map(i, 0, tasks.size(), 0, 255), 255, 255);
			rect(y+20, y, 50, 20, 5);
			
		}
		
		
	}
		
	
	public void mousePressed()
	{
		/*
		for (int i = 0 ; i < tasks.size() ; i++)
		{
			
			float y = map(i, 0, tasks.size(), border, height - border);
			if(mouseX > y && mouseX < y + w && mouseY > y && mouseY < y+ h) 
			{
				rect(y+20, y, 50-20, 20, 5);
				break;
			}
			
			
		}
		*/

	}

	//the bars turn pink and move when mouse is dragged
	public void mouseDragged()
	{
		for (int i = 0 ; i < tasks.size() ; i++)
		{
			
			float y = map(i, 0, tasks.size(), border, height - border);
			if(mouseX > y && mouseX < y + w && mouseY > y && mouseY < y+ h) 
			{
				rect(y+20, y, 50+20, 20, 2);
				break;
				
			} 
		}

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
		drawTab();
		
	}
} //end class
