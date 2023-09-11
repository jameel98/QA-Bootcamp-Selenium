package logic.entities;


import lombok.Data;

import java.util.List;

@Data
public class AllRestaurants{
    private boolean success;
    private String error;
    private List<Restaurant> data;
}