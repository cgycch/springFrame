package com.cch.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cch.dao.BeanOneDao;
import com.cch.entities.BeanOne;

@Repository
public class BeanOneImpl implements BeanOneDao {
	
	@Resource(name="myJdbcTemplate")
	private JdbcTemplate jdbctemplate;

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
	public List<BeanOne> findALl() {
		String sql = "select * from t_report where 1=1";
		return jdbctemplate.query(sql, mapper());
	}

	@Override
	public void update() {
		String sql ="update t_report set rname = ? ,rdate = ? where rid = ?";
		Object[] args = new Object[] {"NAME_AA","2018-08-16","r0"};
		jdbctemplate.update(sql, args);
	}

	@Override
	public void insert() {
		String sql ="insert into t_report(rid,rname,rdate) values(?,?,?)";
		Object[] args = new Object[] {"r001","NAME_ASD","2018-08-16"};
		jdbctemplate.update(sql, args);
	}

}
