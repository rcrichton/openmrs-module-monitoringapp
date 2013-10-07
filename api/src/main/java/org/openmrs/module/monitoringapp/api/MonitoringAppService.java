package org.openmrs.module.monitoringapp.api;


import org.openmrs.api.OpenmrsService;
import org.openmrs.module.monitoringapp.AggregationData;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface MonitoringAppService extends OpenmrsService {

	public enum AggregationPeriod {
	    ALLTIME, YEAR, MONTH, WEEK, DAY;
	}

	public AggregationData getPatientRegistrationAggregation(AggregationPeriod period);
	
}
