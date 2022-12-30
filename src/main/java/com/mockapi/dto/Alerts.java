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
public class Alerts {

	private String messageType;
	private String serialNumber;
	private Integer serverReceivedTimeStamp;
	private Integer deviceReportingTimeStamp;
	private Integer shipmentID;
	private DeviceType deviceType;
	private LocationData location;
	private AlertDetails alertDetails;

}
