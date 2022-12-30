package com.mockapi.dto;

import com.mockapi.config.DeviceType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeviceTelemetryData {
	
	private String serialNumber;
	private Integer serverReceivedTimeStamp;
	private Integer deviceReportingTimeStamp;
	private DeviceType deviceType;
	private Integer sequenceNumber;
	private LocationData location;
	private TemperatureData temperature;
	private PressureData pressure;
	private HumidityData humidity;
	private BatteryStatus batteryStatus;

	
	
}
