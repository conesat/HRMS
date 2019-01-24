package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.ContractManageDao;
import com.nncq.sunmoon.entity.Contract;
import com.nncq.sunmoon.entity.StaffContractDTO;
import com.nncq.sunmoon.service.ContractManageService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class ContractManageServiceImpl implements ContractManageService {
	@Autowired
	private ContractManageDao contractManageDao;

	public String addContract(Contract contract) throws RuntimeException {
		String id = getLastId();
		if (id == null) {
			id = "CONT-1001";
		} else {
			id = "CONT-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		contract.setContract_id(id);
		contractManageDao.addContract(contract);
		return id;
	}

	public List<Contract> getContractsBySE(SelectEntity selectEntity) {
		List<Contract> re = null;
		try {
			re = contractManageDao.getContractsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getContractsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = contractManageDao.getContractsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Contract getContractById(String id) {
		Contract re = null;
		try {
			re = contractManageDao.getContractById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updateContract(Contract Contract) {
		contractManageDao.updateContract(Contract);

	}

	public void delContract(String id) {
		contractManageDao.delContract(id);

	}

	public String getLastId() {
		String re = null;
		try {
			re = contractManageDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Contract> getAllContractIdName() {
		List<Contract> re = null;
		try {
			re = contractManageDao.getAllContractIdName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void uploadContract(Contract Contract) {
		contractManageDao.uploadContract(Contract);
	}

	 
	public List<StaffContractDTO> getStaffContractsBySE(SelectEntity selectEntity) {
		List<StaffContractDTO> re = null;
		try {
			re = contractManageDao.getStaffContractsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public int getStaffContractsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = contractManageDao.getStaffContractsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	 
	public void updateStaffOldContract() throws RuntimeException {
		contractManageDao.updateStaffOldContract();
	}

}
