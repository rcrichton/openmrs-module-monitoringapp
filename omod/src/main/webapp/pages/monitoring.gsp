<%
 ui.decorateWith("appui", "standardEmrPage")
 ui.includeCss("monitoringapp", "nv.d3.css");
 ui.includeJavascript("monitoringapp", "d3.v3.js");
 ui.includeJavascript("monitoringapp", "nv.d3.js");
%>

<h1>${ ui.message("monitoringapp.monitoring.page.title") }</h1>


<h2>Patient Data Metrics</h2>

<canvas style="align: center" id="canvas" height="450" width="600"></canvas>

	<script>

    function getID(id){
      return document.getElementById(id);
    }
    
    function ajaxRequest(aElement, aUrl) {
        var httpRequest = new XMLHttpRequest();
        httpRequest.onreadystatechange = function() {
            handleResult(aElement, httpRequest);
        };
        try {
            httpRequest.open('GET', aUrl, true);
            httpRequest.send(null);
        } catch(e){
        }
    }

    function handleResult(control, aXMLHttpRequest) {
        if (!aXMLHttpRequest) return;

        if (!control) return;

        if (aXMLHttpRequest.readyState == 4 && aXMLHttpRequest.status == 200) {
            var lineChartData = JSON.parse(aXMLHttpRequest.responseText);
            
            var myLine = new Chart(control.getContext("2d")).Line(lineChartData);
        }
    }
    
    ajaxRequest(getID('canvas'), 'http://localhost:8080/openmrs/ws/rest/v1/monitoringapp/patientscreated?period=y');
	
	</script>
	
<br/>

<div style="align: center">
	<input type="button" id="Year" onclick="ajaxRequest(getID('canvas'), 'http://localhost:8080/openmrs/ws/rest/v1/monitoringapp/patientscreated?period=y')" value="Year">
	<input type="button" id="Month" onclick="ajaxRequest(getID('canvas'), 'http://localhost:8080/openmrs/ws/rest/v1/monitoringapp/patientscreated?period=m')" value="Month">
	<input type="button" id="Day" onclick="ajaxRequest(getID('canvas'), 'http://localhost:8080/openmrs/ws/rest/v1/monitoringapp/patientscreated?period=d')" value="Day">
</div>

<article id="server-metrics">
<section>
<h2>Server Metrics</h2>

<svg id="line-chart" style="height:600px"></svg>


other graph
<style>

#chart svg {
  height: 400px;
}

</style>


<div id="stacked-chart">
  <svg></svg>
</div>

<%
 ui.includeJavascript("monitoringapp", "monitoringapp.js");
%>

