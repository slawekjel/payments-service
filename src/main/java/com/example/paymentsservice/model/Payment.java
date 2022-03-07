package com.example.paymentsservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseEntity {

    private String method;
    private String provider;
    private Double sum;
    private String url;
}
