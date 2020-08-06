package com.naver.org.login;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;

@Component
public class NaverLoginBO {
	private final static String CLIENT_ID = "m1Ad4mMB2hCJz1RgLcWN";
	private final static String CLIENT_SECRET = "HEr_gg4bfa";
	private final static String REDIRECT_URI = "http://localhost:10030/naver/login/callback";
	private final static String SESSION_STATE = "oauth_state";
	/* �봽濡쒗븘 議고쉶 API URL */
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

	/* �꽕�븘濡� �씤利� URL �깮�꽦 Method */
	public String getAuthorizationUrl(HttpSession session) {

		/* �꽭�뀡 �쑀�슚�꽦 寃�利앹쓣 �쐞�븯�뿬 �궃�닔瑜� �깮�꽦 */
		String state = generateRandomString();
		/* �깮�꽦�븳 �궃�닔 媛믪쓣 session�뿉 ���옣 */
		setSession(session, state);

		/* Scribe�뿉�꽌 �젣怨듯븯�뒗 �씤利� URL �깮�꽦 湲곕뒫�쓣 �씠�슜�븯�뿬 �꽕�븘濡� �씤利� URL �깮�꽦 */
		OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET).callback(REDIRECT_URI).state(state).build(NaverLoginApi.instance());

		return oauthService.getAuthorizationUrl();
	}

	/* �꽕�븘濡� Callback 泥섎━ 諛� AccessToken �쉷�뱷 Method */
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {

		/* Callback�쑝濡� �쟾�떖諛쏆� �꽭�꽑寃�利앹슜 �궃�닔媛믨낵 �꽭�뀡�뿉 ���옣�릺�뼱�엳�뒗 媛믪씠 �씪移섑븯�뒗吏� �솗�씤 */
		String sessionState = getSession(session);
		if (StringUtils.equals(sessionState, state)) {

			OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET).callback(REDIRECT_URI).state(state).build(NaverLoginApi.instance());

			/* Scribe�뿉�꽌 �젣怨듯븯�뒗 AccessToken �쉷�뱷 湲곕뒫�쑝濡� �꽕�븘濡� Access Token�쓣 �쉷�뱷 */
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
			return accessToken;
		}
		return null;
	}

	/* �꽭�뀡 �쑀�슚�꽦 寃�利앹쓣 �쐞�븳 �궃�닔 �깮�꽦湲� */
	private String generateRandomString() {
		return UUID.randomUUID().toString();
	}

	/* http session�뿉 �뜲�씠�꽣 ���옣 */
	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}

	/* http session�뿉�꽌 �뜲�씠�꽣 媛��졇�삤湲� */
	private String getSession(HttpSession session) {
		return (String) session.getAttribute(SESSION_STATE);
	}

	/* Access Token�쓣 �씠�슜�븯�뿬 �꽕�씠踰� �궗�슜�옄 �봽濡쒗븘 API瑜� �샇異� */
	public String getUserProfile(OAuth2AccessToken oauthToken) throws IOException {

		OAuth20Service oauthService = new ServiceBuilder().apiKey(CLIENT_ID).apiSecret(CLIENT_SECRET).callback(REDIRECT_URI).build(NaverLoginApi.instance());

		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
		oauthService.signRequest(oauthToken, request);
		Response response = request.send();
		return response.getBody();
	}
}
