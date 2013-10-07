<%
 ui.decorateWith("appui", "standardEmrPage")
 ui.includeJavascript("monitoringapp", "Chart.js");
%>

<h2>${ ui.message("monitoringapp.monitoring.page.title") }!</h2>

<canvas id="canvas" height="450" width="600"></canvas>

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

<input type="button" id="Refresh" onclick="ajaxRequest(getID('canvas'), 'http://localhost:8080/openmrs/ws/rest/v1/monitoringapp/patientscreated?period=y')" value="Refresh">


