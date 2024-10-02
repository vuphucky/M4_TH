<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
  <title>Title</title>
</head>
<body>
<h3>Product Management</h3>
<p>
  <a th:href="@{/product/create}">
    Add new product
  </a>
</p>
<table id = "products">
  <thead>
  <tr>
    <th>Name</th>
    <th>Description</th>
    <th>Image</th>
  </tr>
  </thead>
  <tbody>
  <tr th:each="product : ${products}">
    <td th:text="${product.name}"></td>
    <td th:text="${product.description}"></td>
    <td><img width="100" height="100" th:src="@{'/image/' + ${product.image}}" alt="" src=""></td>
  </tr>
  </tbody>
</table>
</body>
</html>