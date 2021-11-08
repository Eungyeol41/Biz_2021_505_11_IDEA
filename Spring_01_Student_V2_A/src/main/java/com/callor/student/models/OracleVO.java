package com.callor.student.models;

import javax.persistence.*;

public class OracleVO {

    /**
     * SEQ_ORACLE이라는 이름으로 Sequence를 만들고 1씩 증가
     * 이 프로젝트에서 O_SEQ라는 별명으로 사용하겠다.
     */
    // Oracle일 경우 SEQ_ORACLE이라는 이름으로 시퀀스를 만들고 별명을 O_SEQ라는 이름으로 만든다.
    @SequenceGenerator(name = "O_SEQ", sequenceName = "SEQ_ORACLE", allocationSize = 1)

    /**
     * O_SEQ라는 별명으로 생성된 Sequence를 사용하여 INSERT 시 o_seq 칼럼에 데이터를 생성하라
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "O_SEQ")
    @Id
    private Long o_seq;

}
