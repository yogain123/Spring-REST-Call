<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/static/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value='/resources/static/js/app.js'/>"></script>
</head>
<body ng-app="myApp", ng-controller="myCtrl" class="container">
<div class="row" style="margin-top:30px">
  <div class="col-lg-6">
    <div class="input-group">
      <span class="input-group-btn">
        <button class="btn btn-secondary" type="button" ng-click="add()">Add</button>
      </span>
      <input type="text" class="form-control" placeholder="Add Items..." aria-label="Search for...">
    </div>
  </div>  
</div>
<br><br>

<table class="table table-bordered">
    <thead>
      <tr>
        <th>{{res}}</th>
        <th>{{test}}</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>



</body>
</html>