package cipher;

public class EnhancedCaeserCipher {
	
    private String upperCaseAlphabet ;
    private String lowerCaseAlphabet;
    private String upperCaseShiftedAlphabet1;
    private String lowerCaseShiftedalphabet1;
    private String upperCaseShiftedAlphabet2;
    private String lowerCaseShiftedalphabet2;
    private int encryptionKey1 , encryptionKey2 ;
    
    public EnhancedCaeserCipher(int key1 , int key2) {
    	
    	encryptionKey1 = key1;
    	encryptionKey2 = key2;
    	upperCaseAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    	lowerCaseAlphabet = upperCaseAlphabet.toLowerCase();
    	upperCaseShiftedAlphabet1 = upperCaseAlphabet.substring(key1) + upperCaseAlphabet.substring(0 , key1);
    	lowerCaseShiftedalphabet1 = lowerCaseAlphabet.substring(key1) + lowerCaseAlphabet.substring(0 , key1);
    	upperCaseShiftedAlphabet2 = upperCaseAlphabet.substring(key2) + upperCaseAlphabet.substring(0 , key2);
    	lowerCaseShiftedalphabet2 = lowerCaseAlphabet.substring(key2) + lowerCaseAlphabet.substring(0 , key2);
    }
    
    public String encrypt(String plainText) {
    	StringBuilder str = new StringBuilder(plainText);
    	for(int i=0; i< str.length() ; i++){
            if(i %2 ==0){
                Character currChar = str.charAt(i);
                if(lowerCaseAlphabet.contains(currChar.toString())){
                    int index = lowerCaseAlphabet.indexOf(currChar);
                    if(index != -1){
                        char newChar = lowerCaseShiftedalphabet1.charAt(index);
                        str.setCharAt(i , newChar);
                }
            }else{
                int index = upperCaseAlphabet.indexOf(currChar);
                if(index != -1){
                    char newChar = upperCaseShiftedAlphabet1.charAt(index);
                    str.setCharAt(i , newChar);
                }
            }
            }else{
                Character currChar = str.charAt(i);
                if(lowerCaseAlphabet.contains(currChar.toString())){
                    int index = lowerCaseAlphabet.indexOf(currChar);
                    if(index != -1){
                    char newChar = lowerCaseShiftedalphabet2.charAt(index);
                    str.setCharAt(i , newChar);
                }
            }else{
                int index = upperCaseAlphabet.indexOf(currChar);
                if(index != -1){
                    char newChar = upperCaseShiftedAlphabet2.charAt(index);
                    str.setCharAt(i , newChar);
                }
            }
            }
        }
        return str.toString() ;
    }
    
    public String decrypt(String encrypted)
    {
        
    	EnhancedCaeserCipher cc = new EnhancedCaeserCipher(26 - encryptionKey1,26 - encryptionKey2);
       String decrypted = cc.encrypt(encrypted);
       return decrypted;
       
    }
    
    
}
