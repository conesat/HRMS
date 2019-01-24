package com.nncq.sunmoon.service;

import java.util.List;

import com.nncq.sunmoon.entity.Post;
import com.nncq.sunmoon.tools.entity.SelectEntity;

public interface PostManageService {
	public void addPost(Post post);

	public List<Post> getPostsBySE(SelectEntity selectEntity);

	public int getPostsNumberBySE(SelectEntity selectEntity);

	public Post getPostById(String id);

	public void updatePost(Post post);

	public void delPost(String id);

	public String getLastId();
	
	public List<Post> getAllPostIdName();
}
