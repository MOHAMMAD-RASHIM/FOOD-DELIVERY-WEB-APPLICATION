<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>TapFood - Login</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body { font-family: Arial, sans-serif; background: #f5f5f5; }

        nav {
            background: #ff6600;
            padding: 15px 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        nav h1 { color: white; margin: 0; }
        nav a {
            color: white;
            text-decoration: none;
            margin-left: 15px;
            font-size: 15px;
        }
        nav a:hover { text-decoration: underline; }

        .form-container {
            max-width: 420px;
            margin: 70px auto;
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        .form-container h2 {
            text-align: center;
            color: #ff6600;
            margin-bottom: 25px;
            font-size: 24px;
        }
        .form-group {
            margin-bottom: 18px;
        }
        .form-group label {
            display: block;
            margin-bottom: 6px;
            color: #555;
            font-size: 14px;
            font-weight: bold;
        }
        .form-group input {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 14px;
            outline: none;
        }
        .form-group input:focus {
            border-color: #ff6600;
        }
        .btn {
            width: 100%;
            padding: 12px;
            background: #ff6600;
            color: white;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            cursor: pointer;
            margin-top: 10px;
        }
        .btn:hover { background: #e65c00; }

        .error-msg {
            background: #ffe0e0;
            color: #cc0000;
            padding: 10px;
            border-radius: 6px;
            margin-bottom: 15px;
            font-size: 14px;
            text-align: center;
            border: 1px solid #ffb3b3;
        }

        .bottom-link {
            text-align: center;
            margin-top: 15px;
            font-size: 14px;
            color: #666;
        }
        .bottom-link a { color: #ff6600; text-decoration: none; }
        .bottom-link a:hover { text-decoration: underline; }

        .logo-icon {
            font-size: 40px;
            text-align: center;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

<nav>
    <h1>TapFood</h1>
    <div>
        <a href="login.jsp">Login</a>
        <a href="register.html">Sign Up</a>
    </div>
</nav>

<div class="form-container">

    <div class="logo-icon">🍽️</div>
    <h2>Welcome Back</h2>

    <%-- Show error message if login failed --%>
    <% if (request.getAttribute("error") != null) { %>
        <div class="error-msg">
            <%= request.getAttribute("error") %>
        </div>
    <% } %>

    <form action="login" method="post">

        <div class="form-group">
            <label>Username</label>
            <input type="text"
                   name="username"
                   placeholder="Enter your username"
                   required/>
        </div>

        <div class="form-group">
            <label>Password</label>
            <input type="password"
                   name="password"
                   placeholder="Enter your password"
                   required/>
        </div>

        <button type="submit" class="btn">Login</button>

        <div class="bottom-link">
            New here? <a href="register.html">Create an account</a>
        </div>

    </form>
</div>

</body>
</html>