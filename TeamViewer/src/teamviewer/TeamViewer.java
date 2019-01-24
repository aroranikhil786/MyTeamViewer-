package teamviewer;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class TeamViewer {

    static Socket mms = null;
    static Socket mps = null;

    public static void client(final String ip, final NewJFrame fr) {
        Thread t = new Thread() {
            @Override
            public void run() {

                Socket sk = null;
                OutputStream os = null;
                DataOutputStream dos = null;
                try {
                    String msg = Inet4Address.getLocalHost().getHostAddress();

                    sk = new Socket(ip, 7777);
                    os = sk.getOutputStream();

                    dos = new DataOutputStream(os);
                    dos.writeUTF(msg);
                    //
                    serverMouseMove();

                    InputStream is = null;
                    DataInputStream dis = null;
                    InputStream is2 = null;
                    ByteArrayInputStream bais = null;
                    while (true) {
                        // Thread.sleep(10);
                        is = sk.getInputStream();
                        dis = new DataInputStream(is);
                        String size = dis.readUTF();

                        // System.out.println(size);
                        int s = Integer.parseInt(size);

                        is2 = sk.getInputStream();
                        byte[] b = new byte[s];

                        int c = 0;
                        do {
                            c += is2.read(b, c, s - c);

                        } while (!(c >= s));

                        bais = new ByteArrayInputStream(b);
                        BufferedImage bi = ImageIO.read(bais);

                        fr.jLabel1.setIcon(new ImageIcon(bi));

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        sk.close();
                        dos.close();
                        os.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }

    public static void serverMouseMove() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket ss = new ServerSocket(7778);
                    Socket s = ss.accept();
                    mms = s;
                } catch (IOException ex) {
                    Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        };
        t.start();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    ServerSocket ss2 = new ServerSocket(7780);
                    Socket s2 = ss2.accept();
                    mps = s2;
                } catch (IOException ex) {
                    Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t2.start();
    }

    public static void sendMove(int x, int y) {
        if (mms != null) {
            DataOutputStream dos = null;
            try {
                dos = new DataOutputStream(mms.getOutputStream());
                dos.writeUTF(x + "," + y);
            } catch (IOException ex) {
                Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void sendMouseclick(int cd, int n) {
        if (mps != null) {
            DataOutputStream dos = null;
            try {
                dos = new DataOutputStream(mps.getOutputStream());
                dos.writeUTF(cd + "," + n);
            } catch (IOException ex) {
                Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void server() {
        Thread t = new Thread() {
            @Override
            public void run() {

                ServerSocket ssk = null;
                Socket sk = null;
                InputStream is = null;
                DataInputStream dis = null;
                try {
                    ssk = new ServerSocket(7777);
                    sk = ssk.accept();

                    is = sk.getInputStream();
                    dis = new DataInputStream(is);
                    String msg = dis.readUTF();

                    System.out.println(msg);

                    socketMouseMove(msg);
                    socketMouseclick(msg);

                    Toolkit t = Toolkit.getDefaultToolkit();

                    Rectangle rc = new Rectangle(t.getScreenSize());
                    Robot r = new Robot();

                    while (true) {

                        ByteArrayOutputStream baos = null;
                        OutputStream os = null;
                        DataOutputStream dos = null;
                        OutputStream os2 = null;

                        BufferedImage bi = r.createScreenCapture(rc);

                        baos = new ByteArrayOutputStream();
                        ImageIO.write(bi, "jpg", baos);
                        int size = baos.size();
                        //    System.out.println(size);

                        os = sk.getOutputStream();
                        dos = new DataOutputStream(os);
                        dos.writeUTF("" + size);

                        os2 = sk.getOutputStream();
                        ImageIO.write(bi, "jpg", os2);

                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        sk.close();
                        ssk.close();
                        is.close();
                        dis.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        t.start();
    }

    static void socketMouseMove(final String ip) {

        Thread t = new Thread() {
            @Override
            public void run() {
                Socket s = null;
                DataOutputStream dos = null;
                DataInputStream dis = null;

                try {
                    s = new Socket(ip, 7778);
                    //  dos=new DataOutputStream(s.getOutputStream());
                    // dos.writeUTF("");

                    while (!s.isClosed()) {
                        dis = new DataInputStream(s.getInputStream());
                        String mv = dis.readUTF();

                        String arr[] = mv.split("\\,");
                        int x = Integer.parseInt(arr[0]);
                        int y = Integer.parseInt(arr[1]);

                        Robot r = new Robot();
                        r.mouseMove(x, y);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AWTException ex) {
                    Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        t.start();
    }

    static void socketMouseclick(final String ip) {
        Thread t = new Thread() {
            @Override
            public void run() {
                Socket s = null;
                DataOutputStream dos = null;
                DataInputStream dis = null;

                try {
                    s = new Socket(ip, 7780);
                    //  dos=new DataOutputStream(s.getOutputStream());
                    // dos.writeUTF("");

                    while (!s.isClosed()) {
                        dis = new DataInputStream(s.getInputStream());
                        String mv = dis.readUTF();

                        String arr[] = mv.split("\\,");
                        int cd = Integer.parseInt(arr[0]);
                        int n = Integer.parseInt(arr[1]);
                        System.out.println(cd + "" + n);

                        Robot r = new Robot();
                        switch (n) {
                            case 0:
                                r.mousePress(cd);
                                break;
                            case 1:
                                r.mouseRelease(cd);
                                break;
                            case 2:
                                r.keyPress(cd);
                                break;
                            case 3:
                                r.keyRelease(cd);
                                break;


                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AWTException ex) {
                    Logger.getLogger(TeamViewer.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        t.start();
    }
}
