package org.openmrs.module.monitoringapp.api.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openmrs.api.context.Context;
import org.openmrs.module.monitoringapp.AggregationData;
import org.openmrs.module.monitoringapp.Dataset;
import org.openmrs.module.monitoringapp.api.MonitoringAppService;
import java.text.DateFormatSymbols;

public class MonitoringAppServiceImpl implements MonitoringAppService {

	private final String PATIENTCREATEDSQL = "SELECT COUNT(*) FROM patient WHERE date_created BETWEEN 'FROMDATE' AND 'TODATE';";
			
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

		AggregationData aggData= new AggregationData();
		
		switch (period){
		
			case YEAR: return aggregateYear(aggData);
			case MONTH: break;
			case DAY: break;
			default: break;
		
		}
		
		return null;
	}

	AggregationData aggregateYear(AggregationData aggData){
		
		Dataset set = new Dataset();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(today); 
        int currentDOM = cal.get(Calendar.DATE);
        cal.add(Calendar.MONTH, -12);
        cal.add(Calendar.DATE, (currentDOM)*-1 +1);
        Date fromDate = cal.getTime();

        
		for (int i=1; i<=12; i++){
			
	        aggData.labels.add(new SimpleDateFormat("MMMM").format(fromDate));
			cal.add(Calendar.MONTH, 1);
			Date toDate = cal.getTime();
			
			String sql = PATIENTCREATEDSQL.replaceAll("FROMDATE", dateFormat.format(fromDate));
			sql = sql.replace("TODATE", dateFormat.format(toDate));
			
			List<List<Object>> countObject = Context.getAdministrationService().executeSQL(sql, true);
			Long count = (Long) countObject.get(0).get(0);
			set.data.add(count.intValue());
			fromDate = toDate;
		}
		
		aggData.datasets.add(set);
		return aggData;
	}
	
	AggregationData aggregateMonth(AggregationData aggData){
		Dataset set = new Dataset();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(today); 
        cal.add(Calendar.DATE, -30);
        Date fromDate = cal.getTime();

        
		for (int i=1; i<=30; i++){
			
	        aggData.labels.add(new SimpleDateFormat("MMMM dd").format(fromDate));
			cal.add(Calendar.DATE, 1);
			Date toDate = cal.getTime();
			
			String sql = PATIENTCREATEDSQL.replaceAll("FROMDATE", dateFormat.format(fromDate));
			sql = sql.replace("TODATE", dateFormat.format(toDate));
			
			List<List<Object>> countObject = Context.getAdministrationService().executeSQL(sql, true);
			Long count = (Long) countObject.get(0).get(0);
			set.data.add(count.intValue());
			fromDate = toDate;
		}
		
		aggData.datasets.add(set);
		return aggData;
	}
	
	AggregationData aggregateDay(AggregationData aggData){
		Dataset set = new Dataset();
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = new Date();
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(today); 
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND,0);
        Date fromDate = cal.getTime();
        
		for (int i=1; i<=24; i++){
			
	        aggData.labels.add(new SimpleDateFormat("HH:mm").format(fromDate));
			cal.add(Calendar.HOUR, 1);
			Date toDate = cal.getTime();
			
			String sql = PATIENTCREATEDSQL.replaceAll("FROMDATE", dateFormat.format(fromDate));
			sql = sql.replace("TODATE", dateFormat.format(toDate));
			
			List<List<Object>> countObject = Context.getAdministrationService().executeSQL(sql, true);
			Long count = (Long) countObject.get(0).get(0);
			set.data.add(count.intValue());
			fromDate = toDate;
		}
		
		aggData.datasets.add(set);
		return aggData;
	}
	
	
}
