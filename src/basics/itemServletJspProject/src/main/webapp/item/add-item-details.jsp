<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Item Details</title>
</head>
<body>

<h2>Add Item Details</h2>

<form action="/item-service-909/ItemDetailsController" method="post">

    <input type="hidden" name="action" value="add">
    <input type="hidden" name="id" value="${param.id}">

    <label>Description</label><br>
    <input type="text" name="description" required><br><br>

    <label>Issue Date</label><br>
    <input type="date" name="issueDate" required><br><br>

    <label>Expiry Date</label><br>
    <input type="date" name="expiryDate" required><br><br>

    <button type="submit">Save Details</button>
</form>

</body>
</html>
