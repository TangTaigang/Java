package com.dominhquan.ftp.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.tftp.TFTP;


/*
 * @author F.U.C.K
 * FTP Client Data Class
 */
public class FTP_Data {
    
    private FTPClient ftpClient;
    private InputStream inputStream;
    private OutputStream outputStream;
    
    private int transferMode=TFTP.BINARY_MODE;
    
    
    private String user;
    private String pass;
    private String host;
    private int port;
    
    /*
     *  Getter & Setter
     */
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    /*
     * Default constructor.
     */
    public FTP_Data() { }
    
    public FTP_Data(String user, String pass, String host,int port) {
        this.user = user;
        this.pass = pass;
        this.port = port;
        this.host = host;
    }
    
    public void login() throws IOException{
        if(ftpClient.isAvailable()){
            ftpClient.connect(host, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
        }      
    }
    public void exit() throws IOException{
        if(ftpClient.isConnected()){
            ftpClient.logout();
            ftpClient.disconnect();
        }
    }
    public static void main(String args[]) {
         FTP_Data ftp=new FTP_Data("root","root","192.168.1.20",21);
        try {
            ftp.login();
        } catch (IOException ex) {
            Logger.getLogger(FTP_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
