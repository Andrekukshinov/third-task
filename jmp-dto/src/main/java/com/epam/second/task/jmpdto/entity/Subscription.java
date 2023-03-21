package com.epam.second.task.jmpdto.entity;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {
    private Long id;
    private User user;
    private LocalDate startDate;
}
