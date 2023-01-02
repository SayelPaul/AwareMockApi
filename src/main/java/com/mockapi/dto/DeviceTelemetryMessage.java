package com.mockapi.dto;

import java.util.List;

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
	private List<DeviceTelemetryData> deviceTelemetryReport;
}
