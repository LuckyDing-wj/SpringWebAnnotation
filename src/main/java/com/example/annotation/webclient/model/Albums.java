package com.example.annotation.webclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Albums {

    private Integer userId;
    private Integer id;
    private String title;
}
