package viewer;

import edu.mines.jtk.dsp.Sampling;

/**
 * Run class.
 * @author Alicia Johnson, Colorado School of Mines, CWP
 * @author Elias Arias, Colorado School of Mines, CWP
 * @version 16.06.2016
 */
public class Run {
  public static void main(String[] args) {
    //String filename = "/Users/earias/home/git/jtk3Dview/data/cubeI.rsf@";
    String filename = "/Users/earias/home/git/jtk3Dview/data/walesTraces.rsf@";
    int n1 = 500; 
    float d1 = 0.8f;
    float f1 = 0.0f;
    Sampling s1 = new Sampling(n1,d1,f1);
    int n2 = 730;
    float d2 = 0.1f;
    float f2 = 0.0f;
    Sampling s2 = new Sampling(n2,d2,f2);
    int n3 = 33;
    float d3 = 1.0f;
    float f3 = 0.0f;
    Sampling s3 = new Sampling(n3,d3,f3);
    float[][][] f = Util.read(n1,n2,n3,filename);

    float cmin = 0.0f;
    float cmax = 0.0f;
    String title = "Plot";
    boolean paint = false;
    Plot3D.plot(s1,s2,s3,f,title,cmin,cmax,paint);
  }
}
