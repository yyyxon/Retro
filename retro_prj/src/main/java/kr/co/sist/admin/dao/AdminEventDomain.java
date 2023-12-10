package kr.co.sist.admin.dao;

import java.sql.Date;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.ToString;

@Getter
@Service
@ToString
public class AdminEventDomain {
	private String title, img, id, eventcode;
	private Date start_date, input_date, end_date;
	

}
