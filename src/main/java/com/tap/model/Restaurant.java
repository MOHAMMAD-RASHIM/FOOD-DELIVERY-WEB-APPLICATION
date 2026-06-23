package com.tap.model;

public class Restaurant {

    private int restaurantId;
    private String restaurantName;
    private String cuisineType;
    private String address;
    private String phone;
    private double rating;
    private int deliveryTime;
    private boolean isActive;
    private String imagePath;

    public Restaurant() {
    	
    }

    public Restaurant(int restaurantId, String restaurantName, String cuisineType,
                      String address, String phone, double rating,
                      int deliveryTime, boolean isActive, String imagePath)
    {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.cuisineType = cuisineType;
        this.address = address;
        this.phone = phone;
        this.rating = rating;
        this.deliveryTime = deliveryTime;
        this.isActive = isActive;
        this.imagePath = imagePath;
    }

    // Getters and Setters
    public int getRestaurantId() { 
    	return restaurantId; 
    }
    public void setRestaurantId(int restaurantId) { 
    	this.restaurantId = restaurantId; 
    }

    public String getRestaurantName() 
    { 
    	return restaurantName;
    }
    public void setRestaurantName(String restaurantName) 
    { 
    	this.restaurantName = restaurantName;
    }

    public String getCuisineType() 
    {
    	return cuisineType; 
    }
    public void setCuisineType(String cuisineType) 
    { 
    	this.cuisineType = cuisineType; 
    }

    public String getAddress() 
    { 
    	return address; 
    }
    
    public void setAddress(String address)
    { 
    	this.address = address; 
    }

    public String getPhone()
    { 
    	return phone; 
    }
    public void setPhone(String phone) 
    { 
    	this.phone = phone; 
    }

    public double getRating() 
    { 
    	return rating; 
    }
    public void setRating(double rating) 
    { 
    	this.rating = rating;
    }

    public int getDeliveryTime()
    { 
    	return deliveryTime; 
    }
    public void setDeliveryTime(int deliveryTime)
    { 
    	this.deliveryTime = deliveryTime; 
    }

    
    public boolean isActive()
    { 
    	return isActive; 
    }
    public void setActive(boolean isActive)
    {
    	this.isActive = isActive; 
    }

    public String getImagePath() 
    { 
    	return imagePath;
    }
    public void setImagePath(String imagePath) 
    { 
    	this.imagePath = imagePath; 
    }
}