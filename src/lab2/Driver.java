package lab2;

//import java.awt.Graphics2D;
//import java.awt.Image;
//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
//import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStream;
//import java.util.Iterator;

//import javax.imageio.ImageIO;
//import javax.imageio.ImageReadParam;
//import javax.imageio.ImageReader;
//import javax.imageio.stream.ImageInputStream;

import edu.neumont.io.Bits;

public class Driver {

	public static void main(String[] args) throws IOException {
		AVL();
//		Heap();

//		ByteArrayInputStream in = new ByteArrayInputStream(secretMessage);
//		BufferedImage bImageFromConvert = ImageIO.read(in);
//		ImageIO.write(bImageFromConvert, "jpg", new File("image.jpg"));
//		//Bits bits = numberBits();
//		Bits bits = docNumberBits();
//		while(bits.size() > 0) {
//			byte b = tree.toByte(bits);
//			String printOut;
//			if(useNumbers)
//				printOut = "" + b;
//			else
//				printOut = "" + (char)b;
//		
//			System.out.println(printOut);
//		}
//		
//		
//		Bits from = new Bits();
//		byte num = 67;
//		tree.fromByte((byte) 67, from);
//		System.out.print(num + ": ");
//		for(int i = 0; i < from.size(); i++) {
//			System.out.print(from.get(i) + " ");
//		}
		
		
	}
	
	public static void AVL() throws IOException {
		boolean useNumbers = true;
		//byte[] data = "Is this right or wrong?".getBytes();
		//byte[] data = {3, 1, 5, 1, 5, 5, 7, 8, 4, 8 };
		byte[] data = { 5, 7, 3, 6, 4, 2, 1 };
		byte[] message = {1, 5, 8, 4 };
		
		AVLBasedPriorityQueue<Integer> tree = new AVLBasedPriorityQueue<Integer>();
		tree.offer(5);
		tree.offer(7);
		tree.offer(3);
		tree.offer(6);
		tree.offer(4);
		tree.offer(2);
		tree.offer(1);
		tree.preOrder();
		
		System.out.println("\n Value Polled: " + tree.poll());
		tree.preOrder();
		
		System.out.println("\n Value Polled: " + tree.poll());
		tree.preOrder();
		
		System.out.println("\n Value Polled: " + tree.poll());
		tree.preOrder();
		
		System.out.println("\n Value Polled: " + tree.poll());
		tree.preOrder();
		
		System.out.println("\n Value Polled: " + tree.poll());
		tree.preOrder();
		
		
//		AVLHuffmanTree tree = new AVLHuffmanTree(data, useNumbers);
		
//		AVLHuffmanCompressor compDecomp = new AVLHuffmanCompressor();
//		tree.printOut();
//		
//		byte[] compressedData = compDecomp.compress(tree, message);
//		System.out.print("Compressed Data: ");
//		for(int i = 0; i < compressedData.length; i++) {
//			System.out.print(compressedData[i]);
//		}
//		
//		System.out.print("\nDecompressed Data: ");
//		byte[] decompressedData = compDecomp.decompress(tree, message.length, compressedData);
//		for(int i = 0; i < decompressedData.length; i++) {
//			System.out.print(decompressedData[i] + " ");
//		}
		
		
//------Secret Message Stuff		
//		System.out.println("\n");
//		
//		AVLBasedPriorityQueue<FrequencyData> secretData = new AVLBasedPriorityQueue<FrequencyData>();
//		FrequencyData frequencies;
//		int[] secretDataFrequency = { 423, 116, 145, 136, 130, 165, 179, 197, 148, 125, 954, 156, 143, 145, 164, 241, 107, 149, 176, 153, 121, 164, 144, 166, 100, 138, 157, 140, 119, 138, 178, 289, 360, 120, 961, 195, 139, 147, 129, 192, 119, 146, 138, 184, 137, 196, 163, 331, 115, 160, 127, 172, 176, 181, 149, 194, 138, 154, 163, 167, 196, 174, 250, 354, 142, 169, 170, 209, 205, 179, 147, 245, 108, 179, 148, 186, 131, 160, 112, 219, 118, 204, 164, 154, 154, 175, 189, 239, 126, 145, 185, 179, 149, 167, 152, 244, 189, 257, 234, 208, 179, 170, 171, 178, 184, 189, 203, 184, 204, 208, 187, 163, 335, 326, 206, 189, 210, 204, 230, 202, 415, 240, 275, 295, 375, 308, 401, 608, 2099, 495, 374, 160, 130, 331, 107, 181, 117, 133, 476, 129, 137, 106, 107, 237, 184, 143, 122, 143, 1596, 205, 121, 170, 123, 124, 150, 132, 143, 133, 178, 308, 96, 102, 114, 176, 159, 149, 123, 199, 1156, 119, 144, 237, 131, 155, 143, 225, 92, 125, 117, 138, 135, 154, 124, 137, 121, 143, 149, 141, 177, 159, 247, 384, 302, 120, 95, 140, 87, 1460, 155, 199, 111, 198, 147, 182, 91, 148, 119, 233, 445, 1288, 138, 133, 122, 170, 156, 257, 143, 149, 180, 174, 132, 151, 193, 347, 91, 119, 135, 182, 124, 152, 109, 175, 152, 159, 166, 224, 126, 169, 145, 220, 119, 148, 133, 158, 144, 185, 139, 168, 244, 145, 167, 167, 262, 214, 293, 402};
//		int counter = 0;
//		for(byte i = -128; i < 128 && counter < 256; i++) {
//			frequencies = new FrequencyData(i, secretDataFrequency[counter], false);
//			secretData.offer(frequencies);
//			counter += 1;
//			
//		}
//		
//		AVLHuffmanTree secretTree = new AVLHuffmanTree(secretData, false);
//		secretTree.printOut();
//		File file = new File("compressed.huff");
//		FileInputStream fin = new FileInputStream(file);
//		byte[] secretBytes = new byte[(int)file.length()];
//		fin.read(secretBytes);
//		fin.close();
//		byte[] secretMessage = compDecomp.decompress(secretTree, secretBytes.length, secretBytes);
//		for(int i= 0; i < secretMessage.length; i++) {
//			System.out.print(secretMessage[i]);
//		}
//		FileOutputStream image = new FileOutputStream("image.png");
//		image.write(secretMessage);
//		image.close();
//------End of Secret Message Stuff	
	}
	
