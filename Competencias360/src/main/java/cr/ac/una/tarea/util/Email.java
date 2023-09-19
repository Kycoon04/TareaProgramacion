/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.util;

import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import java.util.Properties;

public class Email {

    private String sourceMail;
    private String destinationMail;
    private String asunt;
    private String archive;
    private String link;
    private String archiveName;
    private String password;

    public Email(String destino, String usuario, String asunto) {
        this.sourceMail = "competencias360develop@gmail.com";
        this.destinationMail = destino;
        this.asunt = asunto;
    }

    public void envioDeCorreos(String link) {
        enviarCorreo(link);
    }

    public void envioCmbClave(String link) {
        enviarClave(link);
    }

    public void envioDeUser(String user) {
        enviarUser(user);
    }

    public void enviarCorreoReporte(String archivo) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", sourceMail);
            p.setProperty("mail.smtp.auth", "true");
            Session s = Session.getDefaultInstance(p);

            BodyPart texto = new MimeBodyPart();

            texto.setText("Adjuntamos el Archivo");

            texto.setDataHandler(new DataHandler(new FileDataSource(archivo + ".pdf")));
            texto.setFileName("Archivo.pdf");
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje = new MimeMessage(s);

            mensaje.setFrom(new InternetAddress(sourceMail));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationMail));
            mensaje.setSubject(asunt);
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            t.connect(sourceMail, "uuvjaqwjlqglbdhb");
            if (t.isConnected()) {
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }

    private void enviarCorreo(String link) {

        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", sourceMail);
            p.setProperty("mail.smtp.auth", "true");
            Session s = Session.getDefaultInstance(p);

            BodyPart texto = new MimeBodyPart();

            texto.setText("Para activar su cuenta presione click en el siguiente enlace: " + link);
            System.out.println(link);
            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(sourceMail));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationMail));
            mensaje.setSubject(asunt);
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            t.connect(sourceMail, "uuvjaqwjlqglbdhb");
            if (t.isConnected()) {
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
            }
            System.out.printf("Mensaje enviado");
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }

    private void enviarClave(String link) {

        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", sourceMail);
            p.setProperty("mail.smtp.auth", "true");
            Session s = Session.getDefaultInstance(p);

            BodyPart texto = new MimeBodyPart();

            texto.setText("Se ha detectado un intento de recuperacion de contraseña. Correo:" + destinationMail + " Contraseña Temporal: " + link);

            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(sourceMail));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationMail));
            mensaje.setSubject(asunt);
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            t.connect(sourceMail, "uuvjaqwjlqglbdhb");
            if (t.isConnected()) {
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
            }
            System.out.printf("Mensaje enviado");
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }

    private void enviarUser(String user) {
        try {
            Properties p = new Properties();
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            p.setProperty("mail.smtp.port", "587");
            p.setProperty("mail.smtp.user", sourceMail);
            p.setProperty("mail.smtp.auth", "true");
            Session s = Session.getDefaultInstance(p);

            BodyPart texto = new MimeBodyPart();

            texto.setText("Su nombre de usuario es: " + user);

            MimeMultipart m = new MimeMultipart();
            m.addBodyPart(texto);

            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(sourceMail));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationMail));
            mensaje.setSubject(asunt);
            mensaje.setContent(m);

            Transport t = s.getTransport("smtp");
            t.connect(sourceMail, "uuvjaqwjlqglbdhb");
            if (t.isConnected()) {
                t.sendMessage(mensaje, mensaje.getAllRecipients());
                t.close();
            }
            System.out.printf("Mensaje enviado");
        } catch (Exception e) {
            System.out.println(e.toString());

        }
    }

}
