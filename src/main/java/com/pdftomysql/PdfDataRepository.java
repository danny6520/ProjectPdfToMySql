package com.pdftomysql;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfDataRepository extends JpaRepository<PdfData, Long> {
}

