/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author miguel
 */
public class JavaMail {
    
    private String user, pass, destino, subject, mensaje;
    private Properties props;

    public JavaMail( String vdestino, String vsubject, String vmensaje) {
        user = "1erdaw2015@gmail.com";
        pass = "villadaw";
        destino = vdestino;
        subject = vsubject;
        mensaje = vmensaje;
        props = new Properties();  
    }

    public String send() {
        String error;
        try {
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            //el puerto que vamos a usar
            props.setProperty("mail.smtp.port", "587");
            //el usuario
            props.setProperty("mail.smtp.user", user);
            //le indicamos que es necesario autentificarse
            props.setProperty("mail.smtp.auth", "true");

            //creamos un objeto session donde le setearemos los parametros
            Session session = Session.getDefaultInstance(props);
            //crearemos el mensaje
            MimeMessage message = new MimeMessage(session);

            //le seteamos el remitente
            message.setFrom(new InternetAddress(user));

            //Obtenemos los destinatarios
            String destinos[] = destino.split(",");
            Address [] receptores = new Address [ destinos.length ];
            int j = 0;
            while(j<destinos.length){
                receptores[j] = new InternetAddress ( destinos[j] ) ;
                j++;
            }
            message.addRecipients(Message.RecipientType.TO, receptores);
            //si queremos 1 solo destinatario
            //message.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));

            //el asunto
            message.setSubject(subject);
            
            //le seteamos el cuerpo del mensaje
            //message.setContent("<html><font color='#AA00FF'>"+mensaje+"<br> Mensaje enviado "+new java.util.Date()+"</font></html>", "text/html");

            //le seteamos el cuerpo del mensaje + envío de adjuntos
            MimeBodyPart mimebodypart1 = new MimeBodyPart();
            //mimebodypart.setText("<html><font color='#AA00FF'>HOLA MUNDO!<br> Mensaje enviado "+new java.util.Date()+"</font></html>");
            mimebodypart1.setContent("<html><font color='#AA00FF'>"+mensaje+"<br> Mensaje enviado "+new java.util.Date()+"</font></html>", "text/html");
            
            /**
            MimeBodyPart mimebodypart2 = new MimeBodyPart();
            DataSource source = new FileDataSource("anexo.txt");
            mimebodypart2.setDataHandler(new DataHandler(source));
            mimebodypart2.setFileName("anexo.txt");*/

            /**
            MimeBodyPart mimebodypart3 = new MimeBodyPart();
            DataSource fds = new FileDataSource("imag.jpg");
            mimebodypart3.setDataHandler(new DataHandler(fds));//establece la imagen como un dato anexo
            mimebodypart3.setHeader("Content-ID","<image>");//embebe la imagen en el cuerpo del mensaje*/

            Multipart multipart = new MimeMultipart("related");
            multipart.addBodyPart(mimebodypart1);
            //multipart.addBodyPart(mimebodypart2);
            //multipart.addBodyPart(mimebodypart3);
            message.setContent(multipart);

            //creamos la conexion y enviamos el mensaje
            Transport t = session.getTransport("smtp");
            t.connect(user, pass);
            t.sendMessage(message, message.getAllRecipients());
            //t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            t.close();
            
            error = "";
        } catch (Exception e) {
            error = e.toString();
        }
        return error;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Mail{" + "user=" + user + ", pass=" + pass + ", destino=" + destino + ", subject=" + subject + ", mensaje=" + mensaje + ", props=" + props + '}';
    }
    
}
