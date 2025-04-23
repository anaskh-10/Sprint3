package com.Anas.Pc.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "MarquePc", types = { Pc.class })
public interface PcProjection {
    public String getMarquePc();
}
