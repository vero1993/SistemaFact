/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.Reportes;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.Utilidades;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Cliente;
import modelo.Abonos;
import modelo.Pedido;

/**
 *
 * @author Steven Y
 */
public class Reportes {

    public static void reporteAbono(String cliente, String num_pedido, Abonos pago, Date fechainicio, double totalPedido, double totalAbonado, double saldoPend, Long idPago, String usuario) {
        Document documento = new Document(PageSize.A6);
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat RedondearADos = new DecimalFormat("0.00", simbolos);
        Date date = new Date();
        try {
            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            System.out.println("Hora y fecha: "+hourdateFormat.format(date));
            FileOutputStream salida = new FileOutputStream(cliente + idPago + ".pdf");//
            PdfWriter.getInstance(documento, salida);
            documento.open();

            /*=============ENCABEZADO=====================*/
            Paragraph titulo1 = new Paragraph("FLORISTERIA VERARTE",new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.BLACK));
            titulo1.setAlignment(Element.ALIGN_CENTER);
            Paragraph titulo2 = new Paragraph("IMPRESIÓN DE ABONO",new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK));
            titulo2.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo1);
            documento.add(titulo2);
            documento.add(new Paragraph(" "));
            
            Paragraph periodoLectivo = new Paragraph(("NÚMERO PEDIDO: "+ num_pedido), new Font(Font.FontFamily.TIMES_ROMAN,9,Font.NORMAL,BaseColor.BLACK));
            documento.add(periodoLectivo);
            Paragraph nombreCliente = new Paragraph(("CLIENTE: "+ cliente), new Font(Font.FontFamily.TIMES_ROMAN,9,Font.NORMAL,BaseColor.BLACK));
            documento.add(nombreCliente);
            
            Paragraph fechaAbono = new Paragraph(("HORA Y FECHA: "+ hourdateFormat.format(date)), new Font(Font.FontFamily.TIMES_ROMAN,9,Font.NORMAL,BaseColor.BLACK));
            documento.add(fechaAbono);
            
            Paragraph totPed = new Paragraph(("TOTAL DE PEDIDO: "+ RedondearADos.format(totalPedido)), new Font(Font.FontFamily.TIMES_ROMAN,9,Font.NORMAL,BaseColor.BLACK));
            documento.add(totPed);
            
            Paragraph totAbon = new Paragraph(("TOTAL ABONADO: "+ RedondearADos.format(totalAbonado)), new Font(Font.FontFamily.TIMES_ROMAN,9,Font.NORMAL,BaseColor.BLACK));
            documento.add(totAbon);
            
            Paragraph salPen = new Paragraph(("SALDO PENDIENTE: "+ RedondearADos.format(saldoPend)), new Font(Font.FontFamily.TIMES_ROMAN,9,Font.NORMAL,BaseColor.BLACK));
            documento.add(salPen);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            Paragraph barraFirma = new Paragraph("f._________________________",new Font(Font.FontFamily.HELVETICA, 9, Font.BOLD, BaseColor.BLACK));
            barraFirma.setAlignment(Element.ALIGN_CENTER);
            documento.add(barraFirma);
            
            Paragraph usu = new Paragraph(usuario, new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK));
            usu.setAlignment(Element.ALIGN_CENTER);
            documento.add(usu);
            Paragraph fAuto = new Paragraph("FIRMA AUTORIZADA", new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK));
            fAuto.setAlignment(Element.ALIGN_CENTER);
            documento.add(fAuto);
            
            documento.close();
            File archivo = new File(cliente + idPago + ".pdf");
            Utilidades.llamarArchivo(archivo.getPath());

        } catch (Exception e) {
        }
    }

}
