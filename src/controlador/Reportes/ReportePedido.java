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
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.Servicios.ServicioDetallePedido;

import controlador.Servicios.ServicioPedido;
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
import modelo.DetallePedido;
import modelo.Pedido;

/**
 *
 * @author Steven Y
 */
public class ReportePedido {

    public static void reporteAbono(Pedido pedido) {
        Document documento = new Document(PageSize.A5);
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat RedondearADos = new DecimalFormat("0.00", simbolos);
        Date date = new Date();
        try {
            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            System.out.println("Hora y fecha: "+hourdateFormat.format(pedido.getFec_ped()));
            FileOutputStream salida = new FileOutputStream("ReportePedido.pdf");//
            Image logo = Image.getInstance("verartelogo.jpg");
            logo.setAbsolutePosition(40, 535);  
            logo.scalePercent(75);
            PdfWriter.getInstance(documento, salida);
            documento.open();
            //float[] medidasCeldas = {2.50f, 0.65f, 0.65f};
//            PdfPTable tabla = new PdfPTable(3);
//            tabla.setWidthPercentage(100);
//            tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//            tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            //tabla.setWidths(medidasCeldas);
            /*=============FORMATO PARA LAS CELDAS*/
            
            Paragraph titulo = new Paragraph("FLORISTERIA VERARTE", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            PdfPTable tablaEncabezado = new PdfPTable(2);
            tablaEncabezado.setWidthPercentage(100);
            
            
            Paragraph detalelPedido = new Paragraph("DETALLE DE PEDIDO", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK));
            detalelPedido.setAlignment(Element.ALIGN_CENTER);
            
            /*=====ENCABEZADO====*/
            Paragraph publicidad = new Paragraph("Venta de Flores, Rosas y Arreglos Florares a su eleccion", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celPublicidad = new PdfPCell(publicidad);
            celPublicidad.setRowspan(2);
            celPublicidad.setBorder(0);
            celPublicidad.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            Paragraph informacion = new Paragraph("YAURI CABREARA VERONICA ELIZABETH\n"
                    + "RUC: 1104428683\n"
                    + "AUT. SRI. 118325832", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celInformacion = new PdfPCell(informacion);
            
            Paragraph direccionEmpresa = new Paragraph("Direccion: Calle Bernardo Valdivieso 11:22"
                    + " entre Mercadillo  y Azuay Telf. 2573511 Telefax: 2576103"
                    + " Cel.: 0999281693 Loja - Ecuador", new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.BLACK));
            direccionEmpresa.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph sinValidez = new Paragraph("DOCUMENTO SIN VALIDEZ TRIBUTARIA", new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.BLACK));
            sinValidez.setAlignment(Element.ALIGN_CENTER);
            
            //celInformacion.setRowspan(2);
            celInformacion.setBorder(0);
            celInformacion.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            /*=======TABLA PARA SACAR LOS VALORES GENERALES*/
            float[] medidasCeldasTabla2 = {0.70f, 3.0f, 1.00f, 1.50f};
            PdfPTable tabla2 = new PdfPTable(4);
            tabla2.setWidthPercentage(100);
            tabla2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla2.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tabla2.setWidths(medidasCeldasTabla2);
            
            /*=======VALORES PARA LLENAR LA TABLA 2*/
            Paragraph nombreCliente = new Paragraph("CLIENTE:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreCliente = new PdfPCell(nombreCliente);
            celNombreCliente.setBorder(0);
            celNombreCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celNombreCliente);
            
            Paragraph nombresCliente = new Paragraph(pedido.getCliente().getApe_per()+" "+pedido.getCliente().getNom_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celNombresCliente = new PdfPCell(nombresCliente);
            celNombresCliente.setBorder(0);
            celNombreCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celNombresCliente);
            
            Paragraph fecha = new Paragraph("FECHA:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celfecha = new PdfPCell();
            celfecha.setBorder(0);
            celfecha.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celfecha);
            
            Paragraph fechaRecibida = new Paragraph(hourdateFormat.format(date), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celfechaRecibida = new PdfPCell(fechaRecibida);
            celfechaRecibida.setBorder(0);
            celfechaRecibida.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celfechaRecibida);
            
            //SEGUNDA FILA
            
            Paragraph nombreRuc = new Paragraph("CÉDULA:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreRuc = new PdfPCell(nombreRuc);
            celNombreRuc.setBorder(0);
            celNombreRuc.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celNombreRuc);
            
            Paragraph rucRecibido = new Paragraph(pedido.getCliente().getCed_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celrucRecibido = new PdfPCell(rucRecibido);
            celrucRecibido.setBorder(0);
            celrucRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celrucRecibido);
            
            Paragraph nombreTele = new Paragraph("TELÉF:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celnombreTele = new PdfPCell(nombreTele);
            celnombreTele.setBorder(0);
            celnombreTele.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnombreTele);
            
            Paragraph teleRecibido = new Paragraph(pedido.getCliente().getTel_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celteleRecibido = new PdfPCell(teleRecibido);
            celteleRecibido.setBorder(0);
            celteleRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celteleRecibido);
            
            //TERCERA FILA
            
            Paragraph nombreDir = new Paragraph("DIR:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celnombreDir = new PdfPCell(nombreDir);
            celnombreDir.setBorder(0);
            celnombreDir.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnombreDir);
            
            Paragraph dirRecibido = new Paragraph(pedido.getCliente().getDir_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celdirRecibido = new PdfPCell(dirRecibido);
            celdirRecibido.setBorder(0);
            celdirRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celdirRecibido);
            
            Paragraph nombreNumPedido = new Paragraph("NUM. PEDIDO:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celnombreNumPedido = new PdfPCell(nombreNumPedido);
            celnombreNumPedido.setBorder(0);
            celnombreNumPedido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnombreNumPedido);
            
            Paragraph numPedRecibido = new Paragraph(pedido.getNum_pedido(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celnumPedRecibido = new PdfPCell(numPedRecibido);
            celnumPedRecibido.setBorder(0);
            celnumPedRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnumPedRecibido);
            
            /*=====TABLA DEL DETALLE DE PEDIDO*/
            float[] medidasCeldasDetalle = {1.00f, 3.0f, 0.50f, 0.65f, 0.65f};
            PdfPTable tablaDetalle = new PdfPTable(5);
            tablaDetalle.setWidthPercentage(100);
            
            tablaDetalle.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tablaDetalle.setWidths(medidasCeldasDetalle);
            
            /*CABECERA DE LA TABLA DETALLE DE PEDIDO*/
            Paragraph cNombreCodigo = new Paragraph("CÓDIGO", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreCodigo = new PdfPCell(cNombreCodigo);
            //celTitulo.setColspan(3);
            celNombreCodigo.setBorder(0);
            celNombreCodigo.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombreCodigo);
            
            Paragraph cNombreDetalle = new Paragraph("DETALLE", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreDetalle = new PdfPCell(cNombreDetalle);
            celNombreDetalle.setBorder(0);
            celNombreDetalle.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombreDetalle);
            
            Paragraph cNombreCantidad = new Paragraph("CANT.", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreCantidad = new PdfPCell(cNombreCantidad);
            celNombreCantidad.setBorder(0);
            celNombreCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombreCantidad);
            
            Paragraph cNombrePUnit = new Paragraph("P. UNIT.", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombrePUnit = new PdfPCell(cNombrePUnit);
            celNombrePUnit.setBorder(0);
            celNombrePUnit.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombrePUnit);
            
            Paragraph cNombrePTotal = new Paragraph("P. TOTAL", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombrePTotal = new PdfPCell(cNombrePTotal);
            celNombrePTotal.setBorder(0);
            celNombrePTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombrePTotal);
            
            /*LLENADO DE TABLA DE PEDIDO*/
            ServicioDetallePedido sDetallePedido  = new ServicioDetallePedido();
            Font standardFont = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL, BaseColor.BLACK);
            
            for (DetallePedido detallePedido: sDetallePedido.listarPedidosparaReporte(pedido.getId_ped())) {
                PdfPCell clCodigoProducto = new PdfPCell(new Phrase(detallePedido.getProducto().getCod_producto(), standardFont));
                PdfPCell clNombreProducto = new PdfPCell(new Phrase(detallePedido.getProducto().getNom_producto(), standardFont));
                PdfPCell clCantProductos= new PdfPCell(new Phrase(String.valueOf(detallePedido.getCant_productos()), standardFont));
                PdfPCell clPrecioSinIva = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(detallePedido.getProducto().getPrecioSinIva())), standardFont));
                PdfPCell clTotalPrecioPro = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(detallePedido.getTotal())), standardFont));
                clCodigoProducto.setBorder(0);
                clNombreProducto.setBorder(0);
                clCantProductos.setBorder(0);
                clPrecioSinIva.setBorder(0);
                clPrecioSinIva.setHorizontalAlignment(Element.ALIGN_RIGHT);
                clTotalPrecioPro.setBorder(0);
                clTotalPrecioPro.setHorizontalAlignment(Element.ALIGN_RIGHT);
                
                tablaDetalle.addCell(clCodigoProducto);
                tablaDetalle.addCell(clNombreProducto);
                tablaDetalle.addCell(clCantProductos);
                tablaDetalle.addCell(clPrecioSinIva);
                tablaDetalle.addCell(clTotalPrecioPro);
                
            }
            
            
            documento.add(logo);
            documento.add(titulo);
            
            tablaEncabezado.addCell(celPublicidad);
            tablaEncabezado.addCell(celInformacion);
