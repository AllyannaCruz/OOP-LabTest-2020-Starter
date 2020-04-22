package ie.tudublin;

import processing.data.TableRow;


public class Task 
{

    private String taskname;
    private float starttime;
    private float endtime;
    
    public Task(String taskname, float starttime, float endtime) {
        this.taskname = taskname;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Task(TableRow tr)
    {
        this(tr.getString("Task"), tr.getFloat("Start"), tr.getFloat("End"));
    }

    

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public float getStarttime() {
        return starttime;
    }

    public void setStarttime(float starttime) {
        this.starttime = starttime;
    }

    public float getEndtime() {
        return endtime;
    }

    public void setEndtime(float endtime) {
        this.endtime = endtime;
    }
    
    @Override
    public String toString() {
        return "Task [taskname =" + taskname +", starttime=" + starttime +", endtime=" + endtime +" ]";
    }
} //end class