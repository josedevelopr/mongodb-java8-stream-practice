package com.restaurant.app.models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Restaurant
{   @Id
    private String id = new ObjectId().toString();
    private String restaurant_id ;
    private Address address;
    private String borough;
    private String cuisine;
    private Grade[] grades;
    private String name;
}
