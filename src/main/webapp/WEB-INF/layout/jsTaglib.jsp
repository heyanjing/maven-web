<%@page contentType="text/html;charset=UTF-8"%>
<script type="text/javascript">
	window.App = {
		log : function(msg) {
			if (window.console) {
				console.log(msg);
			}
		}
	};
	window.CTX = '${CTX}';
	window.JS = '${JS}';
	window.IMG = '${IMG}';
</script>
