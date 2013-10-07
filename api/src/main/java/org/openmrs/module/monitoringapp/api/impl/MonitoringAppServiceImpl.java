package org.openmrs.module.monitoringapp.api.impl;

import org.openmrs.module.monitoringapp.AggregationData;
import org.openmrs.module.monitoringapp.api.MonitoringAppService;

public class MonitoringAppServiceImpl implements MonitoringAppService {

	public MonitoringAppServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onShutdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AggregationData getPatientRegistrationAggregation(AggregationPeriod period) {
		// TODO Auto-generated method stub
		switch (period){
		
			case ALLTIME: break;
			case YEAR: break;
			case MONTH: break;
			case WEEK: break;
			case DAY: break;
			default: break;
		
		}
		
		return null;
	}

	
}
