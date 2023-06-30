package com.supplier.common;

import com.affaince.subscription.repository.IdGenerator;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultIdGenerator implements IdGenerator {
    @Override
    public String generator() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String generator(String parameterString) {
        return UUID.nameUUIDFromBytes(parameterString.getBytes()).toString();
    }
}
