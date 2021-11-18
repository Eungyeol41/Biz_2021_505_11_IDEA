package com.callor.jc.repository;

import com.callor.jc.models.BookVO;
import com.callor.jc.repository.sql.BookSQL;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookDao {

    @Select("SELECT * FROM tbl_members")
    public List<BookVO> selectAll();

    // 2개 다 가능 -- mybatis에서는 Provider를 사용하는 방법을 더 사용하라고 권장
    // @Insert(BookSQL.book_insert_sql)
    @InsertProvider(type = BookSQL.class, method = "book_insert")
    public int insert(BookVO bookVO);

    /**
     * @Update: 문자열로 만든 SQL을 실행할 때
     *
     * @UpdateProvider: SQL 클래스로 만든 SQL을 실행할 때
     */
    // BookSQL이라는 클래스에 있는 book_update_sql method가 return한 코드를 사용하여 update하라
    @UpdateProvider(type = BookSQL.class, method = "book_upate_sql")
    public int update(BookVO bookVO);

    @Delete("DELETE FROM tbl_members WHERE username= #{isbn}")
    public int delete(String isbn);

}
