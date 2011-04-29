<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
<title>Home</title>
</HEAD>
<BODY>

<h2>This is the home page</h2>

<img src="resources/images/puppy.jpg"/>

<H3>Try retrieving some data...</H3>
<ul>
<li><a href="listbooks">List all books</a></li>
</ul>

<H3>Or upload a file...</H3>
<form action="upload" enctype="multipart/form-data" method="post">
	Description : <INPUT type="text" name="description"><BR>
	File : <INPUT type="file" name="myFile"><BR>
	<INPUT type="submit" value="Send"> <INPUT type="reset">
</form>
	
</BODY>
</HTML>