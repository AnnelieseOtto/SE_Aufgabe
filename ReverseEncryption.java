package Strategy;

public class ReverseEncryption implements EncryptionStrategy{


	@Override
	public String encrypt(String encryptText) {
		String oldText = encryptText;
		String newText = new StringBuffer(oldText).reverse().toString();
		
		return newText;
	}

	@Override
	public String decrypt(String decryptText) {
		String oldText = decryptText;
		String newText = new StringBuffer(oldText).reverse().toString();
		
		return newText;
	}

}
