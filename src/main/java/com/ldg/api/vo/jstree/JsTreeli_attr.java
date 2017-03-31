package com.ldg.api.vo.jstree;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown
		 = true)
public class JsTreeli_attr {
	private int level;
	private Integer projectid;
	private String id;

	public Integer getProjectid() {
		return projectid;
	}

	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "JsTreeli_attr [level=" + level + ", id=" + id + "]";
	}
	
}
