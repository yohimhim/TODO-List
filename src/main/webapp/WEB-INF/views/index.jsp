<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>TODO List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

<h1 style="text-align:center; margin-top: 20px;">To-Do List</h1>

<div class="todo-container">
    <div class="todo-header">
        <h2>My Tasks</h2>
        <a href="${pageContext.request.contextPath}/addTask">
            <button class="add-btn">Add Task</button>
        </a>
    </div>

    <c:if test="${empty tasks}">
        <p style="margin-top: 20px;">No tasks found.</p>
    </c:if>

    <c:forEach var="task" items="${tasks}">
        <div class="task-card">
            <div class="task-info">
                <div class="task-title">${task.title}</div>
                <div class="task-desc">${task.description}</div>
                <div class="task-date">Due ${task.deadline}</div>
            </div>
        </div>
        <div class="task-actions">
                        <button class="completed">✔</button>
                        <button class="edit">edit</button>
                        <button class="delete">delete</button>
                    </div>
    </c:forEach>

</div>

</body>
</html>
