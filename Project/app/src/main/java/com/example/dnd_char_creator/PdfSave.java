package com.example.dnd_char_creator;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class PdfSave {
    private int EXTERNAL_STORAGE_PERMISSION_CODE = 23;
    private Activity context;
    private int fontSize = 20;
    public PdfSave(Activity context){
        this.context = context;
    }

    public void createPdf(int portraitId, String name, String charclass, String race,  String charbackground, int health,
                          int armourClass, int speed, String[] equipment, int str, int con, int dex, int inte, int wis, int cha) throws FileNotFoundException {
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_PERMISSION_CODE);
        }
        if(portraitId == 0){
            portraitId = R.drawable.defaultportrait;
        }
        if(name == null){
            name = "No name inputed";
        }
        if(charclass == null){
            charclass = "No class chosen";
        }
        if(race == null){
            race = "No race chosen";
        }
        if(charbackground == null){
            charbackground = "No background chosen";
        }


        String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        File file = new File(pdfPath, "character_sheet.pdf");
        OutputStream outputStream = new FileOutputStream(file);

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdfDocument = new PdfDocument(writer);
        Document document = new Document(pdfDocument);
        document.setFontSize(fontSize);

        //Background

        document.setMargins(0,0,0,0);
        Drawable background = context.getDrawable(R.drawable.parchmentbackground);
        Bitmap bitmap = ((BitmapDrawable)background).getBitmap();
        ByteArrayOutputStream streamBackground = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100,streamBackground);
        byte[] bitmapDataBackground = streamBackground.toByteArray();

        ImageData imageDataBackground = ImageDataFactory.create(bitmapDataBackground);
        Image imageBackground = new Image(imageDataBackground);

        //Total width is 600f. Top is 850. Approximately 28.5 cm/f.

        //Heart image
        Drawable heart = context.getDrawable(R.drawable.heart);
        Bitmap bitmapHeart = ((BitmapDrawable)heart).getBitmap();
        ByteArrayOutputStream streamHeart = new ByteArrayOutputStream();
        bitmapHeart.compress(Bitmap.CompressFormat.PNG, 100,streamHeart);
        byte[] bitmapDataHeart = streamHeart.toByteArray();

        ImageData imageDataHeart = ImageDataFactory.create(bitmapDataHeart);
        Image imageHeart = new Image(imageDataHeart);
        imageHeart.setHeight(46);
        imageHeart.setWidth(55);
        imageHeart.setFixedPosition(67, 488);

        //Armor class image
        Drawable ac = context.getDrawable(R.drawable.armorclasspng);
        Bitmap bitmapAc = ((BitmapDrawable)ac).getBitmap();
        ByteArrayOutputStream streamAc = new ByteArrayOutputStream();
        bitmapAc.compress(Bitmap.CompressFormat.PNG, 100,streamAc);
        byte[] bitmapDataAc = streamAc.toByteArray();

        ImageData imageDataAc = ImageDataFactory.create(bitmapDataAc);
        Image imageAc = new Image(imageDataAc);
        imageAc.setHeight(49);
        imageAc.setWidth(56);
        imageAc.setFixedPosition(250, 486);

        //Speed image
        Drawable speedD = context.getDrawable(R.drawable.speed);
        Bitmap bitmapS = ((BitmapDrawable)speedD).getBitmap();
        ByteArrayOutputStream streamS = new ByteArrayOutputStream();
        bitmapS.compress(Bitmap.CompressFormat.PNG, 100,streamS);
        byte[] bitmapDataS = streamS.toByteArray();

        ImageData imageDataS = ImageDataFactory.create(bitmapDataS);
        Image imageS = new Image(imageDataS);
        imageS.setHeight(54);
        imageS.setWidth(54);
        imageS.setFixedPosition(425, 485);

        //Portrait
        Drawable portraitD = context.getDrawable(portraitId); //This changes depending o chosen portrait
        Bitmap bitmapP = ((BitmapDrawable)portraitD).getBitmap();
        ByteArrayOutputStream streamP = new ByteArrayOutputStream();
        bitmapP.compress(Bitmap.CompressFormat.JPEG, 100,streamP);
        byte[] bitmapDataP = streamP.toByteArray();

        ImageData imageDataP = ImageDataFactory.create(bitmapDataP);
        Image imageP = new Image(imageDataP);
        imageP.setHeight(224);
        imageP.setWidth(220);
        imageP.setFixedPosition(42, 576);

        document.add(imageBackground.setFixedPosition(0,0));
        document.add(imageHeart);
        document.add(imageAc);
        document.add(imageS);
        document.add(imageP);

        //Top paragraphs
        Paragraph paragraphName = new Paragraph(name);
        paragraphName.setTextAlignment(TextAlignment.LEFT);
        paragraphName.setFixedPosition(280, 755, 302);

        Paragraph paragraphClassRace = new Paragraph(race + " " + charclass);
        paragraphClassRace.setTextAlignment(TextAlignment.LEFT);
        paragraphClassRace.setFixedPosition(280, 692, 302);

        Paragraph paragraphBackground = new Paragraph(charbackground + " background");
        paragraphBackground.setTextAlignment(TextAlignment.LEFT);
        paragraphBackground.setFixedPosition(280, 619, 302);

        document.add(paragraphName);
        document.add(paragraphClassRace);
        document.add(paragraphBackground);

        //Heart, AC and Speed texts
        Paragraph paragraphHealth = new Paragraph(Integer.toString(health));
        paragraphHealth.setTextAlignment(TextAlignment.LEFT);
        paragraphHealth.setFixedPosition(134, 488, 46);

        Paragraph paragraphAC = new Paragraph(Integer.toString(armourClass));
        paragraphAC.setTextAlignment(TextAlignment.LEFT);
        paragraphAC.setFixedPosition(319, 488, 46);

        Paragraph paragraphSpeed = new Paragraph(Integer.toString(speed));
        paragraphSpeed.setTextAlignment(TextAlignment.LEFT);
        paragraphSpeed.setFixedPosition(492, 488, 46);

        document.add(paragraphHealth);
        document.add(paragraphAC);
        document.add(paragraphSpeed);

        //Equipment list
        Paragraph paragraphEquip = new Paragraph("Equipment: ");
        paragraphEquip.setTextAlignment(TextAlignment.LEFT);
        paragraphEquip.setFixedPosition(92, 400, 105);

        List listEquips = new List();
        for (String s:equipment) {
            listEquips.add(s);
        }
        listEquips.setFixedPosition(225,(400 - equipment.length*fontSize),405);
        //listEquips.setHeight(67);
        listEquips.setVerticalAlignment(VerticalAlignment.BOTTOM);
        document.add(paragraphEquip);
        document.add(listEquips);

         /*float columnWidth[] = {200f,20f};
        Table table = new Table(columnWidth);
        table.addCell("Strength");
        table.addCell("15");
        table.addCell("Constitution");
        table.addCell("12");

        document.add(table);*/

        //Table with attributes
        float columnWidth[] = {113, 40, 113, 40};
        Table tableAttr = new Table(columnWidth);
        tableAttr.addCell("Strength");
        tableAttr.addCell(Integer.toString(str));
        tableAttr.addCell("Intelligence");
        tableAttr.addCell(Integer.toString(inte));
        tableAttr.addCell("Constitution");
        tableAttr.addCell(Integer.toString(con));
        tableAttr.addCell("Wisdom");
        tableAttr.addCell(Integer.toString(wis));
        tableAttr.addCell("Dexterity");
        tableAttr.addCell(Integer.toString(dex));
        tableAttr.addCell("Charisma");
        tableAttr.addCell(Integer.toString(cha));

        tableAttr.setFixedPosition(92, 186, 392);
        document.add(tableAttr);


        document.close();
        Toast.makeText(context, "Pdf Created", Toast.LENGTH_LONG).show();
    }
}
