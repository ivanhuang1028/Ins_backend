package com.hl.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JwtHelper {

	public static Claims parseJWT(String jsonWebToken, String base64Security) {
		try {
			Claims claims = Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
					.parseClaimsJws(jsonWebToken).getBody();
			return claims;
		} catch (Exception ex) {
			return null;
		}
	}

	/**
	 *
	 * @return
	 */
	public static String createJWT(String user_name,  String user_id,
			String audience, String issuer, int  expDates, String base64Security) {
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// 生成签名密钥
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// 添加构成JWT的参数
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
											.claim("user_name", user_name)
											.claim("user_id", user_id)
											.setIssuer(issuer)
											.setAudience(audience)
											.signWith(signatureAlgorithm, signingKey);
		// 添加Token过期时间，设置为当前日期之后3日的凌晨2点
		if (expDates >= 0) {
			Date currdate = DateUtil.parseDate(DateUtil.formatDate(now), "yyyy-MM-dd");
			Calendar ca = Calendar.getInstance();
			ca.setTime(currdate);
			ca.add(Calendar.DATE, expDates);
			Date expTmp = ca.getTime();

			String expTmpStr = DateUtil.formatDate(expTmp);
			Date exp = DateUtil.parseDate(expTmpStr + " 02:00:00", "yyyy-MM-dd HH:mm:ss");

			builder.setExpiration(exp).setNotBefore(now);
		}

		// 生成JWT
		return builder.compact();
	}

	public static void main(String[] args) {
//		String str=JwtHelper.createJWT("Weijun Lin","林伟军","fc11d5718fec4022ad578644606a0d55","","",System.currentTimeMillis(),"L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg==");
//	    System.out.println(JwtHelper.createJWT("Tiger Chen","陈达文","5f3a7fabc99e4ed98d80cc6f1ef84045","","",System.currentTimeMillis(),"L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg=="));
//		System.out.println(JwtHelper.createJWT("Ivan Huang","黄锦坚","27bf764f92f2486894cab6acd73772c6","","",System.currentTimeMillis(),"L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg=="));
		System.out.println(JwtHelper.createJWT("小黄", "c9c4756847584a999cfc91b8e2a78c89", "", "",7,"L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg=="));
//		String str=JwtHelper.createJWT("Christy Deng","邓婷婷","0af5a141f783439c9e49d62efacb4476","","",System.currentTimeMillis(),"L7A/6zARSkK1j7Vd5SDD9pSSqZlqF7mAhiOgRbgv9Smce6tf4cJnvKOjtKPxNNnWQj+2lQEScm3XIUjhW+YVZg==");
//		System.out.println("Christy Deng:"+str);
	}
}
