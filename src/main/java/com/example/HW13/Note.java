package com.example.HW13;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    private long id;
    private String title;
    private String content;
}
