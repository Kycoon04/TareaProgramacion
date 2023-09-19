module cr.ac.una.tarea {
    requires java.logging;
    requires java.desktop;
   
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires jakarta.xml.ws;
    requires jakarta.mail;
    requires jakarta.activation;
    requires java.base;
    requires org.apache.poi.poi;
    requires org.apache.poi.ooxml;
    requires org.apache.xmlbeans;
   
    opens cr.ac.una.tarea;
    opens cr.ac.una.tarea.util;
    opens cr.ac.una.tarea.controller;
    opens cr.ac.una.tarea.view;
    opens cr.ac.una.tarea.service;
    opens cr.ac.una.tarea.soap;
    exports cr.ac.una.tarea;
    opens cr.ac.una.tarea.model to javafx.base;
}
