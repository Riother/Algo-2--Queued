package lab2;

import edu.neumont.io.Bits;

public class AVLHuffmanCompressor {
	
	public AVLHuffmanCompressor() {
	}
	

	public byte[] compress(AVLHuffmanTree tree, byte[] bytes) {
		Bits[] bits = new Bits[bytes.length];
		int numOfBits = 0;
		int paddingBits = 0;
		for(int i = 0; i < bytes.length; i++) {
			bits[i] = new Bits();
			tree.fromByte(bytes[i], bits[i]);
			numOfBits += bits[i].size();
		}
		
		if(numOfBits % 8 != 0) {
			paddingBits = ((numOfBits / 8 + 1) * 8) - numOfBits ; 
		}
		System.out.println("uncompressed length: " + numOfBits);
		
		byte[] zeroesAndOnes = new byte[numOfBits + paddingBits];
		int counter = 0;
		for(int i = 0; i < bits.length; i++) {
			for(int j = 0; j < bits[i].size(); j++) {
				if(bits[i].get(j))
					zeroesAndOnes[counter] = 1;
				else
					zeroesAndOnes[counter] = 0;
				
				counter++;
			}
		}
		return zeroesAndOnes;
	}
	
	public byte[] decompress(AVLHuffmanTree tree, int uncompressedLength, byte[] bytes) {
		byte[] data = new byte[uncompressedLength];
		Bits bits = new Bits(); 
		if(bytes[0] != 0 && bytes[0] != 1) {
			for(int i = 0; i < bytes.length; i++) {
				String asString = String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0');
				for(int j = 0; j < asString.length(); j++) {
					if(asString.charAt(j) == '1') {
						bits.add(true);
					}
					else {
						bits.add(false);
					}
				}
			}
		}
		else {
			for(int i = 0; i < bytes.length; i++) {
				if(bytes[i] == 1) {
					bits.add(true);
				}
				else {
				bits.add(false);
				}
			}
		}
		
		for(int i = 0; bits.size() > 0 && i < uncompressedLength; i++) {
			data[i] = tree.toByte(bits);
			//System.out.println(data[i] + "");
		}
		
		return data;
	}
}