	public static void Heap() throws IOException {
		boolean useNumbers = true;
		//byte[] data = "Is this right or wrong?".getBytes();
		//byte[] data = {3, 1, 5, 1, 5, 5, 7, 8, 4, 8 };
		byte[] data = { 45, 56, 67, 78, 89, 12, 23, 34, 45, 23, 45, 67, 45 };
		byte[] message = {45, 45, 67 };
		HeapHuffmanTree tree = new HeapHuffmanTree(data, useNumbers);
		HeapHuffmanCompressor compDecomp = new HeapHuffmanCompressor();
		tree.printOut();
		
		byte[] compressedData = compDecomp.compress(tree, message);
		System.out.print("Compressed Data: ");
		for(int i = 0; i < compressedData.length; i++) {
			System.out.print(compressedData[i]);
		}
		
		System.out.print("\nDecompressed Data: ");
		byte[] decompressedData = compDecomp.decompress(tree, message.length, compressedData);
		for(int i = 0; i < decompressedData.length; i++) {
			System.out.print(decompressedData[i] + " ");
		}
		
		
//------Secret Message Stuff		
//		System.out.println("\n");
//		
//		HeapBasedPriorityQueue<FrequencyData> secretData = new HeapBasedPriorityQueue<FrequencyData>();
//		FrequencyData frequencies;
//		int[] secretDataFrequency = { 423, 116, 145, 136, 130, 165, 179, 197, 148, 125, 954, 156, 143, 145, 164, 241, 107, 149, 176, 153, 121, 164, 144, 166, 100, 138, 157, 140, 119, 138, 178, 289, 360, 120, 961, 195, 139, 147, 129, 192, 119, 146, 138, 184, 137, 196, 163, 331, 115, 160, 127, 172, 176, 181, 149, 194, 138, 154, 163, 167, 196, 174, 250, 354, 142, 169, 170, 209, 205, 179, 147, 245, 108, 179, 148, 186, 131, 160, 112, 219, 118, 204, 164, 154, 154, 175, 189, 239, 126, 145, 185, 179, 149, 167, 152, 244, 189, 257, 234, 208, 179, 170, 171, 178, 184, 189, 203, 184, 204, 208, 187, 163, 335, 326, 206, 189, 210, 204, 230, 202, 415, 240, 275, 295, 375, 308, 401, 608, 2099, 495, 374, 160, 130, 331, 107, 181, 117, 133, 476, 129, 137, 106, 107, 237, 184, 143, 122, 143, 1596, 205, 121, 170, 123, 124, 150, 132, 143, 133, 178, 308, 96, 102, 114, 176, 159, 149, 123, 199, 1156, 119, 144, 237, 131, 155, 143, 225, 92, 125, 117, 138, 135, 154, 124, 137, 121, 143, 149, 141, 177, 159, 247, 384, 302, 120, 95, 140, 87, 1460, 155, 199, 111, 198, 147, 182, 91, 148, 119, 233, 445, 1288, 138, 133, 122, 170, 156, 257, 143, 149, 180, 174, 132, 151, 193, 347, 91, 119, 135, 182, 124, 152, 109, 175, 152, 159, 166, 224, 126, 169, 145, 220, 119, 148, 133, 158, 144, 185, 139, 168, 244, 145, 167, 167, 262, 214, 293, 402};
//		int counter = 0;
//		for(byte i = -128; i < 128 && counter < 256; i++) {
//			frequencies = new FrequencyData(i, secretDataFrequency[counter], false);
//			secretData.offer(frequencies);
//			counter += 1;
//			
//		}
//		
//		HeapHuffmanTree secretTree = new HeapHuffmanTree(secretData, false);
//		secretTree.printOut();
//		File file = new File("compressed.huff");
//		FileInputStream fin = new FileInputStream(file);
//		byte[] secretBytes = new byte[(int)file.length()];
//		fin.read(secretBytes);
//		fin.close();
//		byte[] secretMessage = compDecomp.decompress(secretTree, secretBytes.length, secretBytes);
//		for(int i= 0; i < secretMessage.length; i++) {
//			System.out.print(secretMessage[i]);
//		}
//		FileOutputStream image = new FileOutputStream("image.png");
//		image.write(secretMessage);
//		image.close();
//------End of Secret Message Stuff	
	}
	
