//=============================================================================================//
// FILENAME :       SineWavePanel.java
//
// DESCRIPTION :
//
//
// NOTES :
//        Permission is hereby granted, free of charge, to any person obtaining a copy
//        of this software and associated documentation files (the "Software"), to deal
//        in the Software without restriction, including without limitation the rights
//        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//        copies of the Software, and to permit persons to whom the Software is
//        furnished to do so, subject to the following conditions:
//
//        The above copyright notice and this permission notice shall be included in all
//        copies or substantial portions of the Software.
//
//        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//        SOFTWARE.
//
// AUTHOR   :   Joshua Crotts        START DATE :    12 Nov. 2020
// CLASS    :   CSC - 677 
// SEMESTER :   FALL 2020
//
//=============================================================================================//

package com.joshuacrotts.uncg.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class SineWavePanel extends JPanel {

  /* */
  public static final int WIDTH = 800;
  public static final int HEIGHT = 180;

  /* */
  private final Color BIT_ONE_COLOR = Color.red;
  private final Color BIT_ZERO_COLOR = Color.blue;

  /* */
  private String strSineWaveDrawBits = "";

  /* */
  private final int START_SINE_X = 0;
  private final int START_SINE_Y = 70;

  /* */
  private int THRESHOLD_X = 0;
  private int THRESHOLD_Y = 70;

  /* */
  private double bitOneFrequency = 25.0;
  private double bitZeroFrequency = 50.0;

  public SineWavePanel(String strDrawBits) {
    super(new BorderLayout());
    strSineWaveDrawBits = strDrawBits;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    int sineX = START_SINE_X;
    int sineY = START_SINE_Y;
    int thresholdX = THRESHOLD_X;
    int thresholdY = THRESHOLD_Y;
    char[] chWaveBits = strSineWaveDrawBits.toCharArray();

    for (int j = 0; j < chWaveBits.length; j++) {
      g.setColor(Color.black);
      if (chWaveBits[j] == '1') {
        g.drawLine(thresholdX, thresholdY, thresholdX + 50, thresholdY);
        Polygon p = new Polygon();
        for (int x = sineX; x <= sineX + 50; x++) {
          p.addPoint(x, sineY - (int) (50 * Math.sin((x / bitOneFrequency) * 2 * Math.PI)));

        }
        g.setColor(BIT_ONE_COLOR);
        g.drawString("1", sineX + 25, sineY - 50);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);

      } else {
        g.drawLine(thresholdX, thresholdY, thresholdX + 50, thresholdY);
        Polygon p = new Polygon();
        for (int x = sineX; x <= sineX + 50; x++) {
          p.addPoint(x, sineY - (int) (50 * Math.sin((x / bitZeroFrequency) * 2 * Math.PI)));

        }
        g.setColor(BIT_ZERO_COLOR);
        g.drawString("0", sineX + 25, sineY - 50);
        g.drawPolyline(p.xpoints, p.ypoints, p.npoints);
      }

      sineX += 50;
      thresholdX += 50;
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(Math.max(WIDTH, this.strSineWaveDrawBits.length() * 50), 180);
  }
}
