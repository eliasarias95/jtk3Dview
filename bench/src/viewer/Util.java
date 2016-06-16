package viewer;

import java.io.*;
import java.util.*;
import java.nio.*;

import edu.mines.jtk.dsp.Sampling;
import edu.mines.jtk.io.*;
import static edu.mines.jtk.util.ArrayMath.*;

/**
 * Utility class to read/write/convert RSF binary format (Madagascar).
 * @author Elias Arias, Colorado School of Mines, CWP
 * @author Alicia Johnson, Colorado School of Mines, CWP
 * @version 16.06.2016
 */
public class Util {
  public static float[][][] read(int n1, int n2, int n3, String filename) {
    ByteOrder bo = ByteOrder.LITTLE_ENDIAN;
    try {
      ArrayInputStream ais = new ArrayInputStream(filename,bo);
      float[][][] x = new float[n3][n2][n1];
      ais.readFloats(x);
      ais.close();
      return x;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
  public static float[][][] normalize(float[][][] x) {
    int n1 = x[0][0].length;
    int n2 = x[0].length;
    int n3 = x.length;
    float[][][] nx = new float[n3][n2][n1];
    float min = min(x);
    float max = max(x);
    for (float[][] x2 : x) {
      for (float[] x1 : x2) {
        for (float f : x1) {
          nx = (f-min)/(max-min);
        }
      }
    }
    return nx;
  }
  */
}
