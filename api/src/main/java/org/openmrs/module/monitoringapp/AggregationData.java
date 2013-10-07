package org.openmrs.module.monitoringapp;

import java.util.ArrayList;
import java.util.List;

public class AggregationData implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2682528778230636823L;
	
	public List<String> labels = new ArrayList<String>();
	public List<Dataset> dataSets = new ArrayList<Dataset>();


}
