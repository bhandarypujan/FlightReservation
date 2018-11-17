package com.example.demo.util;

import com.example.demo.entities.Reservation;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.annotation.Documented;
import java.text.ParseException;

@Component
public class PdfGenerator {

    public void generateItinerary(Reservation reservation,String filePth){

        Document document = new Document();
        try {
            PdfWriter.getInstance(document,new FileOutputStream(filePth));
            document.open();
            document.add(generateTable(reservation));
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private PdfPTable generateTable(Reservation reservation) {
        PdfPTable table = new PdfPTable(2);

        PdfPCell cell;

        cell= new PdfPCell(new Phrase("Flight Itinerary"));
        cell.setColspan(2);
        table.addCell(cell);

        cell= new PdfPCell(new Phrase("Flight Details:"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("Operating Airlines");
        table.addCell(reservation.getFlight().getOperatingAirlines());

        table.addCell("Departure City");
        table.addCell(reservation.getFlight().getDepartureCity());

        table.addCell("Arrival City");
        table.addCell(reservation.getFlight().getArrivalCity());

        table.addCell("Flight NUmber");
        table.addCell(String.valueOf(reservation.getFlight().getFlightNumber()));

        table.addCell("Date of Departure");
        table.addCell(String.valueOf(reservation.getFlight().getDateOfDeparture()));

        table.addCell("Time of Departure");
        try {
            table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cell = new PdfPCell(new Phrase("Passenger Details"));
        cell.setColspan(2);
        table.addCell(cell);

        table.addCell("First Name");
        table.addCell(reservation.getPassenger().getFirst_Name());

        table.addCell("Last Name");
        table.addCell(reservation.getPassenger().getLast_Name());

        table.addCell("Email");
        table.addCell(reservation.getPassenger().getEmail());

        table.addCell("Phone");
        table.addCell(reservation.getPassenger().getPhone());

        table.addCell("Reservation Id");
        table.addCell(String.valueOf(reservation.getID()));
        return table;

    }

}
