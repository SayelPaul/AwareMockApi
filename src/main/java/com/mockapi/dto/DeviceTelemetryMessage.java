package com.mockapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTelemetryMessage {
	
	private String messageType;
	private DeviceTelemetryData deviceTelemetryReport;
}
