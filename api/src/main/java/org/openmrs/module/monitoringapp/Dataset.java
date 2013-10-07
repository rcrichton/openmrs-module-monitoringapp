package org.openmrs.module.monitoringapp;

import java.util.ArrayList;
import java.util.List;

public class Dataset implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String fillColor = "rgba(220,220,220,0.5)";
	public String strokeColor = "rgba(220,220,220,1)";
	public String pointColor = "rgba(220,220,220,1)";
	public String pointStrokeColor = "#fff";
	public List<Integer> data = new ArrayList<Integer>();
}