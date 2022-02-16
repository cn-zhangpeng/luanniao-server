package com.zp95sky.luanniao.auth.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.RequiredTypeException;
import io.jsonwebtoken.impl.JwtMap;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户认证签名
 * @author 山海紫穹
 * @date 2021年06月25日 12:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserAuthClaims extends JwtMap implements Claims {

	public static final String MOBILE_KEY = "userId";
	public static final String ROLE_ID_KEY = "username";

	private Long userId;
	private String username;

	@Override
	public String getIssuer() {
		return getString(ISSUER);
	}

	@Override
	public Claims setIssuer(String iss) {
		setValue(ISSUER, iss);
		return this;
	}

	@Override
	public String getSubject() {
		return getString(SUBJECT);
	}

	@Override
	public Claims setSubject(String sub) {
		setValue(SUBJECT, sub);
		return this;
	}

	@Override
	public String getAudience() {
		return getString(AUDIENCE);
	}

	@Override
	public Claims setAudience(String aud) {
		setValue(AUDIENCE, aud);
		return this;
	}

	@Override
	public Date getExpiration() {
		return get(Claims.EXPIRATION, Date.class);
	}

	@Override
	public Claims setExpiration(Date exp) {
		setDate(Claims.EXPIRATION, exp);
		return this;
	}

	@Override
	public Date getNotBefore() {
		return get(Claims.NOT_BEFORE, Date.class);
	}

	@Override
	public Claims setNotBefore(Date nbf) {
		setDate(Claims.NOT_BEFORE, nbf);
		return this;
	}

	@Override
	public Date getIssuedAt() {
		return get(Claims.ISSUED_AT, Date.class);
	}

	@Override
	public Claims setIssuedAt(Date iat) {
		setDate(Claims.ISSUED_AT, iat);
		return this;
	}

	@Override
	public String getId() {
		return getString(ID);
	}

	@Override
	public Claims setId(String jti) {
		setValue(Claims.ID, jti);
		return this;
	}

	@Override
	public <T> T get(String claimName, Class<T> requiredType) {
		Object value = get(claimName);
		if (value == null) {
			return null;
		}

		if (Claims.EXPIRATION.equals(claimName)
				|| Claims.ISSUED_AT.equals(claimName)
				|| Claims.NOT_BEFORE.equals(claimName)) {
			value = getDate(claimName);
		}

		if (requiredType == Date.class && value instanceof Long) {
			value = new Date((Long) value);
		}

		if (!requiredType.isInstance(value)) {
			throw new RequiredTypeException("Expected value to be of type: "
					+ requiredType + ", but was " + value.getClass());
		}

		return requiredType.cast(value);
	}

}
