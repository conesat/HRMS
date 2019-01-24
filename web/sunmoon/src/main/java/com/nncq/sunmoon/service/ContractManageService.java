package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Contract;
import com.nncq.sunmoon.entity.StaffContractDTO;
import com.nncq.sunmoon.tools.entity.SelectEntity;

/**
 * 合同管理
 * 
 * @author 拉布拉多是条狗
 *
 */
public interface ContractManageService {
	public String addContract(Contract contract);

	public List<Contract> getContractsBySE(SelectEntity selectEntity);

	public int getContractsNumberBySE(SelectEntity selectEntity);

	public Contract getContractById(String id);

	public void updateContract(Contract Contract);

	public void delContract(String id);

	public String getLastId();

	public List<Contract> getAllContractIdName();

	public void uploadContract(Contract Contract);

	/**
	 * 获取员工合同
	 * 
	 * @param selectEntity
	 * @return
	 */
	public List<StaffContractDTO> getStaffContractsBySE(SelectEntity selectEntity);

	/**
	 * 获取员工合同数量
	 * 
	 * @param selectEntity
	 * @return
	 */
	public int getStaffContractsNumberBySE(SelectEntity selectEntity);
	
	public void updateStaffOldContract();
}
