package seehope.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class RES {

	public static void main(String[] args) throws IOException {
		System.out.print("请输入Key:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String key = reader.readLine();

		String mode = "";
		for (;;) {
			System.out.print("请输入加密还是解密（1表示加密 2表示解密）:");
			reader = new BufferedReader(new InputStreamReader(System.in));
			mode = reader.readLine();
			if (!("1".equals(mode) || "2".equals(mode))) {
				System.out.println("出错：加密模式必须是1或者2");
			} else {
				break;
			}

		}

		System.out.print("请输入加密和解密的字符串：");
		reader = new BufferedReader(new InputStreamReader(System.in));
		String data = reader.readLine();

		if ("1".equals(mode)) {
			System.out.println("明文：" + data);
			System.out.println("密文：" + encryptBaseDes(key, data));
		} else {
			System.out.println("密文：" + data);
			System.out.println("明文：" + decryptBaseDes(key, data));
		}

		reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		System.exit(0);
	}

	public static String encryptBaseDes(String key, String data) {
		String encryptedData = null;
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128, new SecureRandom(key.getBytes("UTF-8")));
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] encodeFormat = secretKey.getEncoded();
			SecretKeySpec securKeySpec = new SecretKeySpec(encodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, securKeySpec);
			encryptedData = Base64.encodeBytes(cipher.doFinal(data.getBytes("UTF-8")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedData;
	}

	public static String decryptBaseDes(String key, String data) {
		String encryptedData = null;
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128, new SecureRandom(key.getBytes("UTF-8")));
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] encodeFormat = secretKey.getEncoded();
			SecretKeySpec securKeySpec = new SecretKeySpec(encodeFormat, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, securKeySpec);
			encryptedData = new String(cipher.doFinal(Base64.decode(data)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encryptedData;
	}
}
