package com.callor.jc.models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NaverRestLayout {
    private String rss; // 디버그를 쉽게 하고 RSS 리더기만으로 이용할 수 있게 하기 위해 만든 RSS 포맷의 컨테이너
    private String channel; // 검색 결과를 포함하는 컨테이너
    private String lastBuildDate; // 검색 결과를 생성한 시간
    private String total; // 검색 결과 문서의 총 개수
    private String start; // 검색 결과 문서 중, 문서의 시작점
    private String display; // 검색된 검색 결과의 개수
    private List<BookVO> items; // JSON 포멧, 개별 검색 결과
}
