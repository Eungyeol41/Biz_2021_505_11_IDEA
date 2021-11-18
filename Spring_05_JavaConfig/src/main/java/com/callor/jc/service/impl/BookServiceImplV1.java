package com.callor.jc.service.impl;

import com.callor.jc.repository.CreateTableSQL;
import com.callor.jc.repository.DDL_Dao;
import org.springframework.stereotype.Service;

@Service("bookServiceV1")
public class BookServiceImplV1 {

    public final DDL_Dao ddlDao;
    public BookServiceImplV1(DDL_Dao ddlDao) {
        this.ddlDao = ddlDao;

        ddlDao.create_table(CreateTableSQL.create_book_table);
    }


}
