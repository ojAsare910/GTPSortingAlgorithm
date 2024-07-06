<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sorting Algorithms</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            font-family: 'Helvetica Neue', 'Arial', sans-serif;
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
            margin: auto;
            padding: 30px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
            margin-top: 50px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        .btn-info {
            background-color: #17a2b8;
            border-color: #17a2b8;
        }
        .btn-info:hover {
            background-color: #117a8b;
            border-color: #117a8b;
        }
        #errorModal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0,0,0,0.4);
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #errorModalContent {
            background-color: #fefefe;
            margin: auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
            max-width: 500px;
        }
        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }
        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center">Sorting Algorithms</h1>
    <form action="sort" method="post" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="array">Enter numbers to sort (comma-separated):</label>
            <input type="text" class="form-control" id="array" name="array" required>
        </div>
        <div class="form-group">
            <label for="algorithm">Choose a sorting algorithm:</label>
            <select class="form-control" id="algorithm" name="algorithm">
                <option value="heap">Heap Sort</option>
                <option value="quick">Quick Sort</option>
                <option value="merge">Merge Sort</option>
                <option value="radix">Radix Sort</option>
                <option value="bucket">Bucket Sort</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Sort</button>
    </form>
    <div class="mt-3 text-center">
        <a href="${pageContext.request.contextPath}/hateoas" class="btn btn-info">HATEOAS Endpoint</a>
    </div>
</div>

<div id="errorModal">
    <div id="errorModalContent">
        <span class="close" onclick="closeModal()">&times;</span>
        <p id="errorText"></p>
    </div>
</div>

<script>
    function validateForm() {
        var input = document.getElementById('array').value;
        if (!input.split(',').every(n => !isNaN(parseFloat(n.trim())))) {
            document.getElementById('errorText').textContent = 'Please enter valid numbers separated by commas.';
            document.getElementById('errorModal').style.display = 'flex';
            return false;
        }
        return true;
    }

    function closeModal() {
        document.getElementById('errorModal').style.display = 'none';
    }

    document.addEventListener('DOMContentLoaded', function() {
        var error = "<%= request.getAttribute("error") %>";
        if (error && error !== "null" && error.trim() !== "") {
            document.getElementById('errorText').textContent = error;
            document.getElementById('errorModal').style.display = 'flex';
        } else {
            document.getElementById('errorModal').style.display = 'none';
        }
    });
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
