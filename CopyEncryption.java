package Strategy;

public class CopyEncryption implements EncryptionStrategy{

	@Override
	public String encrypt(String encryptText) {
		return encryptText;
	}

	@Override
	public String decrypt(String decryptText) {
		return decryptText;
	}

}
