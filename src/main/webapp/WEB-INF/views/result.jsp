<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sorting Result</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Helvetica Neue', 'Arial', sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 600px;
            margin: auto;
            padding: 30px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
            margin-top: 50px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center">Sorting Result</h1>
    <p class="text-center">${sortedArray}</p>
    <div class="text-center">
        <a href="${pageContext.request.contextPath}/" class="btn btn-primary">Sort another array</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>