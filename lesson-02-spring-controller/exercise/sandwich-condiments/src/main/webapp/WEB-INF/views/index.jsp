<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<fieldset>
    <legend>Sandwich Condiments</legend>
    <form action="/save" method="get">
        <label for="lettuce">Lettuce</label>
        <input type="checkbox" name="condiments" value="Lettuce" id="lettuce">
        <label for="tomato">Tomato</label>
        <input type="checkbox" name="condiments" value="Tomato" id="tomato">
        <label for="mustard">Mustard</label>
        <input type="checkbox" name="condiments" value="Mustard" id="mustard">
        <label for="sprouts">Sprouts</label>
        <input type="checkbox" name="condiments" value="Sprouts" id="sprouts">
        <hr>
        <button>Save</button>
    </form>
</fieldset>
</body>
</html>