package com.mockapi.dto;

import com.mockapi.config.LocationTechType;
import com.mockapi.config.RadioTechType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationData {
	
	private Double latitude;
	private Double longitude;
	private Integer timeStamp;
	private LocationTechType locationTechType;
	private RadioTechType radioTechType;
	private String operatorName;
	private Integer horizontalUncertainity;
	private Double altitude;
	private Integer altitudeUncertainity;

	
	
}
