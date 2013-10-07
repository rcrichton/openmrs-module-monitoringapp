<%
 ui.decorateWith("appui", "standardEmrPage")
 ui.includeJavascript("monitoringapp", "Chart.js");
%>

<h2>${ ui.message("monitoringapp.monitoring.page.title") }!</h2>

<canvas id="canvas" height="450" width="600"></canvas>

<!-- 
  // 
  // 
  // Temporary path here! 
  //
  //
-->
<input type="button" id="Refresh" onclick="ajaxRequest(getID('canvas'), '../test.txt')" value="Refresh">

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

    var lineChartData = {labels : ["January","February","March","April","May","June","July"],datasets : [{fillColor : "rgba(220,220,220,0.5)",strokeColor : "rgba(220,220,220,1)",pointColor : "rgba(220,220,220,1)",pointStrokeColor : "#fff",data : [65,59,90,81,56,55,40]},{fillColor : "rgba(151,187,205,0.5)",strokeColor : "rgba(151,187,205,1)",pointColor : "rgba(151,187,205,1)",pointStrokeColor : "#fff",data : [28,48,40,19,96,27,100]}]};

		/*var lineChartData = {
			labels : ["January","February","March","April","May","June","July"],
			datasets : [
				{
					fillColor : "rgba(220,220,220,0.5)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					data : [65,59,90,81,56,55,40]
				},
				{
					fillColor : "rgba(151,187,205,0.5)",
					strokeColor : "rgba(151,187,205,1)",
					pointColor : "rgba(151,187,205,1)",
					pointStrokeColor : "#fff",
					data : [28,48,40,19,96,27,100]
				}
			]
			
		}*/

	var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Line(lineChartData);
	
	</script>
