package com.mockapi.dto;

import java.util.List;

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
	private List<TemperatureData> temperature;
	private List<PressureData> pressure;
	private List<HumidityData> humidity;
	private BatteryStatus batteryStatus;

	
	
}
