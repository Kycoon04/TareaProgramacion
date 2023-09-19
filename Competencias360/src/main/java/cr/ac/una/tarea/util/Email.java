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
import jakarta.mail.Multipart;
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
        enviarCorreoReporte(link);
    }

    public void envioCmbClave(String link) {
        enviarClave(link);
    }

    public void enviarCorreoReporte(String enlace) {
        try {
            // Configurar propiedades para el servidor SMTP de Gmail
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.user", sourceMail);
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String mensajeHTML = "<html>"
                    + "<head>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; background-color: #212121; background-image: url(Active.jpg); background-size: cover; background-repeat: no-repeat; background-attachment: fixed; margin: 0; padding: 0; height: 100vh; }" // Modificación aquí
                    + "header { background-color: #333; color: white; text-align: center; padding: 10px 0; }"
                    + "h1 { font-size: 24px; margin-bottom: 20px; }"
                    + "h2 { font-size: 16px; margin-bottom: 20px; }"
                    + "p { font-size: 18px; line-height: 1.6; }"
                    + ".center { text-align: center; }"
                    + "#activeButton { font-family: 'Tw Cen MT'; font-size: 18px; display: inline-block; padding: 10px 20px; background-color: #76ff03; color: black; text-decoration: none; border-radius: 5px; transition: background-color 0.3s ease; cursor: pointer; }"
                    + "#activeButton:hover { background-color: #5ac500; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<header>"
                    + "<h1>Activación de Cuentas Competencias360</h1>"
                    + "<h2>Bienvenido al sistema de evaluaciones 360, para continuar con su proceso de activación, da clic en el siguiente botón</h2>"
                    + "</header>"
                    + "<div class='container'>"
                    + "<p class='center'><a id='activeButton' href='" + enlace + "'>Continuar</a></p>"
                    + "</div>"
                    + "</body>"
                    + "</html>";

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(mensajeHTML, "text/html");

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(htmlPart);

            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(sourceMail));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationMail));
            mensaje.setSubject(asunt);
            mensaje.setContent(multipart);

            Transport transport = session.getTransport("smtp");
            transport.connect(sourceMail, "uuvjaqwjlqglbdhb"); // Reemplaza "tu_contrasena" con tu contraseña
            if (transport.isConnected()) {
                transport.sendMessage(mensaje, mensaje.getAllRecipients());
                transport.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
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

            String mensajeHTML = "<html>"
                    + "<head>"
                    + "<style>"
                    + "body { font-family: Arial, sans-serif; background-color: #f2f2f2; }"
                    + "h1 { color: #333; background-color: grey;  text-align: center; }"
                    + "p { color: #666; }"
                    + "</style>"
                    + "</head>"
                    + "<body>"
                    + "<h1>Recuperación de Contraseña</h1>"
                    + "<p>Se ha detectado un intento de recuperación de contraseña para la dirección de correo:</p>"
                    + "<p><strong>" + destinationMail + "</strong></p>"
                    + "<p>Aquí está su contraseña temporal:</p>"
                    + "<p><strong>" + link + "</strong></p>"
                    + "</body>"
                    + "</html>";

            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress(sourceMail));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinationMail));
            mensaje.setSubject(asunt);

            mensaje.setContent(mensajeHTML, "text/html");

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
