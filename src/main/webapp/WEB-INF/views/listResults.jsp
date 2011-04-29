<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
<title>Books</title>
</HEAD>
<BODY>

	<h2>List of books</h2>
	
	<table cellspacing="10">
		<c:forEach var="book" items="${requestScope.books}">
			<tr>
			<td><c:out value="${book.title}" /></td>
			<td><c:out value="${book.publicationDate}" /></td>
			<td><c:out value="${book.author.firstName} ${book.author.lastName}" /></td>
			<c:url value="getbook" var="getBookURL">
				<c:param name="title" value="${book.title}"/>
			</c:url>

			<td><a href='<c:out value="${getBookURL}"/>'>Param link</a></td>
			<td><a href='rest/book/<c:out value="${book.id}"/>'>Rest Link</a></td>
			</tr>
		</c:forEach>
	</table>
</BODY>
</HTML>