package com.cch.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cch.dao.ReportDao;
import com.cch.entities.BeanOne;

@Repository
public class ReportDaoImpl implements ReportDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<BeanOne> mapper() {
		return (rs, rowNum) -> {
		    BeanOne report = new BeanOne();
		    report.setId(rs.getString("rid"));
		    report.setName(rs.getString("rname"));
		    report.setName2(rs.getString("rname2"));
		    report.setName3(rs.getString("rname3"));
		    report.setName4(rs.getString("rname4"));
		    report.setName5(rs.getString("rname5"));
		    report.setName6(rs.getString("rname6"));
		    report.setName7(rs.getString("rname7"));
		    report.setName8(rs.getString("rname8"));
		    report.setRint(rs.getInt("rint"));
		    report.setRint2(rs.getInt("rint2"));
		    report.setRdouble(rs.getDouble("rdouble"));
		    report.setRdouble2(rs.getDouble("rdouble2"));
		    report.setRfloat(rs.getFloat("rfloat"));
		    report.setRfloat2(rs.getFloat("rfloat2"));
		    report.setDate(rs.getDate("rdate"));
		    report.setDate2(rs.getDate("rdate2"));
		    return report;
		};
		
	}

	@Override
	public List<BeanOne> findAll() {
		String sql = "select * from t_report where 1=1";
		return jdbcTemplate.query(sql, mapper());
	}
	
	

	@Override
	public void insertReoprt() {
		System.out.println("insertUser just use for insert report data");
		long start = System.currentTimeMillis();
		System.out.println("start:"+start);
		String[] sqlAry= new String[200000];
		int offset = 100000;
		for (int i=0; i< sqlAry.length; i++) {
			int idx = offset + i;
			sqlAry[i] = "insert into t_report (rid, rname, rname2, rname3, rname4, rname5, rname6, rname7, rname8, "
					+ "rint, rint2, rdate, rdate2, rdouble, rdouble2, rfloat, rfloat2) "
					+ "values('r"+idx+"','tname','rname2','rname3','rname4','rname5','rname6','rname7','rname8',"
					+ "'1','2','2018-09-01 00:01:51','2018-09-02 00:01:59','123.456','456.123','1.2','2.3');";
		}
		jdbcTemplate.batchUpdate(sqlAry);
		long end = System.currentTimeMillis();
		System.out.println("end:"+end);
		System.out.println("takes (S):"+(end-start)/1000d);
	}

	
	

}