//            tabla.addCell(seccion1);
            documento.add(new Paragraph(" "));
            documento.add(tablaEncabezado);
            documento.add(direccionEmpresa);
            documento.add(new Paragraph("---------------------------------------"
                    + "------------------------------------------------"
                    + "------------------------------------------------"
                    + "--------------", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK)));
            //documento.add(new Paragraph(" "));
            documento.add(tabla2);
            documento.add(new Paragraph("---------------------------------------"
                    + "------------------------------------------------"
                    + "------------------------------------------------"
                    + "--------------", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK)));
            documento.add(detalelPedido);
            documento.add(sinValidez);
            documento.add(new Paragraph(" "));
            documento.add(tablaDetalle);
            /*=============ENCABEZADO=====================
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
            documento.add(fAuto);*/
            
=======
import controlador.Utilidades;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.DetallePedido;
import modelo.Pedido;

/**
 *
 * @author Steven Y
 */
public class ReportePedido {

    public static void reportePedido(Pedido pedido) {
        Document documento = new Document(PageSize.A5, 20, 20, 15, 10);
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
        simbolos.setDecimalSeparator('.');
        DecimalFormat RedondearADos = new DecimalFormat("0.00", simbolos);
        Date date = new Date();
        try {
            DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            System.out.println("Hora y fecha: "+hourdateFormat.format(pedido.getFec_ped()));
            FileOutputStream salida = new FileOutputStream("ReportePedido.pdf");//
            Image logo = Image.getInstance("verartelogo.jpg");
            logo.setAbsolutePosition(40, 540);  
            logo.scalePercent(75);
            PdfWriter.getInstance(documento, salida);
            documento.open();
            //float[] medidasCeldas = {2.50f, 0.65f, 0.65f};
//            PdfPTable tabla = new PdfPTable(3);
//            tabla.setWidthPercentage(100);
//            tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
//            tabla.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            //tabla.setWidths(medidasCeldas);
            /*=============FORMATO PARA LAS CELDAS*/
            
            Paragraph titulo = new Paragraph("FLORISTERIA VERARTE", new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            PdfPTable tablaEncabezado = new PdfPTable(2);
            tablaEncabezado.setWidthPercentage(100);
            
            
            Paragraph detalelPedido = new Paragraph("DETALLE DE PEDIDO", new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD, BaseColor.BLACK));
            detalelPedido.setAlignment(Element.ALIGN_CENTER);
            
            /*=====ENCABEZADO====*/
            Paragraph publicidad = new Paragraph("Venta al por menor de flores, articulos de bazar en general y productos de confitería", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celPublicidad = new PdfPCell(publicidad);
            celPublicidad.setRowspan(2);
            celPublicidad.setBorder(0);
            celPublicidad.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            Paragraph informacion = new Paragraph("VERONICA CONSUELO ABAD ABAD\n"
                    + "RUC: 1103702369001\n"
                    + "AUT. SRI. 1120737184", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celInformacion = new PdfPCell(informacion);
            
            Paragraph direccionEmpresa = new Paragraph("Direccion: Calle Miguel Riofrio"
                    + " entre Bolivar y Bernardo Valdivieso (Diagonal al Topoli) \n Telf. 07258593"
                    + " Cel.: 0980924052 / 0999372331 Loja - Ecuador", new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.BLACK));
            direccionEmpresa.setAlignment(Element.ALIGN_CENTER);
            
            Paragraph sinValidez = new Paragraph("DOCUMENTO SIN VALIDEZ TRIBUTARIA", new Font(Font.FontFamily.HELVETICA, 6, Font.BOLD, BaseColor.BLACK));
            sinValidez.setAlignment(Element.ALIGN_CENTER);
            
            //celInformacion.setRowspan(2);
            celInformacion.setBorder(0);
            celInformacion.setHorizontalAlignment(Element.ALIGN_CENTER);
            
            /*=======TABLA PARA SACAR LOS VALORES GENERALES*/
            float[] medidasCeldasTabla2 = {0.70f, 3.0f, 1.00f, 1.50f};
            PdfPTable tabla2 = new PdfPTable(4);
            tabla2.setWidthPercentage(100);
            tabla2.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla2.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tabla2.setWidths(medidasCeldasTabla2);
            
            /*=======VALORES PARA LLENAR LA TABLA 2*/
            Paragraph nombreCliente = new Paragraph("CLIENTE:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreCliente = new PdfPCell(nombreCliente);
            celNombreCliente.setBorder(0);
            celNombreCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celNombreCliente);
            
            Paragraph nombresCliente = new Paragraph(pedido.getCliente().getApe_per()+" "+pedido.getCliente().getNom_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celNombresCliente = new PdfPCell(nombresCliente);
            celNombresCliente.setBorder(0);
            celNombreCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celNombresCliente);
            
            Paragraph fecha = new Paragraph("FECHA:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celfecha = new PdfPCell(fecha);
            celfecha.setBorder(0);
            celfecha.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celfecha);
            
            Paragraph fechaRecibida = new Paragraph(hourdateFormat.format(pedido.getFec_ped()), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celfechaRecibida = new PdfPCell(fechaRecibida);
            celfechaRecibida.setBorder(0);
            celfechaRecibida.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celfechaRecibida);
            
            //SEGUNDA FILA
            
            Paragraph nombreRuc = new Paragraph("CÉDULA:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreRuc = new PdfPCell(nombreRuc);
            celNombreRuc.setBorder(0);
            celNombreRuc.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celNombreRuc);
            
            Paragraph rucRecibido = new Paragraph(pedido.getCliente().getCed_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celrucRecibido = new PdfPCell(rucRecibido);
            celrucRecibido.setBorder(0);
            celrucRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celrucRecibido);
            
            Paragraph nombreTele = new Paragraph("TELÉF:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celnombreTele = new PdfPCell(nombreTele);
            celnombreTele.setBorder(0);
            celnombreTele.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnombreTele);
            
            Paragraph teleRecibido = new Paragraph(pedido.getCliente().getTel_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celteleRecibido = new PdfPCell(teleRecibido);
            celteleRecibido.setBorder(0);
            celteleRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celteleRecibido);
            
            //TERCERA FILA
            
            Paragraph nombreDir = new Paragraph("DIR:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celnombreDir = new PdfPCell(nombreDir);
            celnombreDir.setBorder(0);
            celnombreDir.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnombreDir);
            
            Paragraph dirRecibido = new Paragraph(pedido.getCliente().getDir_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celdirRecibido = new PdfPCell(dirRecibido);
            celdirRecibido.setBorder(0);
            celdirRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celdirRecibido);
            
            Paragraph nombreNumPedido = new Paragraph("NUM. PEDIDO:", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celnombreNumPedido = new PdfPCell(nombreNumPedido);
            celnombreNumPedido.setBorder(0);
            celnombreNumPedido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnombreNumPedido);
            
            Paragraph numPedRecibido = new Paragraph(pedido.getNum_pedido(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celnumPedRecibido = new PdfPCell(numPedRecibido);
            celnumPedRecibido.setBorder(0);
            celnumPedRecibido.setHorizontalAlignment(Element.ALIGN_LEFT);
            tabla2.addCell(celnumPedRecibido);
            
            /*=====TABLA DEL DETALLE DE PEDIDO*/
            float[] medidasCeldasDetalle = {1.00f, 3.0f, 0.50f, 0.65f, 0.65f};
            PdfPTable tablaDetalle = new PdfPTable(5);
            tablaDetalle.setWidthPercentage(100);
            
            tablaDetalle.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tablaDetalle.setWidths(medidasCeldasDetalle);
            
            /*CABECERA DE LA TABLA DETALLE DE PEDIDO*/
            Paragraph cNombreCodigo = new Paragraph("CÓDIGO", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreCodigo = new PdfPCell(cNombreCodigo);
            //celTitulo.setColspan(3);
            celNombreCodigo.setBorder(0);
            celNombreCodigo.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombreCodigo);
            
            Paragraph cNombreDetalle = new Paragraph("DETALLE", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreDetalle = new PdfPCell(cNombreDetalle);
            celNombreDetalle.setBorder(0);
            celNombreDetalle.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombreDetalle);
            
            Paragraph cNombreCantidad = new Paragraph("CANT.", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreCantidad = new PdfPCell(cNombreCantidad);
            celNombreCantidad.setBorder(0);
            celNombreCantidad.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombreCantidad);
            
            Paragraph cNombrePUnit = new Paragraph("P. UNIT.", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombrePUnit = new PdfPCell(cNombrePUnit);
            celNombrePUnit.setBorder(0);
            celNombrePUnit.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombrePUnit);
            
            Paragraph cNombrePTotal = new Paragraph("P. TOTAL", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombrePTotal = new PdfPCell(cNombrePTotal);
            celNombrePTotal.setBorder(0);
            celNombrePTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDetalle.addCell(celNombrePTotal);
            
            /*LLENADO DE TABLA DE PEDIDO*/
            ServicioDetallePedido sDetallePedido  = new ServicioDetallePedido();
            Font standardFont = new Font(Font.FontFamily.HELVETICA, 6, Font.NORMAL, BaseColor.BLACK);
            
            for (DetallePedido detallePedido: sDetallePedido.listarPedidosparaReporte(pedido.getId_ped())) {
                PdfPCell clCodigoProducto = new PdfPCell(new Phrase(detallePedido.getProducto().getCod_producto(), standardFont));
                PdfPCell clNombreProducto = new PdfPCell(new Phrase(detallePedido.getProducto().getNom_producto(), standardFont));
                PdfPCell clCantProductos= new PdfPCell(new Phrase(String.valueOf(detallePedido.getCant_productos()), standardFont));
                PdfPCell clPrecioSinIva = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(detallePedido.getProducto().getPrecioSinIva())), standardFont));
                PdfPCell clTotalPrecioPro = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(detallePedido.getTotal())), standardFont));
                clCodigoProducto.setBorder(0);
                clNombreProducto.setBorder(0);
                clCantProductos.setBorder(0);
                clPrecioSinIva.setBorder(0);
                clPrecioSinIva.setHorizontalAlignment(Element.ALIGN_RIGHT);
                clTotalPrecioPro.setBorder(0);
                clTotalPrecioPro.setHorizontalAlignment(Element.ALIGN_RIGHT);
                
                tablaDetalle.addCell(clCodigoProducto);
                tablaDetalle.addCell(clNombreProducto);
                tablaDetalle.addCell(clCantProductos);
                tablaDetalle.addCell(clPrecioSinIva);
                tablaDetalle.addCell(clTotalPrecioPro);
                
            }
            
