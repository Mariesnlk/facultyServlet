<%@ tag language="java" pageEncoding="ISO-8859-1"%>

<div style="text-align: right">

	<select name="lang" id="locale">
		<%
			String currentLocale = null;
		if (session.getAttribute("locale") != null) {
			currentLocale = (String) session.getAttribute("locale");
		}

		String[] arLocales = (String[]) session.getAttribute("locales");
		for (int i = 0; i < arLocales.length; i++) {
		%>

		<option value="<%=arLocales[i]%>"
			<%if (arLocales[i].equals(currentLocale)) {%> selected <%}%>><%=arLocales[i]%></option>

		<%
			}
		%>

	</select>

</div>
<script>
	document.querySelector('#locale').addEventListener('change', changeURL);

	function changeURL() {
		var loc = document.querySelector('#locale').value;
		var currentUrl = location.href;
		var newURL = "";
		if (currentUrl.includes("lang")) {

			newURL = currentUrl.split("=")[0] + "=" + loc;
		}

		else {
			newURL = currentUrl + "?lang=" + loc;
		}
		location.href = newURL;

	}
</script>