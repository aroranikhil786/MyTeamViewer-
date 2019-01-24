package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.ListModel;

public class Project_clients {

    speed bfr = new speed();
    long n = 0;

    void broadCast(final Frame f) {
        Thread t = new Thread() {
            @Override
            public void run() {
                DatagramSocket ds = null;
                try {
                    ds = new DatagramSocket();
                    ds.setBroadcast(true);
                    String msg = "1234";
                    DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getByName("255.255.255.255"), 8888);

                    ds.send(dp);
                    byte[] b;
                    DatagramPacket dp2 = null;
                    while (true) {
                        try {
                            b = new byte[10];
                            dp2 = new DatagramPacket(b, msg.length());
                            ds.receive(dp2);
                            String recmsg = new String(b);
                            recmsg = recmsg.trim();
                            System.out.println(recmsg + "  " + dp2.getAddress().getHostAddress() + "   " + dp2.getPort() + "   " + dp2.getAddress().getHostName());
                            if (msg.equals(recmsg)) {

                                ListModel<String> l = f.list.getModel();
                                DefaultListModel dl = new DefaultListModel();

                                for (int i = 0; i < l.getSize(); i++) {
                                    dl.add(i, l.getElementAt(i));
                                }
                                dl.add(l.getSize(), dp2.getAddress().getHostAddress() + "(" + dp2.getAddress().getHostName() + ")");

                                f.list.setModel(dl);
                                recmsg = "";

                            } else {
                                if (recmsg.equalsIgnoreCase("Exit")) {
                                    break;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    System.out.println("Thread Exit");

                } catch (SocketException ex) {
                    Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        ds.close();
                    } catch (Exception e) {
                    }
                }

            }
        };
        t.start();
    }

    void ExitRec(final int sec) {
        Thread t = new Thread() {
            @Override
            public void run() {
                DatagramSocket dgs = null;
                try {
                    dgs = new DatagramSocket(8888);
                    dgs.setBroadcast(true);

                    byte[] b = new byte[10];
                    DatagramPacket dp = new DatagramPacket(b, b.length);
                    dgs.receive(dp);

                    Thread.sleep((sec * 1000));
                    System.out.println(dp.getAddress().getHostAddress() + "Exit");

                    String msg = "Exit";
                    DatagramPacket dp2 = new DatagramPacket(msg.getBytes(), msg.length(), dp.getAddress(), dp.getPort());
                    dgs.send(dp2);

                } catch (SocketException ex) {
                    Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        dgs.close();
                    } catch (Exception e) {
                    }
                }
            }
        };
        t.start();

    }

    void Rec(final Frame fr, final File fl, final String ip) {
        final String pass = JOptionPane.showInputDialog(fr, "enter password:", "1234");

        Thread t = new Thread() {
            @Override
            public void run() {
                Socket sk = null;
                OutputStream os = null;
                DataOutputStream dos = null;
                InputStream is = null;
                DataInputStream dis = null;
                FileOutputStream fos = null;
                try {
                    sk = new Socket(ip, 8887);
                    os = sk.getOutputStream();
                    dos = new DataOutputStream(os);
                    dos.writeUTF(pass);
                    is = sk.getInputStream();

                    // BufferedImage bi= ImageIO.read(is);
                    dis = new DataInputStream(sk.getInputStream());
                    String s = dis.readUTF();
                    String[] arr = s.split("\\,");

                    long l = Long.parseLong(arr[0]);
                    String fname = arr[1];


                    is = sk.getInputStream();

                    long ini = System.currentTimeMillis();

                    int sc = 0;

                    fos = new FileOutputStream(new File(fl, fname));

                    String ap = "(10/sec)";
                    bfr.setVisible(true);


                    int flength = 100 * 1024 * 1024;

                    int fpart = (int) (l / (long) flength);
                    long val = 0;
                    byte[] b = new byte[flength];

                    
                    for (int x = 1; x <= fpart; x++) {
                        int c = 0;

                        do {
                            int temp = is.read(b, c, flength - c);
                            c += temp;

                            sc += temp;
                            val += temp;
                            long t = System.currentTimeMillis();
                            if (t - ini >= 1000) {
                                ini = t;
                                //

                                ap = "(" + (sc / 1024) + "kb/sec)";
                                bar(bfr.jProgressBar1, val, l, fname, ap);
                                sc = 0;
                            } else {
                                bar(bfr.jProgressBar1, val, l, fname, ap);
                            }

                        } while (c < flength);
                        fos.write(b);
                    }


                    byte[] bb = new byte[(int) ((long) l % (long) flength)];
                    System.out.println(bb.length + " " + l);
                    int c = 0;

                    do {
                        int temp = is.read(bb, c, bb.length - c);
                        c += temp;
                        val += temp;
                        sc += temp;
                        long t = System.currentTimeMillis();
                        if (t - ini >= 1000) {
                            ini = t;
                            //

                            ap = "(" + (sc / 1024) + "kb/sec)";
                            bar(bfr.jProgressBar1, val, l, fname, ap);
                            sc = 0;
                        } else {
                            bar(bfr.jProgressBar1, val, l, fname, ap);
                        }

                    } while (c < (int) ((long) l % (long) flength));

                    fos.write(bb);





                    bfr.setVisible(false);
                    JOptionPane.showMessageDialog(fr, "File Receive Succesfully");

                    //  gui(bi);
                } catch (IOException ex) {
                    Logger.getLogger(Project_clients.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        dis.close();
                        dos.close();
                        os.close();
                        sk.close();
                        fos.close();
                        is.close();
                    } catch (Exception e) {
                    }
                }

            }
        };
        t.start();

    }

    void bar(JProgressBar jp, long val, long max, String name, String ap) {
        int x = (int) (((double) val / (double) max) * 100);
        jp.setValue(x);
        jp.setStringPainted(true);
        jp.setString(x + " " + name + ap);

    }
}
