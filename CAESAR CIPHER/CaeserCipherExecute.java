package cipher;

import java.util.Scanner;

public class CaeserCipherExecute {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("select any of the following options\n1. ENCRYPTION CC\n2. ENHANCED ENCRYPTION CC\n3. DECRYPT CC\n4. DECRYPTION ENHANCED CC");
		int option = sc.nextInt();
		
		switch(option) {
		case 1:
			System.out.println("enter key");
			int key = sc.nextInt();
			key %= 26;
			CaesarCipher cc = new CaesarCipher(key);
			sc.nextLine();
			System.out.println("enter message to encrypt");
			String plainText = sc.nextLine();
			String encrypted = cc.encrypt(plainText);
			System.out.println("The encryption result is "+ encrypted);
			break;
		case 3:
			System.out.println("enter key");
			int key1 = sc.nextInt();
			key1 %= 26;
			CaesarCipher cc1 = new CaesarCipher(key1);
			sc.nextLine();
			System.out.println("enter message to decrypt");
			String encryptedText = sc.nextLine();
			String decrypted = cc1.decrypt(encryptedText);
			System.out.println("The decryption outcome is "+ decrypted);
			break;
		case 2:
			System.out.println("enter message to encrypt");
			sc.nextLine();
			String plainText1 = sc.nextLine();
			System.out.println("enter first key");
			int key21 = sc.nextInt();
			key21 %= 26;
			System.out.println("enter second key");
			int key22 = sc.nextInt();
			key22 %= 26;
			EnhancedCaeserCipher ecc = new EnhancedCaeserCipher(key21 , key22);
			String encryptedText2 = ecc.encrypt(plainText1);
		    System.out.println("The encryption result is "+ encryptedText2);
		    break;
		case 4:
			System.out.println("enter message to decrypt");
			sc.nextLine();
			String encryptedText1 = sc.nextLine();
			System.out.println("enter first key");
			int keyD21 = sc.nextInt();
			keyD21 %= 26;
			System.out.println("enter second key");
			int keyD22 = sc.nextInt();
			keyD22 %= 26;
			EnhancedCaeserCipher ecc2 = new EnhancedCaeserCipher(keyD21 , keyD22);
			String decryptedText = ecc2.decrypt(encryptedText1);
			System.out.println("The decryption outcome is "+ decryptedText);
			break;
		default: 
			System.out.println("error !! select correct option");
		}
		
	}
}
