package com.callor.student.service;

import com.callor.student.models.StudentVO;

import java.util.List;

public interface StudentService extends GenericService<StudentVO, String> {

    public StudentVO insert();

}
