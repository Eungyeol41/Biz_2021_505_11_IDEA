package com.callor.student.service;

import com.callor.student.model.StudentVO;
import com.callor.student.repository.StDaoImpl;
import com.callor.student.repository.StDao;

import java.util.Collections;
import java.util.List;

/**
 * StDao type 객체를 생성하고 인스턴스가 만들어지는 순간
 * StDao, StDaoImpl, StService는 상당히 끈끈한 관계가 이루어진다 (결합이 발생했다)
 * <p>
 * StDaoImpl 클래스의 변화(변경, 업데이트)가 발생하면 StService에게 영향이 미치게 된다
 * <p>
 * 아래의 StDao 객체는 StService와의 결합도를 고민해야 한다
 * 1번 코드는 StDaoImpl 클래스로 선언하고 클래스로 직접 객체를 생성했다
 * 2번 코드는 StDao interface로 선언하고 클래스로 간접 객체를 생성했다
 * <p>
 * 이 코드에서 1번 코드는 2번 코드보다 결합도가 더 높다
 * <p>
 * Sub로 작성된 클래스 모듈은 반드시 interface를 생성하여 결합도를 낮추는 작업이 필요
 */
public class StService1 {

    // StDaoImpl에 있는 코드가 변경이 되면 stDao의 코드도 변경이 되어야만 사용이 가능

    // 생성자를 만들 때는 Impl을 이용하여 생성자 호출하기
    // interface로 선언하고 상속받은 class로 초기화(생성)하기
    // StDaoImpl 클래스를 사용하여 StDao(type)의 stDao 객체 생성
    // 클래스의 생성자를 호출하여 객체를 생성하면 이 객체는 StDao형 인스턴스가 된다
    private StDaoImpl stDao1 = new StDaoImpl(); // 1번 코드
    private StDao stDao2 = new StDaoImpl(); // 2번 코드

    public List<StudentVO> selectAll() {
        List<StudentVO> stList1 = stDao1.selectAll();
        stList1 = stDao1.findAll();

        List<StudentVO> stList2 = stDao2.selectAll();
        // stList2 = stDao2.findAll();

        // stList에 담긴 데이터들을 shuffle
        Collections.shuffle(stList2);

        return stList2;
    }

}
