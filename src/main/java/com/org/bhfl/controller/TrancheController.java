/**
 * 
 */
package com.org.bhfl.controller;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.org.bhfl.entity.CreateTokenRequest;
import com.org.bhfl.entity.EncryptedTrancheResponse;
import com.org.bhfl.entity.TrancheResponse;

/**
 * 
 */
//@Slf4j
@RestController
public class TrancheController {

	@Autowired
	RestTemplate restTemplate;

//	@PostMapping("/check")
//	public void check(@RequestBody CreateTokenRequest createTokenRequest) throws Exception {
//		Gson gson = new Gson();
////		log.debug("Inside check :: " + gson.toJson(createTokenRequest));
//		gson = new GsonBuilder().disableHtmlEscaping().create();
//		EncryptedTrancheResponse encryptedTrancheResponse = new EncryptedTrancheResponse();
//		TrancheResponse trancheResponse = new TrancheResponse();
//		trancheResponse.setBuilderUserId(encrypt(createTokenRequest.getBuilderUserId()));
//		trancheResponse.setFinReference(encrypt(createTokenRequest.getFinReference()));
//		trancheResponse.setSource(createTokenRequest.getSource());
//		encryptedTrancheResponse.setAuthorization(encrypt(gson.toJson(trancheResponse)));
//		encryptedTrancheResponse.setTrancheResponse(trancheResponse);
//		String url = "https://customer-n2p.bajajhousingfinance.in/pdp-api/tranche/createToken";
//		String reqJson = gson.toJson(encryptedTrancheResponse.getTrancheResponse());
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.add("Authorization", encryptedTrancheResponse.getAuthorization());
//		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
//		HttpEntity<String> request = new HttpEntity<>(gson.toJson(encryptedTrancheResponse.getTrancheResponse()),
//				httpHeaders);
////		log.debug("request " + request);
//		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
//		System.out.println(response.getBody());
//	}

	public String encrypt(String plaintext) throws Exception {
		String KEY = "NrRu0XAvrWeFb1SihOt5Hw==";
		String IV = "kCGfkUpppOIICR1o+sM/Cw==";
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		SecretKey secret = new SecretKeySpec(Base64.decodeBase64(KEY), "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(Base64.decodeBase64(IV));
		String byteContent = Hex.encodeHexString(plaintext.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secret, ivSpec);
		byte[] encrypted = cipher.doFinal(byteContent.getBytes());
		byte[] encodedText = Base64.encodeBase64(encrypted);
		return new String(encodedText).replace('/', ':');
	}
}
