package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.GetMsgList;
import com.nncq.sunmoon.entity.Msg;

/**
 * 消息
 * 
 * @author 拉布拉多是条狗
 *
 */
public interface MsgService {
	/**
	 * 添加一条消息
	 * 
	 * @param msg
	 */
	public void addMsg(Msg msg);
	
	/**
	 * 获取最新一条未读信息
	 * @param object_id
	 * @return
	 */
	public Msg getNoReadMsg(Msg msg);
	
	/**
	 * 标记已读
	 * @param msg
	 */
	public void readMsg(Msg msg);
	
	/**
	 * 通知
	 * @param getMsgList
	 * @return
	 */
	public List<Msg> getMsgList(GetMsgList getMsgList);
	
}
