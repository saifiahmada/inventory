package com.saifiahmada.belajarzk.test;

import java.util.ArrayList;
import java.util.List;



public class TabArguement {



	public enum TabMode {
		PICK, DETAIL;
	}

	
	private String sourcePage;

	private TabMode mode;

	public TabArguement() {
		super();
	}

	public TabArguement(TabMode mode) {
		super();
		this.mode = mode;

	}
	 
	public TabArguement(String sourcePage, TabMode mode) {
		super();
		this.sourcePage = sourcePage;
		this.mode = mode;
	}

	

	
	public TabMode getMode() {
		return mode;
	}

	// CsdcConstants interface have the constants defined for detail and pick
	public void setMode(TabMode mode) {
		this.mode = mode;
	}

	public String getSourcePage() {
		return sourcePage;
	}

	public void setSourcePage(String sourcePage) {
		this.sourcePage = sourcePage;
	}

	
}
