/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.tarea.util;

import cr.ac.una.tarea.model.InformationDto;
import cr.ac.una.tarea.service.ComInformationService;
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
import java.util.List;
import java.util.Properties;

public class Email {

    private String sourceMail;
    private String destinationMail;
    private String asunt;
    private String archive;
    private String link;
    private String archiveName;
    private String password;
    private String name;
    private String info;

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
        ComInformationService comInformationService = new ComInformationService();
        Respuesta respuesta = comInformationService.getComInformation();
        List<InformationDto> list;
        if (!respuesta.getEstado()) {
            System.out.println("Vacia");
            sourceMail = "competencias360develop@gmail.com";
            name = "Competencias360";
            info= "la mejor empresa";
            password= "uuvjaqwjlqglbdhb"; 
        } else {
            list = (List<InformationDto>) respuesta.getResultado("ComInformation");
            sourceMail = list.get(0).getEmail();
            name = list.get(0).getName();
            info = list.get(0).getInformation();
            password= list.get(0).getCpKey();
        }
        try {

            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.user", sourceMail);
            props.put("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props);

            String mensajeHTML = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<style>\n"
                    + "  body {\n"
                    + "    font-family: Arial, sans-serif;\n"
                    + "    background-color: #212121;\n"
                    + "    max-width: 600px;\n"
                    + "    margin: 0 auto;\n"
                    + "    padding: 20px;\n"
                    + "  }\n"
                    + "  header {\n"
                    + "    background-color: #333;\n"
                    + "    color: white;\n"
                    + "    text-align: center;\n"
                    + "    padding: 10px 0;\n"
                    + "  }\n"
                    + "  h1 {\n"
                    + "    font-size: 24px;\n"
                    + "    margin-bottom: 20px;\n"
                    + "    background-color: #333;\n"
                    + "  }\n"
                    + "  h2 {\n"
                    + "    font-size: 16px;\n"
                    + "    margin-bottom: 20px;\n"
                    + "    background-color: #333;\n"
                    + "    padding: 10px;\n"
                    + "  }\n"
                    + "  p {\n"
                    + "    font-size: 18px;\n"
                    + "    line-height: 1.6;\n"
                    + "  }\n"
                    + "  .center {\n"
                    + "    text-align: center;\n"
                    + "  }\n"
                    + "  #activeButton {\n"
                    + "    font-family: 'Tw Cen MT';\n"
                    + "    font-size: 18px;\n"
                    + "    display: inline-block;\n"
                    + "    padding: 10px 20px;\n"
                    + "    background-color: #76ff03;\n"
                    + "    color: black;\n"
                    + "    text-decoration: none;\n"
                    + "    border-radius: 5px;\n"
                    + "    transition: background-color 0.3s ease;\n"
                    + "    cursor: pointer;\n"
                    + "  }\n"
                    + "  #activeButton:hover {\n"
                    + "    background-color: #5ac500;\n"
                    + "  }\n"
                    + "  a {\n"
                    + "    color: #007bff;\n"
                    + "    text-decoration: none;\n"
                    + "  }\n"
                    + "  ul {\n"
                    + "    list-style: none;\n"
                    + "    padding: 0;\n"
                    + "  }\n"
                    + "  li {\n"
                    + "    margin-bottom: 10px;\n"
                    + "  }\n"
                    + "</style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "<header>\n"
                    + "<h1>Activacion de Cuentas " + name + "</h1>\n"
                    + "<h2>Bienvenido al sistema de evaluaciones 360, para continuar con su proceso de activacion, da clic en el siguiente boton</h2>\n"
                    + "<h2>" + info + "</h2>\n"
                    + "</header>\n"
                    + "<div class='container'>\n"
                    + "<p class='center'><a id='activeButton' href='" + enlace + "'>Continuar</a></p>\n"
                    + "</div>\n"
                    + "</body>\n"
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
            transport.connect(sourceMail, password); 
            if (transport.isConnected()) {
                transport.sendMessage(mensaje, mensaje.getAllRecipients());
                transport.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void enviarClave(String link) {
     ComInformationService comInformationService = new ComInformationService();
        Respuesta respuesta = comInformationService.getComInformation();
        List<InformationDto> list;
        if (!respuesta.getEstado()) {
            System.out.println("Vacia");
            sourceMail = "competencias360develop@gmail.com";
            name = "Competencias360";
            password= "uuvjaqwjlqglbdhb"; 
        } else {
            list = (List<InformationDto>) respuesta.getResultado("ComInformation");
            sourceMail = list.get(0).getEmail();
            name = list.get(0).getName();
            info = list.get(0).getInformation();
            password= list.get(0).getCpKey();
            
        }
     
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
            t.connect(sourceMail, password);
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
