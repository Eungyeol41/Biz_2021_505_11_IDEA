package com.callor.readbook.persistence;

import com.callor.readbook.models.BookVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<BookVO, String> {
}
