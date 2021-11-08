package com.callor.student.service.impl;

import com.callor.student.models.StudentVO;
import com.callor.student.repository.StudentDao;
import com.callor.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("stServiceV1")
public class StudentServiceImplV1 implements StudentService {

    /**
     * 생성자 주입으로 StudentDao Wiring하기
     * 메모리 누수 방지
     * 혹시나 발생할 수 있는 NullPointException 방지할 수 있다.
     */
    private final StudentDao stDao;
    public StudentServiceImplV1(StudentDao stDao) {
        this.stDao = stDao;
    }

    @Override
    public List<StudentVO> selectAll() {
        return null;
    }

    @Override
    public StudentVO findById(String st_num) {
        /**
         * findById는 Optional type으로 데이터가 추출되므로
         * getter method를 한 번 통과해주어야 한다.
         */
        return stDao.findById(st_num).get();
    }

    /**
     * 학생정보를 추가(새로 등록)할 때 학번을 자동으로 생성하여 학생 model 객체를 생성한 후
     * Controller에서 write.jsp로 보내기
     *
     * @return
     */
    @Override
    public StudentVO insert() {

        StudentVO stVO = StudentVO.builder()
                .st_num("20210001")
                .build();
        return stVO;
    }

    @Override
    public void insert(StudentVO stVO) {
        stDao.save(stVO);
    }

    @Override
    public void update(StudentVO stVO) {
        stDao.save(stVO);
    }

    @Override
    public void delete(String st_num) {
        stDao.deleteById(st_num);
    }
}
