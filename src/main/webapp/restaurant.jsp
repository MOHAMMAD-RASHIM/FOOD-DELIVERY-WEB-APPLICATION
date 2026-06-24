<%@ page import="java.util.List" %>
<%@ page import="com.tap.model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
    <title>TapFood - Restaurants</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f5f5f5; margin: 0; }
        nav { background: #ff6600; padding: 15px 30px; color: white; 
              display: flex; justify-content: space-between; align-items: center; }
        nav h1 { margin: 0; }
        nav a { color: white; text-decoration: none; margin-left: 15px; }
        .container { padding: 30px; display: flex; flex-wrap: wrap; gap: 20px; }
        .card { background: white; border-radius: 10px; width: 250px;
                box-shadow: 0 2px 8px rgba(0,0,0,0.1); overflow: hidden; }
        .card img { width: 100%; height: 160px; object-fit: cover; }
        .card-body { padding: 15px; }
        .card-body h3 { margin: 0 0 8px 0; color: #333; }
        .card-body p { margin: 4px 0; color: #666; font-size: 14px; }
        .btn { display: block; margin: 10px 15px 15px;
               background: #ff6600; color: white; text-align: center;
               padding: 8px; border-radius: 5px; text-decoration: none; }
        .btn:hover { background: #e65c00; }
    </style>
</head>
<body>

    <nav>
        <h1> TapFood</h1>
        <div>
            <a href="login.jsp">Login</a>
            <a href="register.jsp">Sign Up</a>
        </div>
    </nav>

    <div class="container">
    <%
        List<Restaurant> allRestaurants = 
            (List<Restaurant>) request.getAttribute("allRestaurants");

        if (allRestaurants != null && !allRestaurants.isEmpty()) {
            for (Restaurant restaurant : allRestaurants) {
    %>
        <div class="card">
            <img src="<%= restaurant.getImagePath() %>" 
                 alt="<%= restaurant.getRestaurantName() %>"
                 onerror="this.src='images/default.png'"/>
            <div class="card-body">
                <h3><%= restaurant.getRestaurantName() %></h3>
                <p><%= restaurant.getCuisineType() %></p>
                <p> <%= restaurant.getDeliveryTime() %> mins</p>
                <p><%= restaurant.getRating() %></p>
                <p><%= restaurant.getAddress() %></p>
            </div>
            <a href="menu?restaurantId=<%= restaurant.getRestaurantId() %>" class="btn">View Menu</a>
        </div>
    <%
            }
        } else {
    %>
        <p>No restaurants found.</p>
    <%
        }
    %>
    </div>

</body>
</html>