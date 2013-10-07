<%
 ui.decorateWith("appui", "standardEmrPage")
 ui.includeJavascript("monitoringapp", "Chart.js");
%>

<h2>${ ui.message("monitoringapp.monitoring.page.title") }!</h2>

<canvas id="canvas" height="450" width="600"></canvas>


	<script>

    var incomingData = {labels : ["January","February","March","April","May","June","July"],datasets : [{fillColor : "rgba(220,220,220,0.5)",strokeColor : "rgba(220,220,220,1)",pointColor : "rgba(220,220,220,1)",pointStrokeColor : "#fff",data : [65,59,90,81,56,55,40]},{fillColor : "rgba(151,187,205,0.5)",strokeColor : "rgba(151,187,205,1)",pointColor : "rgba(151,187,205,1)",pointStrokeColor : "#fff",data : [28,48,40,19,96,27,100]}]};

		var lineChartData = {
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
			
		}

	var myLine = new Chart(document.getElementById("canvas").getContext("2d")).Line(lineChartData);
	
	</script>
