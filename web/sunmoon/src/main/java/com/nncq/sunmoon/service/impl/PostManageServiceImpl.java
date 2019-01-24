package com.nncq.sunmoon.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nncq.sunmoon.dao.PostManageDao;
import com.nncq.sunmoon.entity.Post;
import com.nncq.sunmoon.service.PostManageService;
import com.nncq.sunmoon.tools.entity.SelectEntity;

@Transactional
@Service
public class PostManageServiceImpl implements PostManageService {
	@Autowired
	private PostManageDao postManageDao;

	public void addPost(Post post) throws RuntimeException{
		String id = getLastId();
		if (id == null) {
			id = "POST-1001";
		} else {
			id = "POST-" + (Integer.parseInt(id.split("-")[1]) + 1);
		}
		post.setPost_id(id);
		postManageDao.addPost(post);
	}

	public List<Post> getPostsBySE(SelectEntity selectEntity) {
		List<Post> re = null;
		try {
			re = postManageDao.getPostsBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public int getPostsNumberBySE(SelectEntity selectEntity) {
		int re = 0;
		try {
			re = postManageDao.getPostsNumberBySE(selectEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public Post getPostById(String id) {
		Post re = null;
		try {
			re = postManageDao.getPostById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public void updatePost(Post post) throws RuntimeException{
		postManageDao.updatePost(post);
	}

	public void delPost(String id) throws RuntimeException{
		postManageDao.delPost(id);
	}

	public String getLastId() {
		String re = null;
		try {
			re = postManageDao.getLastId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

	public List<Post> getAllPostIdName() {
		List<Post> re = null;
		try {
			re = postManageDao.getAllPostIdName();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return re;
	}

}
