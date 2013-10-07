package org.openmrs.module.monitoringapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.webservices.rest.web.RestConstants;
import org.openmrs.module.webservices.rest.web.response.ResponseException;
import org.openmrs.module.webservices.rest.web.v1_0.controller.BaseRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping("/rest/" + RestConstants.VERSION_1 + "/monitoringapp")
public class MonitoringAppResourceController extends BaseRestController {
	
	@RequestMapping(value = "/patientscreated", method = RequestMethod.GET)
	@ResponseBody
	public String getPatientCreated(HttpServletRequest request,
			HttpServletResponse response) throws ResponseException {
		
		//Context.getService(this.getClass());
		
		objectToJson(new Object());
	
		String jsonData = "{" +
						"labels : [\"January\",\"February\",\"March\",\"April\",\"May\",\"June\",\"July\"]," +
						"datasets : [" +
							"{" +
								"fillColor : \"rgba(220,220,220,0.5)\"," +
								"strokeColor : \"rgba(220,220,220,1)\"," +
								"pointColor : \"rgba(220,220,220,1)\"," +
								"pointStrokeColor : \"#fff\"," +
								"data : [65,59,90,81,56,55,40]" +
							"}," +
							"{" +
								"fillColor : \"rgba(151,187,205,0.5)\"," +
								"strokeColor : \"rgba(151,187,205,1)\"," +
								"pointColor : \"rgba(151,187,205,1)\"," +
								"pointStrokeColor : \"#fff\"," +
								"data : [28,48,40,19,96,27,100]" +
							"}" +
						"]" +
					"}";
	
		return jsonData;
	}
	
	@RequestMapping(value = "/encountertypes", method = RequestMethod.GET)
	@ResponseBody
	public String getEncounterTypes(HttpServletRequest request,
			HttpServletResponse response) throws ResponseException {
		
		//Context.getService(this.getClass());
		
		objectToJson(new Object());
		
		String jsonData = "[" +
		               	"{" +
		            		"value : 30," +
		            		"color : \"#F38630\"" +
		            	"}," +
		            	"{" +
		            		"value : 50," +
		            		"color : \"#E0E4CC\"" +
		            	"}," +
		            	"{" +
		            		"value : 100," +
		            		"color : \"#69D2E7\"" +
		            	"}" +			
		            "]";
		return jsonData;
	}
	
	private String objectToJson(Object obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return json;
	}
}