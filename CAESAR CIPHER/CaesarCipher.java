package cipher;

public class CaesarCipher {
	     private String upperCaseAlphabet;
	     private String lowerCaseAlphabet;
	     private String upperCaseShiftedAlphabet;
	     private String lowerCaseShiftedalphabet;
	     private int encryptionKey;
	     
	     public CaesarCipher(int key){
	         upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	         lowerCaseAlphabet = upperCaseAlphabet.toLowerCase();
	         upperCaseShiftedAlphabet = upperCaseAlphabet.substring(key) + upperCaseAlphabet.substring(0 , key);
	         lowerCaseShiftedalphabet = lowerCaseAlphabet.substring(key) + lowerCaseAlphabet.substring(0 , key);
	         encryptionKey = key;
	     }
	     
	     public String encrypt(String plainText){
	         StringBuilder encryptedText  = new StringBuilder(plainText);
	         for(int i=0; i< encryptedText.length() ; i++){
	         Character currChar = encryptedText.charAt(i);
	         if(lowerCaseAlphabet.contains(currChar.toString())){
	             int index = lowerCaseAlphabet.indexOf(currChar);
	                if(index != -1){
	                    char newChar = lowerCaseShiftedalphabet.charAt(index);
	                    encryptedText.setCharAt(i , newChar);
	                }
	            }else{
	                int index = upperCaseAlphabet.indexOf(currChar);
	                if(index != -1){
	                    char newChar = upperCaseShiftedAlphabet.charAt(index);
	                    encryptedText.setCharAt(i , newChar);
	                }
	            }
	        }
	        return encryptedText.toString() ;
	     }
	     
	     public String decrypt(String input) {
	       CaesarCipher cc = new CaesarCipher(26 - encryptionKey);
	       String message = cc.encrypt(input);
	       return message;
	    }
	}


