package com.xml;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.impl.code128.Code128Constants;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;


public class BarCode {
  
  public static void main(String[] args) throws IOException {
    
    String barcodeString = "Hello world \nhiiii\nbilla thunder billa";
    Code128Bean barcode128Bean = new Code128Bean();
    
    
    barcode128Bean.setCodeset(Code128Constants.CODESET_ALL);
    final int dpi = 100;

  //Configure the barcode generator
    //adjust barcode width here
  barcode128Bean.setModuleWidth(UnitConv.in2mm(5.0f / dpi)); 
  barcode128Bean.doQuietZone(false);

  //Open output file
  File outputFile = new File("E:/barcode.png");
  OutputStream out = new FileOutputStream(outputFile);
  try 
  {
      BitmapCanvasProvider canvasProvider = new BitmapCanvasProvider(
              out, "image/x-png", dpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);

      barcode128Bean.generateBarcode(canvasProvider,barcodeString);
      System.out.println(barcodeString);

      canvasProvider.finish();
  } 
  finally 
  {
      out.close();
  }
    
  }

}