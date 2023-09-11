package logic.entities;

import lombok.Data;

@Data
public class CreateNewRestaurant {
    private int id;
    private String name;
    private String address;
    private double score;

    public CreateNewRestaurant(int id, String name, String address, double score) {
        this.id =id;
        this.name = name;
        this.address = address;
        this.score = score;
    }
}
