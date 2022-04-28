<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

</body>

<script type="text/javascript">
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}
</script>

<% request.removeAttribute("msg"); %>
</html>