package com.mockapi.dto;

import com.mockapi.config.DeviceType;
import com.mockapi.config.EventTrigger;
import com.mockapi.config.EventType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlertDetails {
	
	private EventType eventType;
	private EventTrigger eventTrigger;
	private Double val;
	private Double threshold;
	private Integer timeStamp;
	private DeviceType deviceType;
	private String message;
	private Integer duration;

}
