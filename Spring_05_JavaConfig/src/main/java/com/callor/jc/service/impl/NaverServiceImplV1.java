package com.callor.jc.service.impl;

import com.callor.jc.models.BookVO;
import com.callor.jc.models.NaverRestLayout;
import com.callor.jc.service.NaverService;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * abstract (추상) 클래스
 * 일반 클래스와 Interface의 기능을 결합한 클래스
 * <p>
 * 인터페이스처럼 구현되지 않은 프로토 타입의 method를 가지면서 일부는 자체적으로 구현된 method도 포함하는 클래스
 * <p>
 * Interface
 * 클래스를 만들기 위한 설계도 역할
 * method의 prototype만 있고 실제 구현된 코드는 없다.
 */
@Slf4j
@PropertySource("classpath:naver.properties")
@Service("naverServiceV1")
public class NaverServiceImplV1 extends NaverService<BookVO> {

    @Value("${naver.client_id}")
    private String naver_client_id;
    @Value("${naver.client_secret}")
    private String naver_client_secret;

    @Autowired
    private StandardPBEStringEncryptor encryptor;

    /*
    public String queryURL(String search) throws UnsupportedEncodingException {
        String searchUTF8 = URLEncoder.encode(search, "UTF-8");
        StringBuilder queryURL = new StringBuilder();

        queryURL.append(NAVER_BOOK_URL);
        queryURL.append(String.format("?query=%s", searchUTF8));

        return queryURL.toString();

    }
    */

    public String getJsonString(String queryString) throws IOException {
        URL url = new URL(queryString);

        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();

        httpConn.setRequestMethod("GET");
        httpConn.setRequestProperty("X-Naver-Client-Id", encryptor.decrypt(naver_client_id));
        httpConn.setRequestProperty("X-Naver-Client-Secret", encryptor.decrypt(naver_client_secret));

        log.debug("X-Naver-Client-Id: {}", encryptor.decrypt(naver_client_id));
        log.debug("X-Naver-Client-Secret: {}", encryptor.decrypt(naver_client_secret));

        InputStreamReader is = null;

        // Naver야 내가 보낸 요청을 어떻게 할래?
        int httpStatusCode = httpConn.getResponseCode();

        if (httpStatusCode == 200) {
            is = new InputStreamReader(httpConn.getInputStream(), "UTF-8");
        } else {
            is = new InputStreamReader(httpConn.getErrorStream(), "UTF-8");
        }

        BufferedReader buffer = new BufferedReader(is);
        StringBuffer stringBuffer = new StringBuffer();

        while (true) {
            String reader = buffer.readLine();
            if (reader == null) break;

            stringBuffer.append(reader);
        }

        return stringBuffer.toString();

    }

    /**
     * RestTemplate를 사용하여 naver 도서정보 가져오기
     */
    @Override
    public List<BookVO> naverList(String queryString) throws URISyntaxException {

        /**
         * VO 클래스를 Wrapping하여 API데이터 가져오기
         */
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<NaverRestLayout> restList = null;

        URI restURI = new URI(queryString);

        HttpHeaders headers = new HttpHeaders();

        headers.set("X-Naver-Client-Id", encryptor.decrypt(naver_client_id));
        headers.set("X-Naver-Client-Secret", encryptor.decrypt(naver_client_secret));
        // 선택사항
        // API에서 XML, JSON 데이터를 한 가지 URL로 요청하는 경우 수신할 데이터 타입을 지정해주는 것.
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // 설정된 header 정보를 Http 프로토콜에 담기
        HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);

        restList = restTemplate.exchange(restURI, HttpMethod.GET, httpEntity, NaverRestLayout.class);

        return restList.getBody().getItems();
    }
}
