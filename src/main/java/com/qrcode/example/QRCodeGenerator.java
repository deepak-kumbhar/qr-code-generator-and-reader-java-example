package com.qrcode.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {

	// Will be created in your project work dir.
	private static final String QR_CODE_IMAGE_PATH = "./qrCode.png";

	/**
	 * Generate QR code method.
	 * 
	 * @author Mindbowser | deepak.kumbhar@mindbowser.com
	 * @param text
	 * @param width
	 * @param height
	 * @param filePath
	 * @throws WriterException
	 * @throws IOException
	 */
	private static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	/**
	 * Main method to test.
	 * 
	 * @author Mindbowser | deepak.kumbhar@mindbowser.com
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			generateQRCodeImage("This will be QR code text", 350, 350, QR_CODE_IMAGE_PATH);
			System.out.println("QR code generated..");
		} catch (WriterException e) {
			System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
		}
	}
}
