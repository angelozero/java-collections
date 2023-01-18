package com.angelozero.collections.service;

import com.angelozero.collections.service.custom_interface.Validator;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Lambda01 {

    public String execute(String name) {

        name = StringUtils.isEmpty(name) ? "Jake" : name;

        Validator<String> validatorName = new Validator<String>() {
            @Override
            public boolean isValid(String value) {

                return value.equalsIgnoreCase("Angelo");
            }
        };

        return String.valueOf(validatorName.isValid(name));
    }
}
