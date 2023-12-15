package kr.co.sist.user.service.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.dao.sales.SalesDAO;
import kr.co.sist.user.domain.sales.SalesDomain;

@Service
public class SalesService {

	@Autowired
	private SalesDAO sDAO;
	
	public List<SalesDomain> searchAllSales(String id) {
		return sDAO.selectAllSales(id);
	}
	
	public List<SalesDomain> searchOnSales(String id) {
		return sDAO.selectOnSales(id);
	}
	
	public List<SalesDomain> searchFinishedSales(String id) {
		return sDAO.selectFinishedSales(id);
	}
}
