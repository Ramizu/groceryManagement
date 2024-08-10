package com.example.ManagementSystem.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

public class CategoryDTO {

    @NotEmpty(message = "The name is required")
    private String category_name;

    @NotEmpty(message = "The description is required")
    private String category_desc;

    private Date crt_dt_ts;




    public @NotEmpty(message = "The name is required") String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(@NotEmpty(message = "The name is required") String category_name) {
        this.category_name = category_name;
    }

    public @NotEmpty(message = "The password is required") String getCategory_desc() {
        return category_desc;
    }

    public void setCategory_desc(@NotEmpty(message = "The password is required") String category_desc) {
        this.category_desc = category_desc;
    }

    public Date getCrt_dt_ts() {
        return crt_dt_ts;
    }

    public void setCrt_dt_ts(Date crt_dt_ts) {
        this.crt_dt_ts = crt_dt_ts;
    }


}