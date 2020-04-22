package ie.tudublin;

import processing.data.TableRow;

public class ColorTab 
{
    public int r;
    public int g;
    public int b;
    public int num;

    public ColorTab(int r, int g, int b, int num)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        this.num = num;
    }

    public ColorTab(TableRow tr)
    {
        this(tr.getInt("r"), tr.getInt("g"), tr.getInt("b"), tr.getInt("value"));
    }

    public String toString()
    {
        return this.r + ", " + this.g + ", " + this.b;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }


} //end class