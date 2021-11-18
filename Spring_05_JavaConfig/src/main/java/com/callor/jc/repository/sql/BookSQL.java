package com.callor.jc.repository.sql;

import org.apache.ibatis.jdbc.SQL;

public class BookSQL {

    // mybatis mapper에 주입한 SQL 코드는 반드시 final String으로 선언해야 한다.
    public static final String book_insert_sql =
            " INSERT INTO tbl_naver_books( isbn, title, author, publisher ) "+
                    " VALUES( #{isbn}, #{title}, #{author}, #{publisher} ) ";

    public String book_insert() {
        // mybatis 3.5 이상만 가능
        SQL sql = new SQL();

        sql.INSERT_INTO("tbl_naver_books");
        sql.INTO_COLUMNS("isbn").INTO_VALUES("#{isbn}");

        return sql.toString();
    }

    public String book_upate_sql() {
        SQL sql = new SQL();

        sql.UPDATE("tbl_naver_books");
        sql.SET("title = #{title}");
        sql.SET("author = #{author}");
        sql.SET("publisher = #{publisher}");
        sql.WHERE("isbn = #{isbn}");

        return sql.toString();
    }
}
