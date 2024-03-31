package com.example.annotation.webclient.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Albums {

    private Integer userId;
    private Integer id;
    private String title;
}
