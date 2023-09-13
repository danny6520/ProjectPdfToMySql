package com.pdftomysql;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.RowSet;

import org.springframework.jdbc.core.RowMapper;

public class PdfDataRowMapper implements RowMapper<PdfData> {

    public PdfData mapRow(RowSet rowSet) throws Exception {
    	PdfData pdfData = new PdfData();
    	pdfData.setCol1(rowSet.getString(0));
    	pdfData.setCol2(rowSet.getString(1));
    	pdfData.setCol3(rowSet.getString(2));
    	pdfData.setCol4(rowSet.getString(3));
    	pdfData.setCol5(rowSet.getString(4));
    	pdfData.setCol6(rowSet.getString(5));
    	pdfData.setCol7(rowSet.getString(6));
    	pdfData.setCol8(rowSet.getString(7));
    	pdfData.setCol9(rowSet.getString(8));
    	pdfData.setCol10(rowSet.getString(9));
    	pdfData.setCol11(rowSet.getString(10));
    	pdfData.setCol12(rowSet.getString(11));
    	pdfData.setCol13(rowSet.getString(12));
    	pdfData.setCol14(rowSet.getString(13));
    	pdfData.setCol15(rowSet.getString(14));
    	pdfData.setCol16(rowSet.getString(15));
    	pdfData.setCol17(rowSet.getString(16));
    	pdfData.setCol18(rowSet.getString(17));
    	pdfData.setCol19(rowSet.getString(18));
    	pdfData.setCol20(rowSet.getString(19));
    	pdfData.setCol21(rowSet.getString(20));
    	pdfData.setCol22(rowSet.getString(21));
    	pdfData.setCol23(rowSet.getString(22));
    	pdfData.setCol24(rowSet.getString(23));
    	pdfData.setCol25(rowSet.getString(24));
    	pdfData.setCol26(rowSet.getString(25));
    	pdfData.setCol27(rowSet.getString(26));
    	pdfData.setCol28(rowSet.getString(27));
    	pdfData.setCol29(rowSet.getString(28));
    	pdfData.setCol30(rowSet.getString(29));

        return pdfData;
    }

	@Override
	public PdfData mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}

