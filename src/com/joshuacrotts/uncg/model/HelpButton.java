//=============================================================================================//
// FILENAME :       HelpButton.java
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
// AUTHOR   :   Joshua Crotts        START DATE :    23 Aug. 2020
// CLASS    :   CSC - 677 
// SEMESTER :   FALL 2020
//
//=============================================================================================//
package com.joshuacrotts.uncg.model;

import com.joshuacrotts.uncg.Simulator;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class HelpButton extends UIButton implements ActionListener {

  public HelpButton(Simulator simulator) {
    super(simulator, "HELP", "/helpButton.png");

    super.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent ex) {
    this.getSimulator().setPaused(true);
    String helpMessage = "To use this simulator, right-click on an OSI model to view the contents of that layer.\n\nIf the packet (ball) has not reached that layer, it will display a message saying so.\n\nRouters display the sinusoidal wave of the datagram. Just right-click on those once the packet has passed through it.\n\nTo see which path a ball has taken, press the \"TOGGLE TRAILS\" button. This will turn activate a trail behind the packet. Click it again to disable.\n\nPausing the simulation will halt all packets. Stopping the simulation quits the program altogether.";
    JOptionPane.showMessageDialog(this.getSimulator(), helpMessage);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}