            /*====LLENAR LOS TOTALTES===*/
            float[] medidasCeldasTotales = {0.60f, 0.40f};
            PdfPTable tablaTotales = new PdfPTable(2);
            tablaTotales.setWidthPercentage(23);
            
            tablaTotales.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaTotales.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tablaTotales.setWidths(medidasCeldasTotales);
            tablaTotales.setHorizontalAlignment(Element.ALIGN_RIGHT);
            
            Paragraph clinea= new Paragraph("-----------------------------------", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell cellinea = new PdfPCell(clinea);
            cellinea.setColspan(2);
            cellinea.setBorder(0);
            tablaTotales.addCell(cellinea);
            
            Paragraph cNombreSubtotal= new Paragraph("SUBTOTAL", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreTotal = new PdfPCell(cNombreSubtotal);
            //celTitulo.setColspan(3);
            celNombreTotal.setBorder(0);
            celNombreTotal.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(celNombreTotal);
            PdfPCell clSubtotalPedido = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(pedido.getSubtotalDoce())), standardFont));
            clSubtotalPedido.setBorder(0);
            clSubtotalPedido.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(clSubtotalPedido);
            
            Paragraph cNombreDescuento= new Paragraph("DESCTO", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreDescuento = new PdfPCell(cNombreDescuento);
            celNombreDescuento.setBorder(0);
            celNombreDescuento.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(celNombreDescuento);
            PdfPCell clDescuentoPedido = new PdfPCell(new Phrase(String.valueOf("0.00"), standardFont));
            clDescuentoPedido.setBorder(0);
            clDescuentoPedido.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(clDescuentoPedido);
            
            Paragraph cNombreIvaCero= new Paragraph("SUB. IVA 0%", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreIvaCero = new PdfPCell(cNombreIvaCero);
            celNombreIvaCero.setBorder(0);
            celNombreIvaCero.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(celNombreIvaCero);
            PdfPCell clIvaCeroPedido = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(pedido.getSubtotalCero())), standardFont));
            clIvaCeroPedido.setBorder(0);
            clIvaCeroPedido.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(clIvaCeroPedido);
            
            Paragraph cNombreIvaDoce= new Paragraph("IVA 12.00%", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreIvaDoce = new PdfPCell(cNombreIvaDoce);
            celNombreIvaDoce.setBorder(0);
            celNombreIvaDoce.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(celNombreIvaDoce);
            PdfPCell clIvaDocePedido = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(pedido.getIvaDoce())), standardFont));
            clIvaDocePedido.setBorder(0);
            clIvaDocePedido.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(clIvaDocePedido);
            
            Paragraph clinea2= new Paragraph("-----------------------------------", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell cellinea2 = new PdfPCell(clinea2);
            cellinea2.setColspan(2);
            cellinea2.setBorder(0);
            tablaTotales.addCell(cellinea2);
            
            Paragraph cNombreTotalP= new Paragraph("TOTAL US%", new Font(Font.FontFamily.HELVETICA, 7, Font.BOLD, BaseColor.BLACK));
            PdfPCell celNombreTotalP = new PdfPCell(cNombreTotalP);
            celNombreTotalP.setBorder(0);
            celNombreTotalP.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(celNombreTotalP);
            PdfPCell clTotalPedido = new PdfPCell(new Phrase(String.valueOf(RedondearADos.format(pedido.getTot_ped())), standardFont));
            clTotalPedido.setBorder(0);
            clTotalPedido.setHorizontalAlignment(Element.ALIGN_RIGHT);
            tablaTotales.addCell(clTotalPedido);
            
            Paragraph clinea3= new Paragraph("-----------------------------------", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell cellinea3 = new PdfPCell(clinea3);
            cellinea3.setColspan(2);
            cellinea3.setBorder(0);
            tablaTotales.addCell(cellinea3);
            
            /*====TABLA PARA LAS FIRMAS===*/
            float[] medidasCeldasFirmas = {0.60f, 0.40f};
            PdfPTable tablaFirmas = new PdfPTable(2);
            tablaFirmas.setWidthPercentage(100);
            
            tablaFirmas.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaFirmas.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);
            tablaFirmas.setWidths(medidasCeldasFirmas);
            //tablaFirmas.setHorizontalAlignment(Element.ALIGN_RIGHT);
            Paragraph cFirmaAut= new Paragraph("__________________________________\n"
                    + "GILMAR ISRAEL CUEVA ALVARADO\n"
                    + "FIRMA AUTORIZADA", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celFirmaAut = new PdfPCell(cFirmaAut);
            celFirmaAut.setHorizontalAlignment(Element.ALIGN_CENTER);
            celFirmaAut.setBorder(0);
            tablaFirmas.addCell(celFirmaAut);
            
            Paragraph cFirmaCli= new Paragraph("___________________________________\n"
                    + pedido.getCliente().getApe_per()+" "+pedido.getCliente().getNom_per(), new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK));
            PdfPCell celFirmaCli = new PdfPCell(cFirmaCli);
            celFirmaCli.setHorizontalAlignment(Element.ALIGN_CENTER);
            celFirmaCli.setBorder(0);
            tablaFirmas.addCell(celFirmaCli);
            
            
            documento.add(logo);
            documento.add(titulo);
            
            tablaEncabezado.addCell(celPublicidad);
            tablaEncabezado.addCell(celInformacion);
//            tabla.addCell(seccion1);
            documento.add(new Paragraph(" "));
            documento.add(tablaEncabezado);
            documento.add(direccionEmpresa);
            documento.add(new Paragraph("---------------------------------------"
                    + "------------------------------------------------"
                    + "------------------------------------------------"
                    + "---------------------------", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK)));
            //documento.add(new Paragraph(" "));
            documento.add(tabla2);
            documento.add(new Paragraph("---------------------------------------"
                    + "------------------------------------------------"
                    + "-------------------------------------------------------------"
                    + "--------------", new Font(Font.FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.BLACK)));
            documento.add(detalelPedido);
            documento.add(sinValidez);
            documento.add(tablaDetalle);
            documento.add(tablaTotales);
            documento.add(new Paragraph(" "));
            documento.add(tablaFirmas);
                        
            documento.close();
            File archivo = new File("ReportePedido.pdf");
            Utilidades.llamarArchivo(archivo.getPath());

        } catch (Exception e) {
        }
    }

}
