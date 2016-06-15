package util;

import edu.mines.jtk.mosaic.*;
import edu.mines.jtk.awt.ColorMap;
import edu.mines.jtk.dsp.*;
import edu.mines.jtk.sgl.*;

import static edu.mines.jtk.util.ArrayMath.*;

import java.awt.Color;
import javax.swing.*;

/**
 * Plotting class to hold various plot methods.
 * @author Elias Arias, Colorado School of Mines, CWP
 * @author Alicia Johnson, Colorado School of Mines, CWP
 * @version 25.05.2016
 */
public class Plot3D {

  private static final double _ratio = 16.0/9.0;
  private static final String _path = 
    System.getProperty("user.home")+"/directory/";

  public static void plot(Sampling s1, Sampling s2, Sampling s3, 
      float[][][] f, String title, float cmin, float cmax, boolean paint) {
    int n1 = s1.getCount();
    int n2 = s2.getCount();
    int n3 = s3.getCount();
    SimpleFrame sf = new SimpleFrame(AxesOrientation.XRIGHT_YIN_ZDOWN);
    ImagePanelGroup ipg = new ImagePanelGroup2(s1,s2,s3,f);
    //ipg.setClips1(-50,50);
    ipg.setClips2(cmin,cmax);
    ipg.setColorModel2(ColorMap.setAlpha(ColorMap.JET,0.0));
    sf.getWorld().addChild(ipg);
    sf.setSize(985,700);   // for sch data
    ViewCanvas vc = sf.getViewCanvas();
    vc.setBackground(Color.WHITE);
    double radius = 0.5*sqrt(n1*n1+n2*n2+n3*n3);
    OrbitView ov = sf.getOrbitView();
    ov.setEyeToScreenDistance(3018.87); // for consistency with brooks
    ov.setWorldSphere(new BoundingSphere(0.5*n1,0.5*n2,0.5*n3,radius));
    ov.setAzimuthAndElevation(45.0,15.0);
    ov.setScale(1.0);
    ov.setTranslate(new Vector3(0.090,0.238,0.012));
    sf.setVisible(true);
    if (paint) {
      sf.paintToFile(_path+title+".png");
    }
  }
}
