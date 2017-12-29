package com.mborgraeve.arduinoserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
public class ArduinoInstruction {

    @Getter
    @Setter
    @NotNull
    private int id;

    @Getter
    @Setter
    @NotNull
    @Min(5)
    private float instructedTemperature = (float) 19.0;

    @Getter
    @Setter
    @NotNull
    @Min(5)
    private float defaultTemperature = (float) 12.0;

    @Getter
    @Setter
    @NotNull
    private long timelimit = 0;

    @Getter
    @Setter
    @NotNull
    private int cycleDuration = 60;
}
