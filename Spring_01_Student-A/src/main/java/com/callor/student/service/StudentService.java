package com.callor.student.service;

import com.callor.student.model.StudentVO;

import java.util.List;

public interface StudentService {
    public List<StudentVO> selectAll();
    public StudentVO findByNum(String st_num);

    public List<StudentVO> findByName(String st_name);
    public List<StudentVO> findByTel(String st_tel);

    public List<StudentVO> findByDept(String st_dept);
    public List<StudentVO> findByGrade(String st_grade);

    // 학생데이터 추가할 때 새로운 학번을 생성하여 StudentVO 객체를 만드는 method
    public StudentVO insert();
    // DB에 추가하는 method
    public void insert(StudentVO vo);

    public void update(StudentVO vo);
    public void delete(String st_num);
}
