package kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.spring.dao.PaymentDAO;
import kh.spring.dao.PointAccountDAO;
import kh.spring.dao.PointDAO;
import kh.spring.dto.PaymentDTO;
import kh.spring.dto.PointAccountDTO;
import kh.spring.dto.PointDTO;


@Service
public class PointService {

	@Autowired
	private PointDAO dao;
	
	@Autowired
	private PaymentDAO paydao;
	
	@Autowired
	private PointAccountDAO padao;
	
	
	public int charging(PointDTO dto) throws Exception{
		return dao.charging(dto);
	}
	
	public int pointCheck(String sessionID, int point) {
		int sum= dao.amount(sessionID);
		int leftpoint = sum-point;
		System.out.println("현재 포인트: "+leftpoint);
		
		if(leftpoint<0) { //사용 포인트 초과
			return 0;
		}else {   //사용가능
			return 1;
		}
	}

	public int amount(String sessionID) {
		
		return dao.amount(sessionID);
	}

	public int payment(PaymentDTO dto) {
		return paydao.payment(dto);
	}

	public int minus(PointAccountDTO padto) {
		return padao.minus(padto);
		
	}
	

	
}
