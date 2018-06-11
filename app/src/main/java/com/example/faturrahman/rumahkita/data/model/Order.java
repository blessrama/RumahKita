package com.example.faturrahman.rumahkita.data.model;

import java.util.List;

public class Order {
    private String orderId;
    private Layanan layanan;
    private String userId;
    private String tukangId;
    private String phone;
    private String description;
    private List<String> descriptionImages;
    private OrderType orderType;
    private long startDuration;
    private long endDuration;
    private double minPrice;
    private double maxPrice;
    private double dealPrice;
    private double longitude;
    private double latitude;
    private String address;
    private String statusId;
    private String statusName;
    private double rating;
    private String review;

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Layanan getLayanan() {
        return layanan;
    }

    public void setLayanan(Layanan layanan) {
        this.layanan = layanan;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTukangId() {
        return tukangId;
    }

    public void setTukangId(String tukangId) {
        this.tukangId = tukangId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDescriptionImages() {
        return descriptionImages;
    }

    public void setDescriptionImages(List<String> descriptionImages) {
        this.descriptionImages = descriptionImages;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public long getStartDuration() {
        return startDuration;
    }

    public void setStartDuration(long startDuration) {
        this.startDuration = startDuration;
    }

    public long getEndDuration() {
        return endDuration;
    }

    public void setEndDuration(long endDuration) {
        this.endDuration = endDuration;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public class Layanan {
        private String id;
        private String name;

        public Layanan() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public class OrderType {
        private String id;
        private String name;

        public OrderType() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
