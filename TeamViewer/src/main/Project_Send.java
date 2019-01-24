/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author Deepak
 */
public class Project_Send {

    void send(final Frame fr, final File f) {
        final String pass = JOptionPane.showInputDialog(fr, "enter password:", "1234");

        Thread t = new Thread() {
            @Override
            public void run() {
                boolean flag = true;
                while (flag) {
                    ServerSocket ssk = null;
                    Socket sk = null;
                    DataOutputStream dos = null;
                    DataInputStream dis = null;
                    FileInputStream fis = null;
                    OutputStream os = null;
                    try {
                        ssk = new ServerSocket(8887);
                        sk = ssk.accept();
                        dis = new DataInputStream(sk.getInputStream());
                        String msg = dis.readUTF();

                        if (msg.equals(pass)) {
                            flag = false;
                            dos = new DataOutputStream(sk.getOutputStream());
                            dos.writeUTF(f.length() + "," + f.getName());

                            fis = new FileInputStream(f);
                            System.out.println("size:" + f.length());

                            os = sk.getOutputStream();

                            int flength = 100 * 1024 * 1024;//mb             

                            int fpart = (int) (f.length() / (long) flength);

                            byte[] b = new byte[flength];
                            for (int x = 1; x <= fpart; x++) {
                                int count = 0;
                                do {
                                    count += fis.read(b, count, flength - count);
                                } while (count < flength);
                                os.write(b);
                            }

                            int mod = (int) (f.length() % (long) flength);
                            System.out.println(mod + " " + f.length());
                            byte[] bb = new byte[mod];

                            int count = 0;
                            do {
                                count += fis.read(bb, count, mod - count);
                            } while (count < mod);
                            os.write(bb);

                            JOptionPane.showMessageDialog(fr, "File Send!");
                            int in = fr.jList1.getSelectedIndex();

                            ListModel lm = fr.jList1.getModel();
                            DefaultListModel dl = new DefaultListModel();

                            int i = 0;

                            for (int x = 0; x < lm.getSize(); x++) {

                                if (x != in) {
                                    dl.add(i++, lm.getElementAt(x));
                                }
                            }
                            fr.jList1.setModel(dl);

                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Project_Send.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            dis.close();
                            sk.close();
                            ssk.close();
                            dos.close();
                            os.close();
                            fis.close();
                        } catch (Exception e) {
                        }

                    }
                }

            }
        };
        t.start();
    }

    public void dGS(Frame f) {
        Thread t = new Thread() {
            @Override
            public void run() {
                //while (true) {

                try {
                    System.out.println("dGs(8888).....");
                    DatagramSocket server = new DatagramSocket(8888, InetAddress.getByName("0.0.0.0"));
                    server.setBroadcast(true);

                    byte[] b = new byte[50];
                    DatagramPacket p = new DatagramPacket(b, b.length);
                    server.receive(p);

                    String msg = new String(b);
                    msg = msg.trim();

                    System.out.println(msg + " " + p.getAddress().getHostAddress() + " " + p.getPort() + " " + p.getAddress().getHostName());

                    DatagramPacket p2 = new DatagramPacket(msg.getBytes(), msg.length(), p.getAddress(), p.getPort());
                    server.send(p2);

                    server.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

            // }
        };
        t.start();

    }

    boolean port(int p) {
        boolean res = false;
        try {
            ServerSocket sk = new ServerSocket(p);
            sk.close();
            res = true;
        } catch (Exception e) {
            res = false;
        }

        return res;
    }
}
