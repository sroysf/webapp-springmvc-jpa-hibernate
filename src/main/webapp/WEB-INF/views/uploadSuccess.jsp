<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
<title>File upload success</title>
</HEAD>
<BODY>

<h2>File successfully uploaded</h2>

File description = <c:out value="${requestScope.desc}"/><BR/>
Bytes received = <c:out value="${requestScope.fileSize}"/>
	
</BODY>
</HTML>