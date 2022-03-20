<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Make My Trip</title>

<style type="text/css">

#table {
	text-align: center;
	/* border:5px solid black; */
	border-collapse: collapse;
}

#table th {
	/* border-bottom: 1px solid #ddd; */
	border-radius: 8px;
	box-shadow: 0 7px #999;
}

#table th {
	background-color: #084c33;
	color: white;
}

#table1 thead {
	text-align: center;
	margin-top: 23px;
}

#table1 th {
	background-color: #04AA6D;
	color: white;
}

#table1 tr:nth-child(odd) {
	background-color: #f2f2f2;
}

.but {
	background-color: #6f41c9;
	color: #fff;
	font-size: 14px;
	padding: 5px;
	border-radius: 15px;
	cursor: pointer;
	box-shadow: 0 7px #999;
}

.but:hover {
	background-color: #3f198b;
}

.but:active {
	background-color: #3f198b;
	box-shadow: 0 4px #666;
	transform: translateY(2px);
}

#caption {
	font-size: 18px;
	font-family: sans-serif;
	margin-top: 10px;
	margin-bottom: 10px;
}
</style>

</head>

<script type="text/javascript">

	function search() {
		var source = document.getElementById("src").value;
		var destn = document.getElementById("destn").value;

		/* alert(source);
		alert(destn); */
		var request = new XMLHttpRequest();
		var url = "http://localhost:9091/flights/" + source + "/" + destn;
		request.open("GET", url, true);
		request.send();
		request.onreadystatechange = function() {

			if (request.readyState == 4 && request.status == 200) {

				var flights = JSON.parse(request.responseText);/*Parsing response into JSON format*/

				var div = document.getElementById("addTable");

				var tabl = document.createElement('table'); /* Creating a New HTML Element - Table   */
				tabl.setAttribute('id', 'table1');/* Setting Table Attribute(Id) - to give it a Style by referring id*/
				var caption = tabl.createCaption();
				caption.setAttribute('id', 'caption');
				caption.innerHTML = "Flights Available <br>from <b>"
						+ source.toUpperCase() + "</b> to <b>"
						+ destn.toUpperCase() + " </b>";

				var th = tabl.createTHead(); /*Table Header */
				var row = th.insertRow();/*Table Header Row*/

				/*Table Header Cells*/
				var cell1 = row.insertCell();
				var cell2 = row.insertCell();
				var cell3 = row.insertCell();
				var cell4 = row.insertCell();
				var cell5 = row.insertCell();

				cell1.innerHTML = "<b>ID</b>";
				cell2.innerHTML = "<b>Name</b>";
				cell3.innerHTML = "<b>Date</b>";
				cell4.innerHTML = "<b>Source</b>";
				cell5.innerHTML = "<b>Destination</b>";

				for (var i = 0; i < flights.length; i++) { /* flights is a JSON Collection iterating it and filling data in new Table Rows */

					var row1 = tabl.insertRow();

					var cell1 = row1.insertCell();
					cell1.innerHTML = flights[i].fid;
					var cell2 = row1.insertCell();
					cell2.innerHTML = flights[i].name;
					var cell3 = row1.insertCell();
					cell3.innerHTML = flights[i].date;
					var cell4 = row1.insertCell();
					cell4.innerHTML = flights[i].source;
					var cell5 = row1.insertCell();
					cell5.innerHTML = flights[i].destn;

				}
				div.innerHTML = "";
				div.appendChild(tabl);
			}
		}
	}
	function sortById() {
		var table, rows, switching, i, x, y, shouldSwitch;
		table = document.getElementById("table1");
		switching = true;
		/*Make a loop that will continue until no switching has been done*/

		while (switching) {
			//Start by saying no switching is done:
			switching = false;
			rows = table.rows;
			/*Loop through all table rows (except the first one ,which contains table headers)*/
			for (i = 1; i < (rows.length - 1); i++) {

				//Start by saying there should be no switching:
				shouldSwitch = false;
				/*Get the two elements you want to compare,one from current row and one from the next*/
				x = rows[i].getElementsByTagName("TD")[0];
				y = rows[i + 1].getElementsByTagName("TD")[0];

				
				if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
					//if so ,mark as a switch and break the loop:
					shouldSwitch = true;
					break;
				}
				if (shouldSwitch) {
					/*If switch has marked,make the switch and mark that switch has been done */
					rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
					switching = true;
				}
			}

		}
	}
</script>
<body>
	<form>
		<h2 align="center">Search Flights</h2>

		<table id="table" align="center">
			<tr>
				<th>Source</th>
				<td><input type="text" id="src" placeholder="Enter Source City">
				</td>

				<th>Destination</th>
				<td><input type="text" id="destn"
					placeholder="Enter Destination City"></td>

				<td align="center">
				<input type="button" value="Search" onclick="search()" id="button1" class="but">
					 <input type="reset" id="button2" class="but"></td>
			</tr>
		</table>
		<br> 
		<input id="fid" type="button" value="Sort By Id" class="but"
			onclick="sortById()">

		<div id="addTable" align="center" />

	</form>
</body>
</html>