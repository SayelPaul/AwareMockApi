package com.mockapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BatteryStatus {

	private Integer batteryPercentage;
	private Integer remainingBatteryLife;

}
