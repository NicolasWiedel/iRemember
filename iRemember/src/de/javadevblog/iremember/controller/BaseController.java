package de.javadevblog.iremember.controller;

import de.javadevblog.iremember.view.ViewFactory;

public abstract class BaseController {

	protected ViewFactory viewFactory;
	private String fxmlName;
	
	public BaseController(ViewFactory viewfactory, String fxmlName) {
		this.viewFactory = viewFactory;
		this.fxmlName = fxmlName;
	}

	public ViewFactory getViewFactory() {
		return viewFactory;
	}

	public void setViewFactory(ViewFactory viewFactory) {
		this.viewFactory = viewFactory;
	}

	public String getFxmlName() {
		return fxmlName;
	}

	public void setFxmlName(String fxmlName) {
		this.fxmlName = fxmlName;
	}
	
	
}