	public static Bits numberBits() {
		Bits numberBits = new Bits();
		numberBits.add(false);
		numberBits.add(true);
		
		numberBits.add(false);
		numberBits.add(false);
		
		numberBits.add(true);
		numberBits.add(true);
		
		numberBits.add(true);
		numberBits.add(false);
		numberBits.add(false);
		
		numberBits.add(true);
		numberBits.add(false);
		numberBits.add(true);
		numberBits.add(false);
		
		numberBits.add(true);
		numberBits.add(false);
		numberBits.add(true);
		numberBits.add(true);
		
		return numberBits;
	}

	public static Bits docNumberBits() {
		Bits bits = new Bits();
		
		//45
		bits.add(true);
		bits.add(false);
		
		//23
		bits.add(true);
		bits.add(true);
		bits.add(false);
		
		//67
		bits.add(false);
		bits.add(false);
		
		//78
		bits.add(false);
		bits.add(true);
		bits.add(true);
		bits.add(false);
		
		//89
		bits.add(false);
		bits.add(true);
		bits.add(true);
		bits.add(true);
		
		//12
		bits.add(true);
		bits.add(true);
		bits.add(true);
		bits.add(false);
		
		//56
		bits.add(true);
		bits.add(true);
		bits.add(true);
		bits.add(true);
		
		//34
		bits.add(false);
		bits.add(true);
		bits.add(false);
		
		return bits;
	}

}
