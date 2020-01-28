<%-- 
    Document   : editnote
    Created on : Jan 24, 2020, 10:46:21 AM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>edit note</h2>
        <!--action is important!!!!-->
        <form method="POST" action="/Week03Lab_SimpleNoteKeeper/note">
            Title<input type="text" name="title" value="${note.title}"><br>
            Contents:<textarea type="text" name="contents">${note.contents}</textarea><br>
            <button type="submit" value="save" name="edit">Save</button>
            <!--<input type="submit" value="Save.." />-->

        </form>


        <br>
        ${guestcount}
    </body>
</html>
