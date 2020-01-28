<%-- 
    Document   : viewnote
    Created on : Jan 24, 2020, 10:46:09 AM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>view note</h2>

        <B> Title: </B> ${note.title} <br>
        <B> Contents: </B>    ${note.contents} <br>


        <!--add a link to editnote.jsp-->
        <a href="/Week03Lab_SimpleNoteKeeper/note?edit"> Edit</a>
        <br>
        ${guestcount}
    </body>
</html>
