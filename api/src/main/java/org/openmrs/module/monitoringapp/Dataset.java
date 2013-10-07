package org.openmrs.module.monitoringapp;

import java.util.ArrayList;
import java.util.List;

public class Dataset implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String fillColor = "";
	public String strokeColor = "";
	public List<Integer> data = new ArrayList<Integer>();
}